package bookShopping.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookShopping.dao.IBookDao;
import bookShopping.model.Book;
import bookShopping.service.IBookService;

@Service
public class BookService implements IBookService {
	
   /*@Autowired @Qualifier("bookDao1")*/
	@Resource(name="bookDao1")
   private IBookDao bookDao=null;
	
	
	/*public IBookDao getBookDao() {
	return bookDao;
}

public void setBookDao(IBookDao bookDao) {
	this.bookDao = bookDao;
}*/

	@Override
	public void addBook(Book b) {
		// TODO Auto-generated method stub
		bookDao.add(b);
	}

	@Override
	public void updateBook(Book b) {
		// TODO Auto-generated method stub
		bookDao.update(b);
	}

	@Override
	public List<Book> getBooks(String conditions) {
		// TODO Auto-generated method stub
		 List<Book> list=null;
		if(conditions==null||conditions.isEmpty())
		{
			String hql="from Book";
		    list=bookDao.list(hql);
		}
		else
		{
			String hql="from Book as b where b.bookName like ?";
			list=bookDao.list(hql,new String[]{conditions});
		}
		return list;
	}

	@Override
	public Book getBookById(long id) {
		// TODO Auto-generated method stub
		Book b=bookDao.load(id);
		return b;
	}

	@Override
	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		 bookDao.delete(id);
	}

}
