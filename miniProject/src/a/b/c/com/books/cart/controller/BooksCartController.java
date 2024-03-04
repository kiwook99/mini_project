package a.b.c.com.books.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.books.cart.service.BooksCartService;
import a.b.c.com.books.cart.vo.BooksCartVO;
import a.b.c.com.books.util.NumUtil;

@Controller
public class BooksCartController {
	Logger logger = LogManager.getLogger(BooksCartController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private BooksCartService booksCartService;		
	
	@RequestMapping(value="booksCartInsert", method=RequestMethod.GET)
	public String booksCartInsert(BooksCartVO bcvo) {	
		logger.info("kosmoCartInsert 함수 진입 >>> : ");	
		
		logger.info("kcvo.getCbnum() >>> : " + bcvo.getCbnum());
		logger.info("kcvo.getPbnum() >>> : " + bcvo.getPbnum());
		logger.info("kcvo.getPbname() >>> : " + bcvo.getPbname());
		logger.info("kcvo.getPbfile() >>> : " + bcvo.getPbfile());
		logger.info("kcvo.getPbprice() >>> : " + bcvo.getPbprice());
		logger.info("kcvo.getPbpricesum() >>> : " + bcvo.getPbpricesum());
		logger.info("kcvo.getPbnum() >>> : " + bcvo.getPbnum());
		logger.info("kcvo.getKmnum() >>> : " + bcvo.getKmnum());
		
		// 서비스 호출
		int nCnt = booksCartService.booksCartInsert(bcvo);
				
		if (nCnt > 0) {
			logger.info("kosmoProductInsert nCnt >>> : " + nCnt);
			return "cart/booksCartInsert";
		}
					
		return "prodcut/booksProductInsert";
	}
	
	// 카트 목록 
	@RequestMapping(value="booksCartSelectAll", method=RequestMethod.GET)
	public String booksCartSelectAll(BooksCartVO bcvo, Model model) {
		logger.info("booksCartSelectAll 함수 진입 >>> : ");
		
		bcvo.setKmnum("1234");
		logger.info("bcvo.getCbnum() >>> : " + bcvo.getKmnum());
		
		// 페이징 처리
		
		// 서비스 호출
		List<BooksCartVO> cartListAll = booksCartService.booksCartSelectAll(bcvo);		
		if (cartListAll.size() > 0) { 
			logger.info("BooksCartController listAll.size() >>> : " + cartListAll.size());		
			model.addAttribute("cartListAll", cartListAll);
			return "cart/booksCartSelectAll";
		}		
		return "cart/booksCartSelectAll";
	}
	
	// 한건 삭제 
	@RequestMapping(value="booksCartDelete", method=RequestMethod.GET)
	public String booksCartDelete(HttpServletRequest req, BooksCartVO bcvo, Model model) {
		logger.info("booksCartDelete 함수 진입 >>> : ");
	
		bcvo.setCbnum(req.getParameter("CbnumV"));
		logger.info("booksCartDelete 함수 진입  bcvo.getCbnum() >>> : " + bcvo.getCbnum());
		
		int nCnt = booksCartService.booksCartDelete(bcvo);		
		if (nCnt > 0) {
			logger.info("booksCartDelete 함수 진입 nCnt >>> : " + nCnt);		
		}		  
		return "cart/booksCartDelete";
	}
	
	
	
	// 선택 삭제, 전체 삭제  
	@RequestMapping(value="booksCartDeleteArray", method=RequestMethod.GET)
	public String booksCartDeleteArray(HttpServletRequest req, BooksCartVO bcvo, Model model) {
		logger.info("booksCartDeleteArray 함수 진입 >>> : ");
	
		String cbnumV[] = req.getParameterValues("Cbnum");
		ArrayList<BooksCartVO> aList = new ArrayList<BooksCartVO>();
		for (int i=0; i < cbnumV.length; i++) {
			BooksCartVO _bcvo = new BooksCartVO();
			_bcvo.setCbnum(cbnumV[i]);
			aList.add(_bcvo);
		}
		
		int nCnt = booksCartService.booksCartDeleteArray(aList);		
		if (nCnt == -1) {
			logger.info("booksCartDeleteArray 함수 진입 nCnt >>> : " + nCnt);
		}	
		return "cart/booksCartDelete";
	}
	
}