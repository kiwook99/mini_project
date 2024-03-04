package a.b.c.com.books.mem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;

//import a.b.c.com.common.CommonUtils;
//import a.b.c.com.common.FileRename;
import a.b.c.com.books.mem.service.BooksMemService;
import a.b.c.com.books.mem.vo.BooksMemVO;

@Controller
public class BooksMemController {
	Logger logger = LogManager.getLogger(BooksMemController.class);
	
	// BoosMemService 연결
	@Autowired(required=false)
	private BooksMemService booksMemService;
	
	// 입력 폼 호출하기
	@RequestMapping(value="booksMemInsertForm", method=RequestMethod.GET)
	public String booksMemInsertForm() {
		logger.info("booksMemInsertForm 함수 진입 >>> : ");
			
		return "mem/booksMemInsertForm";
	}
	
	// 입력
	@RequestMapping(value="booksMemInsert", method=RequestMethod.GET)
	public String booksMemInsert(BooksMemVO bmvo, Model model) {
		logger.info("kosSpringInsert 함수 진입 >>> : ");
		

		int insertCnt = booksMemService.booksMemInsert(bmvo);
		if (insertCnt > 0) {
			logger.info("booksMemService nCnt >>> : " + insertCnt);
			
			model.addAttribute("insertCnt", insertCnt);		
			return "mem/booksMemInsert";	
		}
		
		return "mem/booksMemInsertForm";		
	}
	
	// 아이디 중복 체크
	@RequestMapping(value="booksIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object booksMemIdCheck(BooksMemVO bmvo) {
		logger.info("booksIdCheck 함수 진입 >>> :");		
		logger.info("booksIdCheck bmvo.getMbid()() >>> : " + bmvo.getMbid());			
		
		List<BooksMemVO> list = booksMemService.booksIdCheck(bmvo);			
		logger.info("booksIdCheck list.size() >>> : " + list.size());
		
		String msg = "";		
		if (list.size() == 0) {msg = "ID_YES";}  
		else { msg = "ID_NO";}  
		
		return msg;		
	}
}
