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
//����Ա��ҵ���ʵ����
public class AdminService implements IAdminService{
  //ע��dao����
	private IAdminDao adminDao;

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
   //ҵ���Ĺ���Ա�б�ķ���
	public List<Admin> list() throws ShoppingException {
		String hql="select a from Admin as a";
		return adminDao.list(hql);
	}
  
	//����Ա�б�ķ�����ҳ
		public Pager<Admin> listByPage(int index,int pageSize)throws ShoppingException{
			SystemContext.setPageOffset((index-1)*pageSize);
			SystemContext.setPageSize(pageSize);
			String hql="select a from Admin as a";
			Pager<Admin> admins=adminDao.find(hql);
			return admins;
		}
	
   //ҵ������Ա��ӵķ���
	public void add(Admin a)throws ShoppingException{
		adminDao.add(a);
	}
	
	//ҵ������Ա��ɾ���ķ���
	public void delete(long id)throws ShoppingException{
		adminDao.delete(id);
	}
	
	//ҵ����ȡ����Ա�ĵķ���
	public Admin load(long id)throws ShoppingException{
		return adminDao.load(id);
	}
	
	//ҵ����޸Ĺ���Ա�ķ���
	public void update(Admin a)throws ShoppingException{
		adminDao.update(a);
	}
   //ҵ���ĵ�¼�ķ���
	public Admin login(Admin a){
		String hql="from Admin where adminname='"+a.getAdminname()+"' and adminpassword='"+a.getAdminpassword()+"'";
		List<Admin> admin= (adminDao.list(hql));
		if(admin.size()>0)  
            return admin.get(0);  
        else  
            return null;
		
	}
	
}
