package a.b.c.com.books.login.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.books.login.dao.BooksLoginDAO;
import a.b.c.com.books.mem.vo.BooksMemVO;

@Service
@Transactional
public class BooksLoginServiceImpl implements BooksLoginService {
	Logger logger = LogManager.getLogger(BooksLoginServiceImpl.class);
			
	@Autowired(required=false)
	private BooksLoginDAO booksLoginDAO;
	
	@Override
	public List<BooksMemVO> loginCheck(BooksMemVO bmvo) {
		logger.info("loginCheck() 함수 진입 >>> : ");
		return booksLoginDAO.loginCheck(bmvo);
	}
	
	public List<BooksMemVO> test_tempIdEmail(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("test_tempIdEmail() 함수 진입 >>> : ");
		return booksLoginDAO.test_tempIdEmail(bmvo);
	}
	
	public List<BooksMemVO> IdCheck(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("IdCheck() 함수 진입 >>> : ");
		return booksLoginDAO.IdCheck(bmvo);
	}

}
