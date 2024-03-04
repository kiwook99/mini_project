package a.b.c.com.books.login.service;

import java.util.List;

import a.b.c.com.books.mem.vo.BooksMemVO;

public interface BooksLoginService {
	
	public List<BooksMemVO> loginCheck(BooksMemVO bmvo);
	public List<BooksMemVO> test_tempIdEmail(BooksMemVO bmvo);
	public List<BooksMemVO> IdCheck(BooksMemVO bmvo);
}
