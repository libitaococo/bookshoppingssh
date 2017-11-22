package bookShopping.service.imp;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IOrderdataDao;
import bookShopping.model.Orderdata;
import bookShopping.model.Pro;
import bookShopping.service.IOrderdataService;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;

public class OrderdataService implements IOrderdataService {
	
	//注入dao层的类
	private IOrderdataDao orderdataDao;

	public IOrderdataDao getOrderdataDao() {
		return orderdataDao;
	}

	public void setOrderdataDao(IOrderdataDao orderdataDao) {
		this.orderdataDao = orderdataDao;
	}
	
	//订单详情添加
	public void add(Orderdata od)throws ShoppingException{
		     orderdataDao.add(od);
	}
	
	//订单详情的列表执行方法
	public List<Orderdata> listbyoid(long oid)throws ShoppingException{
		String hql="select od from Orderdata as od where od.oid=?";
		List<Orderdata> ods=orderdataDao.list(hql, oid);
		return ods;
	}
	
	//商品列表的方法分页
		public Pager<Orderdata> listByPage(int index,int pageSize,long oid)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select od from Orderdata as od  where od.oid=?";
			Pager<Orderdata> ods=orderdataDao.find(hql,oid);
			return ods;
		}

}
