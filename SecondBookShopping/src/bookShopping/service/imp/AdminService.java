package bookShopping.service.imp;


import java.util.List;

import org.omg.CORBA.Object;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IAdminDao;
import bookShopping.dao.imp.AdminDao;
import bookShopping.model.Admin;
import bookShopping.model.Pro;
import bookShopping.service.IAdminService;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;
//管理员的业务层实现类
public class AdminService implements IAdminService{
  //注入dao层类
	private IAdminDao adminDao;

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
   //业务层的管理员列表的方法
	public List<Admin> list() throws ShoppingException {
		String hql="select a from Admin as a";
		return adminDao.list(hql);
	}
  
	//管理员列表的方法分页
		public Pager<Admin> listByPage(int index,int pageSize)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select a from Admin as a";
			Pager<Admin> admins=adminDao.find(hql);
			return admins;
		}
	
   //业务层管理员添加的方法
	public void add(Admin a)throws ShoppingException{
		adminDao.add(a);
	}
	
	//业务层管理员的删除的方法
	public void delete(long id)throws ShoppingException{
		adminDao.delete(id);
	}
	
	//业务层获取管理员的的方法
	public Admin load(long id)throws ShoppingException{
		return adminDao.load(id);
	}
	
	//业务层修改管理员的方法
	public void update(Admin a)throws ShoppingException{
		adminDao.update(a);
	}
   //业务层的登录的方法
	public Admin login(Admin a){
		String hql="from Admin where adminname='"+a.getAdminname()+"' and adminpassword='"+a.getAdminpassword()+"'";
		List<Admin> admin= (adminDao.list(hql));
		if(admin.size()>0)  
            return admin.get(0);  
        else  
            return null;
		
	}
	
}
