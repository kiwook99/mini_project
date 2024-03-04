package a.b.c.com.books.order.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.books.order.dao.BooksOrderDAO;
import a.b.c.com.books.order.vo.BooksOrderVO;

@Service
@Transactional
public class BooksOrderServiceImpl implements BooksOrderService {
	Logger logger = LogManager.getLogger(BooksOrderServiceImpl.class);
	
	@Autowired(required=false)
	private BooksOrderDAO booksOrderDAO;

	@Override
	public int booksOrderinsert(BooksOrderVO bovo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
