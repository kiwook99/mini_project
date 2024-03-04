package a.b.c.com.books.login.controller;

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
import org.springframework.web.bind.annotation.RequestBody;

import a.b.c.com.books.util.K_Session;
import a.b.c.com.books.util.PasswordUtil;
import a.b.c.com.books.util.GooglePwMail;
import a.b.c.com.books.login.service.BooksLoginService;
import a.b.c.com.books.mem.vo.BooksMemVO;
import a.b.c.com.books.product.vo.BooksProductVO;

@Controller
public class BooksLoginController {
	Logger logger = LogManager.getLogger(BooksLoginController.class);
	
	@Autowired(required=false)
	private BooksLoginService booksLoginService;
	
	// 로그인 입력 폼 호출
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm() {
		logger.info("BooksLoginController loginForm() 함수진입 >>> : ");
		return "login/booksLoginForm";
	}
	
	// 로그인
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(HttpServletRequest req, BooksMemVO lvo, Model model) {
		logger.info("login() 함수 진입 >>> : ");
		
		String remoteIP = req.getRemoteAddr();
		String remoteHost = req.getRemoteHost();
		String browser = req.getHeader("User-Agent").toUpperCase();
		String browserName = "";
		
		if (browser.indexOf("CHROME") >= 0) {
			browserName = "CHROME";
		} else if (browser.indexOf("SAFARI") >= 0) {
			browserName = "SAFARI";
		} else if (browser.indexOf("EDG") >= 0) {
			browserName = "EDG";
		} else if (browser.indexOf("TRIDENT") >= 0) {
			browserName = "TRIDENT";
		} else if (browser.indexOf("FIREFOX") >= 0) {
			browserName = "FIREFOX";
		} else {
			browserName = "";
		}
		
		logger.info("remoteIP >>> : " + remoteIP);
		logger.info("remoteHost >>> : " + remoteHost);
		logger.info("browser >>> : " + browser);
		logger.info("browserName >>> : " + browserName);
		
		List<String> remoteInfo = new ArrayList<String>();
		remoteInfo.add(remoteIP);
		remoteInfo.add(browserName);
		
		List<BooksMemVO> listLogin = booksLoginService.loginCheck(lvo);
		
		if (listLogin.size() == 1) {
			logger.info("login listLogin.size() >>> : " + listLogin.size());
			
			K_Session ks = K_Session.getInstance();
			String MBID = ks.getSession(req);
			
			if (MBID != null && MBID.equals(listLogin.get(0).getMbid())) {
				logger.info("BooksLoginController login >>> : 로그인 중 >>>  : 다른 페이지로 이동하기 >>> : " + MBID);
			} else {
				ks.setSession(req, lvo.getMbid());
				logger.info("login >>> : 세션부여 하기  >>> : " + lvo.getMbid());
			}
			model.addAttribute("remoteInfo", remoteInfo);
			model.addAttribute("listLogin", listLogin);
			return "login/booksLogin";
		}
		return "login/booksLoginForm";
	}
	
		// 로그 아웃	
		@RequestMapping(value="logout", method=RequestMethod.GET)
		public String logout(HttpServletRequest req, BooksMemVO lvo, Model model) {	
			logger.info("BooksLoginController loginout() 함수 진입 >>> : ");		
										
			K_Session ks = K_Session.getInstance();			
			ks.killSession(req);
			return "login/booksLogout";
		}
	
		// pw 찾기  폼 호출하기 	
		@RequestMapping(value="pwFindForm", method=RequestMethod.GET)
		public String pwFindForm() {	
			logger.info("BooksLoginController pwFindForm() 함수 진입 >>> : ");
			return "login/test_tempPw";
		}
	
		
		// pw 이메일로 보내기  	
		@RequestMapping(value="test_tempPwEmail", method=RequestMethod.GET)
		public String test_tempPwEmail(BooksMemVO lvo, Model model) {	
			logger.info("BooksLoginController test_tempPwEmail() 함수 진입 >>> : ");
			
			// 기욱 메일 주소 
			// parkki4483@naver.com
			String resiveMail = lvo.getMbaddr();
			String tempPw = PasswordUtil.randomPW(6);
			String sendMsg = "<h2 style='color:blue'>" + tempPw + "</h2>";
			
			try {
				
				GooglePwMail gms = new GooglePwMail();
				gms.pwMail(resiveMail, sendMsg);
				
				model.addAttribute("msg", "임시 비밀번호를 확인하시오. !!");
				
			}catch(Exception e) {
				logger.info("BooksLoginController test_tempPwEmail() 에러가  >>> : " + e);
			}
					
			return "login/test_tempPwEmail";
		}	
		
		@RequestMapping(value="idFindForm", method=RequestMethod.GET)
		public String idFindForm() {	
			logger.info("SpingLoginController idFindForm() 함수 진입 >>> : ");
			return "login/test_tempId";
	}
		
		
		@RequestMapping(value="idCheckForm", method=RequestMethod.GET)
		public String idCheckForm() {	
			logger.info("SpingLoginController idCheckForm() 함수 진입 >>> : ");
			return "login/idCheck";
		}
		
		
		@RequestMapping(value="test_tempIdEmail", method=RequestMethod.GET)
		public String test_tempIdEmail(BooksMemVO lvo, Model model) {	
		logger.info("BooksLoginController test_tempIdEmail() 함수 진입 >>> : ");
		List<BooksMemVO> fileloadList = booksLoginService.test_tempIdEmail(lvo);
		int nCnt = fileloadList.size();
		
		if (nCnt > 0) {
			logger.info("kosSpringSelect nCnt >>> : " + nCnt);
			
			model.addAttribute("fileloadList", fileloadList);		
			
			return "login/test_tempIdEmail";	
		}
		return "login/test_tempId";
		}

}