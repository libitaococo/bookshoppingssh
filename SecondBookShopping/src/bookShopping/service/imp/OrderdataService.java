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
	
	//ע��dao�����
	private IOrderdataDao orderdataDao;

	public IOrderdataDao getOrderdataDao() {
		return orderdataDao;
	}

	public void setOrderdataDao(IOrderdataDao orderdataDao) {
		this.orderdataDao = orderdataDao;
	}
	
	//�����������
	public void add(Orderdata od)throws ShoppingException{
		     orderdataDao.add(od);
	}
	
	//����������б�ִ�з���
	public List<Orderdata> listbyoid(long oid)throws ShoppingException{
		String hql="select od from Orderdata as od where od.oid=?";
		List<Orderdata> ods=orderdataDao.list(hql, oid);
		return ods;
	}
	
	//��Ʒ�б�ķ�����ҳ
		public Pager<Orderdata> listByPage(int index,int pageSize,long oid)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select od from Orderdata as od  where od.oid=?";
			Pager<Orderdata> ods=orderdataDao.find(hql,oid);
			return ods;
		}

}
