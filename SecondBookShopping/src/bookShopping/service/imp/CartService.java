package bookShopping.service.imp;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ICartDao;
import bookShopping.model.Cart;
import bookShopping.model.Pro;
import bookShopping.service.ICartService;

public class CartService implements ICartService {
	//注入dao层的类
	private ICartDao cartDao;
	
	public ICartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}
     //添加购物车的方法
	public void add(Cart ct)throws ShoppingException{
		cartDao.add(ct);
	}
	
	//删除购物车的方法
	public void delete(long ctid)throws ShoppingException{
		cartDao.delete(ctid);
	}
	
	//通过pid获取购物车的方法
	public List<Cart> listbypid(long pid)throws ShoppingException{
		String hql="select s from Cart as s where s.Pro.pid=? ";
		List<Cart> ct=cartDao.list(hql,pid);
		return ct;
	}
	
	//通过uid获取购物车的方法
		public List<Cart> listbyuid(long uid)throws ShoppingException{
			String hql="select s from Cart as s where s.User.uid=? ";
			List<Cart> ct=cartDao.list(hql,uid);
			return ct;
		}
	
	//更新购物车的方法
	public void update(Cart ct)throws ShoppingException{
		    cartDao.update(ct);
	}
  
}
