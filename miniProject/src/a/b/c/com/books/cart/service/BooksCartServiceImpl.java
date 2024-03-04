package a.b.c.com.books.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.books.cart.dao.BooksCartDAO;
import a.b.c.com.books.cart.vo.BooksCartVO;

@Service
@Transactional
public class BooksCartServiceImpl implements BooksCartService {
	
	Logger logger = LogManager.getLogger(BooksCartServiceImpl.class);
	
	@Autowired(required=false)
	private BooksCartDAO booksCartDAO;

	@Override
	public int booksCartInsert(BooksCartVO bcvo) {
		// TODO Auto-generated method stub		
		logger.info("booksCartInsert 함수 진입 >>> : ");			
		return booksCartDAO.booksCartInsert(bcvo);
	}
	
	@Override
	public List<BooksCartVO> booksCartSelectAll(BooksCartVO bcvo) {
		// TODO Auto-generated method stub
		logger.info("booksCartSelectAll 함수 진입 >>> : ");			
		return booksCartDAO.booksCartSelectAll(bcvo);	
		}
	
	@Override
	public int booksCartDelete(BooksCartVO bcvo) {
		// TODO Auto-generated method stub
		logger.info(" booksCartDelete 진입 >>> : ");
		
		return booksCartDAO.booksCartDelete(bcvo);
	}

	@Override
	public int booksCartDeleteArray(ArrayList<BooksCartVO> aList) {
		// TODO Auto-generated method stub
		logger.info("booksCartDeleteArray 진입 >>> : ");
		
		
		return booksCartDAO.booksCartDeleteArray(aList);
	}
	
}
