package a.b.c.com.books.mem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.books.mem.vo.BooksMemVO;

@Repository
public class BooksMemDAOImpl implements BooksMemDAO {
	Logger logger = LogManager.getLogger(BooksMemDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int booksMemInsert(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("BooksMemInsert 함수 진입 >>> : ");	
		
		return (Integer)sqlSession.insert("booksMemInsert", bmvo);
	}

	@Override
	public List<BooksMemVO> booksMemSelect(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("BooksMemSelect 함수 진입 >>> : ");	
		
		return sqlSession.selectList("booksMemSelect", bmvo);
	}

	@Override
	public List<BooksMemVO> booksIdCheck(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("BooksIdCheck 함수 진입 >>> : ");	
		
		return sqlSession.selectList("booksIdCheck", bmvo);
	}

}
