package bookShopping.model;

//书本实体类
public class Book {
    
	//OID:ojbect identity 对象标识符,把Book声明为持久化的类
	private long id;
    
	private String isbn;
	private String bookName;
	private float price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
