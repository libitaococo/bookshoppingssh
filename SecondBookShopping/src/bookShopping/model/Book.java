package bookShopping.model;

//�鱾ʵ����
public class Book {
    
	//OID:ojbect identity �����ʶ��,��Book����Ϊ�־û�����
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
