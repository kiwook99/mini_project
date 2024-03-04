package a.b.c.com.books.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.books.product.vo.BooksProductVO;

@Repository
public class BooksProductDAOImpl implements BooksProductDAO {

	Logger logger = LogManager.getLogger(BooksProductDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int booksProductInsert(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksProductInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("booksProductInsert", bpvo);
	}

	@Override
	public List<BooksProductVO> booksProductSelectAll(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksProductSelectAll 함수 진입 >>> : ");			
		return sqlSession.selectList("booksProductSelectAll", bpvo);
	}

	@Override
	public List<BooksProductVO> booksProductSelect(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksProductSelect 함수 진입 >>> : ");			
		return sqlSession.selectList("booksProductSelect", bpvo);
	}
	
	@Override
	public List<BooksProductVO> booksProductSelectLogin(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksProductSelectLogin 함수 진입 >>> : ");			
		return sqlSession.selectList("booksProductSelectLogin", bpvo);
	}
	
	@Override
	public List<BooksProductVO> booksSearch(BooksProductVO bpvo) {
		// TODO Auto-generated method stub
		logger.info("booksSearch 함수 진입 >>> : ");			
		return sqlSession.selectList("booksSearch", bpvo);
	}
}
