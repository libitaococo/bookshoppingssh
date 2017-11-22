package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Pro;
import bookShopping.tools.Pager;
//管理员的业务层接口
public interface IAdminService {
  public Admin login(Admin a);
  public List<Admin> list()throws ShoppingException;
  public void add(Admin a)throws ShoppingException;
  public void delete(long id)throws ShoppingException;
  public void update(Admin a)throws ShoppingException;
  public Admin load(long id)throws ShoppingException;
  public Pager<Admin> listByPage(int index,int pageSize)throws ShoppingException;
}
