package com.community.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.community.service.Board_service;
import com.community.service.CM_Service;
import com.community.util.UploadFileUtils;
import com.community.util.pagingAction;
import com.community.vo.CM_BOARD;

@Controller
public class TableController {

	@Resource(name="b_service")
	private Board_service b_service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="pageAction")
	private pagingAction page;
	
	
	@GetMapping("tableList")
	public String Tables() {
		return "tableList.c";
	}
	@GetMapping("tableInsert")
	public String Table_Insert() {
		return "tableInsert.c";
	}
	@GetMapping("tableDetailView")
	public void tableDetailView() {}
	@PostMapping("tableDetailView")
	public String DetailView_post(String b_num,Model model,String U_check) {
		CM_BOARD board = b_service.TableDtailView(b_num);
		System.out.println(U_check);
		if(U_check.equals("2")) {
			b_service.up_PopularCount(b_num);
			System.out.println("추천");
		}else if(U_check.equals("3")){
			b_service.down_PopularCount(b_num);
			System.out.println("비추천");
		}
		
		model.addAttribute("board",board);	
		return "tableDetailView.c";
	}
	@PostMapping("tableUpdateView")
	public String UpdateView(String b_num,String U_check,Model model) {
		CM_BOARD arr = b_service.TableDtailView(b_num);
		model.addAttribute("arr",arr);
		return "tableUpdateView.c";
	}

	@PostMapping("fileUpload_post")
	public String board_Insert(CM_BOARD board,String check,MultipartFile file,HttpServletRequest req) throws IOException, Exception {
		if(check.equals("1")) {
			System.out.println("insert");
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = null;
			if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
				board.setB_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				board.setB_thumbimg(File.separator + "imgUpload" +ymdPath + File.separator + "s" + File.separator + "s_" +fileName);
			}else {
				fileName = "";
				board.setB_img(fileName);
				board.setB_thumbimg(fileName);
			}
			
			b_service.Board_Insert(board);
		}
		if(check.equals("2")) {
			System.out.println("update");
			if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				new File(uploadPath + req.getParameter("B_IMG")).delete();
				new File(uploadPath + req.getParameter("B_THUMBIMG")).delete();
				
				String imgUploadPath = uploadPath + File.separator + "imgUpload";
				String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
				String fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
			
				board.setB_img(File.separator + "imgUpload" + ymdPath + File.separator + ymdPath);
				board.setB_thumbimg(File.separator + "imgUpload" +ymdPath + File.separator + "s" + File.separator + "s_" +fileName);
				
			}else {
				board.setB_img(req.getParameter("B_IMG"));
				board.setB_thumbimg(req.getParameter("B_THUMBIMG"));
			}
			b_service.Board_Update(board);
		}
		if(check.equals("3")) {
			b_service.report_count(board.getB_num());
		}

		return "tableList.c";
	}
	
	@PostMapping("tableList")
	public String TableList(Model model,String pageNum,String word) {
		word = word == null ? "" : word;
		String PageHtml;
		if(pageNum == null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = b_service.TableCount(word);
		int pageSize = 5;
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		if (endRow > count)
			endRow = count;
		int boardNum = ((currentPage - 1) * pageSize);
		PageHtml = page.paging(count, pageSize, currentPage, word);
		List<CM_BOARD> arr = b_service.TableList(startRow,endRow,word);
		model.addAttribute("pageHtml",PageHtml);
		model.addAttribute("boardNum",boardNum);
		model.addAttribute("arr",arr);
		return "CallBackPage/TableListCallBack";
	}
}
