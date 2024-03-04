package a.b.c.com.books.mem.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.books.mem.dao.BooksMemDAO;
import a.b.c.com.books.mem.vo.BooksMemVO;

@Service
@Transactional
public class BooksMemServiceImpl implements BooksMemService {
	private Logger logger = LogManager.getLogger(BooksMemServiceImpl.class);
	
	@Autowired(required=false)
	private BooksMemDAO booksMemDAO;
	
	@Override
	public int booksMemInsert(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("BooksMemInsert() 함수 진입 >>> : ");
		
		return booksMemDAO.booksMemInsert(bmvo);
	}

	@Override
	public List<BooksMemVO> booksMemSelect(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("BooksMemSelect() 함수 진입 >>> : ");
		
		return booksMemDAO.booksMemSelect(bmvo);
	}

	@Override
	public List<BooksMemVO> booksIdCheck(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("BooksIdCheck() 함수 진입 >>> : ");
		
		return booksMemDAO.booksIdCheck(bmvo);
	}

}
