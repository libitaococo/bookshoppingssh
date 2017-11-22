package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Pro;
import bookShopping.model.User;
import bookShopping.tools.Pager;

public interface IUserService {
   public User login(User u);
   public User register(User u);
   public void add(User u);
   public List<User> list()throws ShoppingException;
   public void delete(long uid)throws ShoppingException;
   public void update(User u)throws ShoppingException;
   public User load(long uid)throws ShoppingException;
   public Pager<User> listByPage(int index,int pageSize)throws ShoppingException;
}
