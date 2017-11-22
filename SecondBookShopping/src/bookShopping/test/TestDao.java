package bookShopping.test;





import javax.annotation.Resource;

import org.junit.Test;

import bookShopping.dao.IBookDao;
import bookShopping.model.Book;






public class TestDao  extends BaseDAOTestCaseJunit44 {
	
	@Resource
	private IBookDao bookDao;

	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Test
	public void testAdd()
	{
		Book b=new Book();
		b.setBookName("java");
		b.setIsbn("12345");
		b.setPrice(12.34f);
		bookDao.add(b);
	}
	
	
	public void loadBook()
	{
		Book b=bookDao.load(1);
		System.out.println(b.getBookName()+"  "+b.getPrice());
	}
	
	
	public void updateBook()
	{
		Book b=bookDao.load(1);
		b.setPrice(48.45f);
		bookDao.update(b);
	}
	
/*	@Resource
	private IBookService bookService;
	
	
	
	
	
	public IBookService getBookService() {
		return bookService;
	}


	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@Test
	public void testJson()
	{
		try
		{
			//long id=1;
			//Book b=bookService.loadBook(id);
			//System.out.println(b.getBookName());
			//bookService.deleteBook(b);
			//bookService.deleteBook(2);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}*/
	
	
	
	
	
}
