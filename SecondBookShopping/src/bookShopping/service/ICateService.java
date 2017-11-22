package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cate;
import bookShopping.model.Pro;
import bookShopping.tools.Pager;

public interface ICateService {
    public List<Cate> list()throws ShoppingException;
	public void add(Cate c)throws ShoppingException;
	public void delete(long cid)throws ShoppingException;
	public Cate load(long cid)throws ShoppingException;
	public void update(Cate c)throws ShoppingException;
	public Pager<Cate> listByPage(int index,int pageSize)throws ShoppingException;
}
