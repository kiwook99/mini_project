package a.b.c.com.books.mem.service;

import java.util.List;

import a.b.c.com.books.mem.vo.BooksMemVO;

public interface BooksMemService {
	
	public int booksMemInsert(BooksMemVO bmvo);
	public List<BooksMemVO> booksMemSelect(BooksMemVO bmvo);
	
	// 아이디 중복 체크
	public List<BooksMemVO> booksIdCheck(BooksMemVO bmvo);
}
