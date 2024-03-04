package a.b.c.com.books.cart.service;

import java.util.ArrayList;
import java.util.List;

import a.b.c.com.books.cart.vo.BooksCartVO;

public interface BooksCartService {
	
	public List<BooksCartVO> booksCartSelectAll(BooksCartVO bcvo);
	public int booksCartDelete(BooksCartVO bcvo);
	public int booksCartDeleteArray(ArrayList<BooksCartVO> aList);
	
	public int booksCartInsert(BooksCartVO bcvo);

}
