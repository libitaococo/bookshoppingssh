package bookShopping.service.imp;


import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ICateDao;
import bookShopping.model.Cate;
import bookShopping.model.Pro;
import bookShopping.service.ICateService;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;

public class CateService implements ICateService {
    //ע��DAO�����
	private ICateDao cateDao;
	public ICateDao getCateDao() {
		return cateDao;
	}
	public void setCateDao(ICateDao cateDao) {
		this.cateDao = cateDao;
	}
	
	@Override
	//ҵ����ȡ�����б�ķ���
	public List<Cate> list() throws ShoppingException{
		String hql="select c from Cate as c";
		return cateDao.list(hql);
	}
	
	//�����б�ķ�����ҳ
		public Pager<Cate> listByPage(int index,int pageSize)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select c from Cate as c";
			Pager<Cate> cates=cateDao.find(hql);
			return cates;
		}
	//ҵ�����ӷ���ķ���
	public void add(Cate c)throws ShoppingException{
		cateDao.add(c);
	}
	
	//ҵ���ɾ������ķ���
	public void delete(long cid)throws ShoppingException{
		cateDao.delete(cid);
	}
	
	//ҵ����ȡ����ķ���
	public Cate load(long cid)throws ShoppingException{
		return cateDao.load(cid);
	}
	
	//ҵ����޸ķ���ķ���
	public void update(Cate c)throws ShoppingException{
		cateDao.update(c);
	}
}
