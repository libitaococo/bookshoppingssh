package bookShopping.service.imp;

import java.util.List;

import org.aspectj.ajdt.internal.compiler.ast.AddAtAspectJAnnotationsVisitor;

import com.sun.scenario.effect.impl.prism.PrTexture;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ICateDao;
import bookShopping.dao.IProDao;
import bookShopping.dao.imp.ProDao;
import bookShopping.model.Cate;
import bookShopping.model.Pro;
import bookShopping.service.IProService;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;

public class ProService implements IProService {
	//注入dao层的类
    private IProDao proDao;
    private ICateDao cateDao;

	public ICateDao getCateDao() {
		return cateDao;
	}

	public void setCateDao(ICateDao cateDao) {
		this.cateDao = cateDao;
	}

	public IProDao getProDao() {
		return proDao;
	}

	public void setProDao(IProDao proDao) {
		this.proDao = proDao;
	}
	
	//商品列表的方法
	public List<Pro> list()throws ShoppingException{
		String hql="select p from Pro as p";
		return proDao.list(hql);
	}
	
	//商品列表的方法分页
	public Pager<Pro> listByPage(int index,int pageSize)throws ShoppingException{
		SystemContext.setPageOffset((index-1)*pageSize);
		SystemContext.setPageSize(pageSize);
		String hql="select p from Pro as p";
		Pager<Pro> pros=proDao.find(hql);
	//	return pros.getDatas();
		return pros;
	}
	
	//public long findCount(){
		//String hql="select count(*) from Pro ";
		//List<Long> list=proDao.find(hql);
	//}

	//商品添加的方法
	public void add(Pro p)throws ShoppingException{
		proDao.add(p);
	}
	
	//商品删除的方法
	public void delete(long pid)throws ShoppingException{
		proDao.delete(pid);
	}
	
	//业务层后台获取商品的方法
	public Pro load1(long pid)throws ShoppingException{
		String hql="select p from Pro as p where p.pid=?";
		return proDao.load(pid);
	}
	
	//业务层获取商品的方法
	public Pro load(long pid)throws ShoppingException{
		String hql="from Pro s left outer join fetch s.comments where s.pid=?";
		List<Pro> pros=proDao.list(hql, pid);
		return pros.get(0);
		//String hql="select p from Pro as p where p.pid=?";
		//return proDao.load(pid);
	}
		
	//业务层修改商品的方法
	public void update(Pro p)throws ShoppingException{
		proDao.update(p);
	}
}
