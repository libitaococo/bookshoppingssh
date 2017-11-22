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
	//ע��dao�����
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
	
	//��Ʒ�б�ķ���
	public List<Pro> list()throws ShoppingException{
		String hql="select p from Pro as p";
		return proDao.list(hql);
	}
	
	//��Ʒ�б�ķ�����ҳ
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

	//��Ʒ��ӵķ���
	public void add(Pro p)throws ShoppingException{
		proDao.add(p);
	}
	
	//��Ʒɾ���ķ���
	public void delete(long pid)throws ShoppingException{
		proDao.delete(pid);
	}
	
	//ҵ����̨��ȡ��Ʒ�ķ���
	public Pro load1(long pid)throws ShoppingException{
		String hql="select p from Pro as p where p.pid=?";
		return proDao.load(pid);
	}
	
	//ҵ����ȡ��Ʒ�ķ���
	public Pro load(long pid)throws ShoppingException{
		String hql="from Pro s left outer join fetch s.comments where s.pid=?";
		List<Pro> pros=proDao.list(hql, pid);
		return pros.get(0);
		//String hql="select p from Pro as p where p.pid=?";
		//return proDao.load(pid);
	}
		
	//ҵ����޸���Ʒ�ķ���
	public void update(Pro p)throws ShoppingException{
		proDao.update(p);
	}
}
