package bookShopping.service.imp;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IUserDao;
import bookShopping.model.Admin;
import bookShopping.model.Pro;
import bookShopping.model.User;
import bookShopping.service.IUserService;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;

//�û���ҵ���ʵ����
public  class UserService implements IUserService{
//ע��dao����
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	//ҵ���ĵ�¼�ķ���
	public User login(User u){
		String hql="from User where user='"+u.getUser()+"'And password='"+u.getPassword()+"'";
		List<User> user=(userDao.list(hql));
		if(user.size()>0)
			return user.get(0);
		else 
			return null;
	}
	
	//ҵ����ע��ķ���
	public User register(User u){
		String hql="from User where user='"+u.getUser()+"'";
		List<User> user=(userDao.list(hql));
		//if(u.getPassword())
		if(user.size()>0)
			return user.get(0);
		else 
		    return null;
	}
	
	//ҵ�����û���ӵķ���
	public void add(User u){
	    userDao.add(u);
	    
	}
	
	//ҵ���Ĺ���Ա�б�ķ���
		public List<User> list() throws ShoppingException {
			String hql="select u from User as u";
			return userDao.list(hql);
		}
		
	//�û��б�ķ�����ҳ
	public Pager<User> listByPage(int index,int pageSize)throws ShoppingException{
		SystemContext.setPageOffset((index-1)*pageSize);
		SystemContext.setPageSize(pageSize);
		String hql="select u from User as u";
		Pager<User> users=userDao.find(hql);
		return users;
		}
	//ҵ�����û�ɾ���ķ���
	public void delete(long uid)throws ShoppingException{
		userDao.delete(uid);
	}
	
	//ҵ����ȡ�û��ķ���
	public User load(long uid)throws ShoppingException{
		String hql="from User s left outer join fetch s.carts where s.uid=?";
		List<User> users=userDao.list(hql, uid);
		return users.get(0);
	}
	
	//ҵ����޸��û��ķ���
	public void update(User u)throws ShoppingException{
		userDao.update(u);
	}

	
}
