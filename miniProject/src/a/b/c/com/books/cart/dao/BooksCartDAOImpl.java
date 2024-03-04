package a.b.c.com.books.cart.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.books.cart.vo.BooksCartVO;

@Repository
public class BooksCartDAOImpl implements BooksCartDAO {
	
	Logger logger = LogManager.getLogger(BooksCartDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<BooksCartVO> booksCartSelectAll(BooksCartVO bcvo) {
		// TODO Auto-generated method stub
		logger.info("booksCartSelectAll 함수 진입 >>> : ");			
		return sqlSession.selectList("booksCartSelectAll", bcvo);
	}
	
	@Override
	public int booksCartDelete(BooksCartVO bcvo) {
		// TODO Auto-generated method stub
		logger.info(" booksCartDelete 진입 >>> : ");
		
		return (Integer)sqlSession.update("booksCartDelete", bcvo);
	}

	@Override
	public int booksCartDeleteArray(ArrayList<BooksCartVO> aList) {
		// TODO Auto-generated method stub
		logger.info("booksCartDeleteArray 진입 >>> : ");
		
		return (Integer)sqlSession.update("booksCartDelete", aList);
	}
	
	@Override
	public int booksCartInsert(BooksCartVO bcvo) {
		// TODO Auto-generated method stub
			
		return (Integer)sqlSession.insert("booksCartInsert", bcvo);
	}
	
}
