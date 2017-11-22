package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Order;
import bookShopping.model.Pro;
import bookShopping.tools.Pager;

public interface IOrderService {
	public void add(Order o)throws ShoppingException;
	public Order load(long oid)throws ShoppingException;
    public Pager<Order> listByPage(int index,int pageSize)throws ShoppingException;
    public List<Order> list(long uid)throws ShoppingException;
    public void delete(long oid)throws ShoppingException;
}
