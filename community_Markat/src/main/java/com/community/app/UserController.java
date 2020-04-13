package com.community.app;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.community.service.CM_Service;
import com.community.util.UploadFileUtils;
import com.community.vo.CM_USERINFO;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="c_service")
	private CM_Service c_service;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@PostMapping("idChk")
	@ResponseBody
	public int idChk(CM_USERINFO userinfo) {
		logger.info("아이디 중복확인 실행");
		logger.info("회원가입 할 아이디 = "+ userinfo.getUser_id());
		int result = c_service.idChk(userinfo);
		return result;
	}


	@GetMapping("C_Login")
	public void Login() {
		logger.info("로그인 view 실행");
	}
	@GetMapping("C_Join")
	public void Join() {
		logger.info("회원가입 view 실행");
	}
	@PostMapping("myPage")
	public String mypage(CM_USERINFO userinfo,Model model) {
		logger.info("마이페이지 view 실행");
		CM_USERINFO LIST = c_service.UserInformation(userinfo);
		model.addAttribute("USER",LIST);
		return "myPage.c";
	}
	//회원가입
	@PostMapping("User_Join")
	public String User_Join(CM_USERINFO userinfo) {
		logger.info("회원가입 실행");
		int result = c_service.idChk(userinfo);
		if(result == 1) {
			return "C_Login.s";
		}else if(result == 0) {
			String inputPass = userinfo.getUser_pwd();
			String pwd = pwdEncoder.encode(inputPass);
			userinfo.setUser_pwd(pwd);
			c_service.UserJoin(userinfo);
		}
		return "C_Login.s";
	}
	// 회원 로그인
	@PostMapping("User_Login")
	public String User_Login(CM_USERINFO userinfo,HttpSession session,Model model) {
		logger.info("로그인 실행");
		CM_USERINFO login = c_service.UserLogin(userinfo);
		boolean pwdMatch = pwdEncoder.matches(userinfo.getUser_pwd(), login.getUser_pwd());
		if(login != null && pwdMatch == true) {
			session.setAttribute("session_id", userinfo.getUser_id());
			return "index.c";
		}
		return "C_Login.s";
	}
	// 회원 로그아웃
	@GetMapping("Logout")
	public String UserLogout(HttpSession session) {
		logger.info("로그아웃 실행");
		session.invalidate();
		return "index.c";
	}
	//회원정보수정
	@PostMapping("UserUpdate")
	public String UserUpdate(CM_USERINFO userinfo,HttpSession session,MultipartFile file,HttpServletRequest req) throws IOException, Exception {
		String inputPass = userinfo.getUser_pwd();
		String pwd = pwdEncoder.encode(inputPass);
		userinfo.setUser_pwd(pwd);
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(uploadPath + req.getParameter("user_img")).delete();
			new File(uploadPath + req.getParameter("user_thumbimg")).delete();

			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
			userinfo.setUser_img(File.separator + "imgUpload" + ymdPath + File.separator + ymdPath);
			userinfo.setUser_thumbimg(File.separator + "imgUpload" +ymdPath + File.separator + "s" + File.separator + "s_" +fileName);
		}else {
			userinfo.setUser_img(req.getParameter("user_img"));
			userinfo.setUser_thumbimg(req.getParameter("user_thumbimg"));
		}
		c_service.UserUpdate(userinfo);
		session.invalidate();
		return "redirect:/";
	}
}
