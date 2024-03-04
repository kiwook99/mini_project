package a.b.c.com.books.product.service;

import java.util.List;

import a.b.c.com.books.product.vo.BooksProductVO;

public interface BooksProductService {
	
	public int booksProductInsert(BooksProductVO bpvo);
	public List<BooksProductVO> booksProductSelectAll(BooksProductVO bpvo);
	public List<BooksProductVO> booksProductSelect(BooksProductVO bpvo);
	public List<BooksProductVO> booksProductSelectLogin(BooksProductVO bpvo);
	public List<BooksProductVO> booksSearch(BooksProductVO bpvo);
}

