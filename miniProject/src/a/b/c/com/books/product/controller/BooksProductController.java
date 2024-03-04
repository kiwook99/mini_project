package a.b.c.com.books.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;

import a.b.c.com.books.product.service.BooksProductService;
import a.b.c.com.books.product.vo.BooksProductVO;
import a.b.c.com.books.util.CommonUtils;
import a.b.c.com.books.util.FileRename;

@Controller
public class BooksProductController {
	Logger logger = LogManager.getLogger(BooksProductController.class);
	
	// 필드 오토와이어 DI 의존성 주입
	// new, set, 필드의 기능을 한번에 수행
	@Autowired(required=false)
	private BooksProductService booksProductService;
	
	// 상품 입력 폼
	@RequestMapping(value="booksProductInsertForm", method=RequestMethod.GET)
	public String booksProductInsertForm() {
	logger.info("booksProductInsertForm 함수 진입 >>> : ");	
	return "product/booksProductInsertForm";
	}
	
	// 상품 입력 
	// HttpServletRequest : request
	@RequestMapping(value="booksProductInsert", method=RequestMethod.POST)
	public String booksProductInsert(HttpServletRequest req) {	
	logger.info("booksProductInsert 함수 진입 >>> : ");	
	
	String filePath = CommonUtils.PRODUCT_IMG_UPLOAD_PATH;
	int imgfileSize = CommonUtils.PRODUCT_IMG_FILE_SIZE;		
	String encodeType = CommonUtils.PRODUCT_ENCODE;
	
	try {
		// MultipartRequest : 파일 업로드 방법
	MultipartRequest mr = new MultipartRequest(	req, 
												filePath, 
												imgfileSize, 
												encodeType, 
												new FileRename());
		
		BooksProductVO _bpvo = null;
		_bpvo = new BooksProductVO();
					
		_bpvo.setPbnum(mr.getParameter("pbnum"));
		_bpvo.setPbname(mr.getParameter("pbname"));
		_bpvo.setPbgenre(mr.getParameter("pbgenre"));
		_bpvo.setPbcompany(mr.getParameter("pbcompany"));
		
		_bpvo.setPbfile(mr.getFilesystemName("pbfile"));
		
		_bpvo.setPbcnt(mr.getParameter("pbcnt"));
		_bpvo.setPbprice(mr.getParameter("pbprice"));
		_bpvo.setPbdesc(mr.getParameter("pbdesc"));
		_bpvo.setUpdatedate(mr.getParameter("updatedate"));
		
		// 서비스 호출
		int nCnt = booksProductService.booksProductInsert(_bpvo);
		logger.info("booksProductInsert nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "product/booksProductInsert";}
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		logger.info("파일 업로드 중 에러가  >>> : " + e.getMessage());
	}	
	return "product/booksProductInsertForm";
	}
	
	
	@RequestMapping(value="booksProductSelect", method=RequestMethod.GET)
	public String bookProductSelect(BooksProductVO bpvo, Model model) {
	logger.info("bookProductSelect 함수 진입 >>> : ");
	
	logger.info("kosmoProductSelect 함수 진입::: kpvo.getKpnum() >>> : " + bpvo.getPbnum());
	
	List<BooksProductVO> listAll = booksProductService.booksProductSelect(bpvo);		
	if (listAll.size() > 0) { 
		logger.info("bookProductSelect listAll.size() >>> : " + listAll.size());
		
		model.addAttribute("listAll", listAll);
		return "product/booksProductSelect";
	}		
	return "product/booksProductInsertForm";
}
	
	// 메인페이지
	@RequestMapping(value="booksProductSelectAll", method=RequestMethod.GET)
	public String booksProductSelectAll(BooksProductVO bpvo, Model model) {
		logger.info("booksProductSelectAll 함수 진입 >>> : ");
		
		
		// 서비스 호출
		List<BooksProductVO> listAll = booksProductService.booksProductSelectAll(bpvo);		
		if (listAll.size() > 0) { 
			logger.info("booksProductSelectAll listAll.size() >>> : " + listAll.size());
	
			model.addAttribute("listAll", listAll);
			return "product/mini_mainPage";
		}		
		return "product/booksProductInsertForm";
	}
	
	// 검색
		@RequestMapping(value="booksSearch", method=RequestMethod.GET)
		public String booksSearch(BooksProductVO bpvo, Model model) {
      logger.info("booksSearch bpvo.getSearchFilter() >>> : " + bpvo.getSearchFilter());
      logger.info("booksSearch bpvo.getKeyword() >>> : " + bpvo.getKeyword());
      
      List<BooksProductVO> searchList = booksProductService.booksSearch(bpvo);
      
      int nCnt = searchList.size();

		if (nCnt > 0) {
			logger.info("booksSearch nCnt >>> : " + nCnt);
			
			model.addAttribute("searchList",searchList);
			return "product/booksSearch";

	}
		return "product/mini_mainPage";
	}

		
		
		// FAQ 호출
		@RequestMapping("boardSelect")
		public String boardSelect() {
			logger.info("boardSelect() 진입 >>> : ");
			return "board/boardSelect";
		}
}