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
 //ע��dao�����
	private IOrderDao orderDao;

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//��Ӷ����ķ���
	public void add(Order o)throws ShoppingException{
		      orderDao.add(o);
	}
	
	//ͨ��oid��ȡ�����ķ���
	public Order load(long oid)throws ShoppingException{
		return orderDao.load(oid);
	}
	
	//ͨ��uid��ȡ�����б�ķ���
	public List<Order> list(long uid)throws ShoppingException{
		String hql="select o from Order as o where o.User.uid=?";
		List<Order> orders=orderDao.list(hql, uid);
		return orders;
	}
	
	//�����б�ķ�����ҳ
		public Pager<Order> listByPage(int index,int pageSize)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select o from Order as o ";
			Pager<Order> orders=orderDao.find(hql);
			return orders;
		}
		
	//ɾ�������ķ���
		public void delete(long oid)throws ShoppingException{
			orderDao.delete(oid);
		}
}
