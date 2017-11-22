package bookShopping.service.imp;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ICartDao;
import bookShopping.model.Cart;
import bookShopping.model.Pro;
import bookShopping.service.ICartService;

public class CartService implements ICartService {
	//ע��dao�����
	private ICartDao cartDao;
	
	public ICartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}
     //��ӹ��ﳵ�ķ���
	public void add(Cart ct)throws ShoppingException{
		cartDao.add(ct);
	}
	
	//ɾ�����ﳵ�ķ���
	public void delete(long ctid)throws ShoppingException{
		cartDao.delete(ctid);
	}
	
	//ͨ��pid��ȡ���ﳵ�ķ���
	public List<Cart> listbypid(long pid)throws ShoppingException{
		String hql="select s from Cart as s where s.Pro.pid=? ";
		List<Cart> ct=cartDao.list(hql,pid);
		return ct;
	}
	
	//ͨ��uid��ȡ���ﳵ�ķ���
		public List<Cart> listbyuid(long uid)throws ShoppingException{
			String hql="select s from Cart as s where s.User.uid=? ";
			List<Cart> ct=cartDao.list(hql,uid);
			return ct;
		}
	
	//���¹��ﳵ�ķ���
	public void update(Cart ct)throws ShoppingException{
		    cartDao.update(ct);
	}
  
}
