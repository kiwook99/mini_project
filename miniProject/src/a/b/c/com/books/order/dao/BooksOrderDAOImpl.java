package a.b.c.com.books.order.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.books.order.vo.BooksOrderVO;

@Repository
public class BooksOrderDAOImpl implements BooksOrderDAO {
	Logger logger = LogManager.getLogger(BooksOrderDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int booksOrderInsert(BooksOrderVO bovo) {
		// TODO Auto-generated method stub

		return 0;
	}

}
