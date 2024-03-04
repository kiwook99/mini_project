package a.b.c.com.books.product.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.books.product.dao.BooksProductDAO;
import a.b.c.com.books.product.vo.BooksProductVO;

@Service
@Transactional
public class BooksProductServiceImpl implements BooksProductService {
	Logger logger = LogManager.getLogger(BooksProductServiceImpl.class);
	
	@Autowired(required=false)
	private BooksProductDAO booksProductDAO;
	
	@Override
	public int booksProductInsert(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		
		logger.info("booksProductInsert 함수 진입 >>> : ");			
		return booksProductDAO.booksProductInsert(bpvo);
	}

	@Override
	public List<BooksProductVO> booksProductSelectAll(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksProductSelectAll 함수 진입 >>> : ");			
		return booksProductDAO.booksProductSelectAll(bpvo);
	}

	@Override
	public List<BooksProductVO> booksProductSelect(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksProductSelect 함수 진입 >>> : ");			
		return booksProductDAO.booksProductSelect(bpvo);
	}

	@Override
	public List<BooksProductVO> booksProductSelectLogin(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksProductSelectLogin 함수 진입 >>> : ");			
		return booksProductDAO.booksProductSelectLogin(bpvo);
	}
	
	@Override
	public List<BooksProductVO> booksSearch(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksSearch 함수 진입 >>> : ");			
		return booksProductDAO.booksSearch(bpvo);
	}

}
