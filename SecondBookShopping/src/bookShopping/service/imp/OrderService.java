package bookShopping.service.imp;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IOrderDao;
import bookShopping.model.Order;
import bookShopping.model.Pro;
import bookShopping.service.IOrderService;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;

public class OrderService implements IOrderService {
 //注入dao层的类
	private IOrderDao orderDao;

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//添加订单的方法
	public void add(Order o)throws ShoppingException{
		      orderDao.add(o);
	}
	
	//通过oid获取订单的方法
	public Order load(long oid)throws ShoppingException{
		return orderDao.load(oid);
	}
	
	//通过uid获取订单列表的方法
	public List<Order> list(long uid)throws ShoppingException{
		String hql="select o from Order as o where o.User.uid=?";
		List<Order> orders=orderDao.list(hql, uid);
		return orders;
	}
	
	//订单列表的方法分页
		public Pager<Order> listByPage(int index,int pageSize)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select o from Order as o ";
			Pager<Order> orders=orderDao.find(hql);
			return orders;
		}
		
	//删除订单的方法
		public void delete(long oid)throws ShoppingException{
			orderDao.delete(oid);
		}
}
