package a.b.c.com.books.order.controller;

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

import a.b.c.com.books.order.service.BooksOrderService;


@Controller
public class BooksOrderController {
	Logger logger = LogManager.getLogger(BooksOrderController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)	
	private BooksOrderService booksOrderService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private BooksCartService booksCartService;
	
	// 주문 입력 폼
	@RequestMapping(value="booksOrderInsertForm", method=RequestMethod.GET)
	public String booksOrderInsertForm(BooksCartVO bcvo, Model model) {
		logger.info("BooksOrderController BooksOrderInsertForm 함수 진입 >>> : ");	
		
		logger.info("bcvo.getCbnum() >>> : " + bcvo.getCbnum());
		logger.info("bcvo.getPbname() >>> : " + bcvo.getPbname());
		logger.info("bcvo.getPbfile() >>> : " + bcvo.getPbfile());
		logger.info("bcvo.getPbcnt() >>> : " + bcvo.getPbcnt());
		bcvo.setPbprice(NumUtil.comma_replace(bcvo.getPbprice()));
		logger.info("bcvo.getPbprice() >>> : " + bcvo.getPbprice());
		bcvo.setPbpricesum(NumUtil.comma_replace(bcvo.getPbpricesum()));
		logger.info("bcvo.getPbpricesum() >>> : " + bcvo.getPbpricesum());
		logger.info("bcvo.getPbnum() >>> : " + bcvo.getPbnum());
		logger.info("bcvo.getKmnum() >>> : " + bcvo.getKmnum());
		
		// 서비스 호출
		
		return "order/booksOrderInsertForm";
	}
	
	// 주문하기  
	@RequestMapping(value="booksOrderInsert", method=RequestMethod.POST)
	public String booksOrderInsert(HttpServletRequest req) {	
		logger.info("BooksOrderController booksOrderInsert 함수 진입 >>> : ");	
		
		// 채번 구하기
		
		// 서비스 호출
		int nCnt = 0;
		
		
		return "#product/booksProductInsertForm";
	}	
}
