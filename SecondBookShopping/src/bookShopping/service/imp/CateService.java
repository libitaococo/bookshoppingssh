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
    //注入DAO层的类
	private ICateDao cateDao;
	public ICateDao getCateDao() {
		return cateDao;
	}
	public void setCateDao(ICateDao cateDao) {
		this.cateDao = cateDao;
	}
	
	@Override
	//业务层获取分类列表的方法
	public List<Cate> list() throws ShoppingException{
		String hql="select c from Cate as c";
		return cateDao.list(hql);
	}
	
	//分类列表的方法分页
		public Pager<Cate> listByPage(int index,int pageSize)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select c from Cate as c";
			Pager<Cate> cates=cateDao.find(hql);
			return cates;
		}
	//业务层添加分类的方法
	public void add(Cate c)throws ShoppingException{
		cateDao.add(c);
	}
	
	//业务层删除分类的方法
	public void delete(long cid)throws ShoppingException{
		cateDao.delete(cid);
	}
	
	//业务层获取分类的方法
	public Cate load(long cid)throws ShoppingException{
		return cateDao.load(cid);
	}
	
	//业务层修改分类的方法
	public void update(Cate c)throws ShoppingException{
		cateDao.update(c);
	}
}
