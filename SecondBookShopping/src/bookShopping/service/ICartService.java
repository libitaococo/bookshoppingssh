package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cart;

public interface ICartService {
	public void add(Cart ct)throws ShoppingException;
	public void delete(long ctid)throws ShoppingException;
	public List<Cart> listbypid(long pid)throws ShoppingException;
	public void update(Cart ct)throws ShoppingException;
	public List<Cart> listbyuid(long uid)throws ShoppingException;
}
