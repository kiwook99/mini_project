package a.b.c.com.books.login.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.books.mem.vo.BooksMemVO;

@Repository
public class BooksLoginDAOImpl implements BooksLoginDAO {
	Logger logger = LogManager.getLogger(BooksLoginDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BooksMemVO> loginCheck(BooksMemVO bmvo) {
		logger.info("loginCheck() 함수 진입 >>> : ");
		return sqlSession.selectList("loginCheck", bmvo);
	}
	
	@Override
	public List<BooksMemVO> test_tempIdEmail(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("loginCheck() 함수 진입 >>> : ");
		

		return sqlSession.selectList("test_tempIdEmail", bmvo);
	}
	
	@Override
	public List<BooksMemVO> IdCheck(BooksMemVO bmvo) {
		// TODO Auto-generated method stub
		logger.info("IdCheck() 함수 진입 >>> : ");
		

		return sqlSession.selectList("IdCheck", bmvo);
	}

}
