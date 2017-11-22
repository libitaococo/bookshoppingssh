package bookShopping.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bookShopping.model.Book;
import bookShopping.service.IBookService;

@Controller
public class BookAction extends BaseAction {
	
	@Autowired
	private IBookService bookService=null;
	private long id;
	
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

    public String delete()
    {
    	bookService.deleteBook(id);
    	return RELOAD;
    }

	public String list()
    {
    	List<Book> list=bookService.getBooks(null);
    	
    	//把获取到的数据放在page内置对象中
    	putContext("bookList", list);
    	
    	return LIST;
    }
}
