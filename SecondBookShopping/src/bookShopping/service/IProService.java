package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cate;
import bookShopping.model.Pro;
import bookShopping.tools.Pager;

public interface IProService {
    public List<Pro> list()throws ShoppingException;
    public void add(Pro p)throws ShoppingException;
    public void delete(long pid)throws ShoppingException;
    public Pro load(long pid)throws ShoppingException;
    public Pro load1(long pid)throws ShoppingException;
    public void update(Pro p)throws ShoppingException;
    public Pager<Pro> listByPage(int index,int pageSize)throws ShoppingException;
    //public long findCount();
}