package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Orderdata;
import bookShopping.model.Pro;
import bookShopping.tools.Pager;

public interface IOrderdataService {
	public void add(Orderdata od)throws ShoppingException;
	public Pager<Orderdata> listByPage(int index,int pageSize,long oid)throws ShoppingException;
    public  List<Orderdata> listbyoid(long oid)throws ShoppingException;
}
