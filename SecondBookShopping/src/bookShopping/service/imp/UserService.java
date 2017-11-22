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

//用户的业务层实现类
public  class UserService implements IUserService{
//注入dao层类
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	//业务层的登录的方法
	public User login(User u){
		String hql="from User where user='"+u.getUser()+"'And password='"+u.getPassword()+"'";
		List<User> user=(userDao.list(hql));
		if(user.size()>0)
			return user.get(0);
		else 
			return null;
	}
	
	//业务层的注册的方法
	public User register(User u){
		String hql="from User where user='"+u.getUser()+"'";
		List<User> user=(userDao.list(hql));
		//if(u.getPassword())
		if(user.size()>0)
			return user.get(0);
		else 
		    return null;
	}
	
	//业务层的用户添加的方法
	public void add(User u){
	    userDao.add(u);
	    
	}
	
	//业务层的管理员列表的方法
		public List<User> list() throws ShoppingException {
			String hql="select u from User as u";
			return userDao.list(hql);
		}
		
	//用户列表的方法分页
	public Pager<User> listByPage(int index,int pageSize)throws ShoppingException{
		SystemContext.setPageOffset((index-1)*pageSize);
		SystemContext.setPageSize(pageSize);
		String hql="select u from User as u";
		Pager<User> users=userDao.find(hql);
		return users;
		}
	//业务层的用户删除的方法
	public void delete(long uid)throws ShoppingException{
		userDao.delete(uid);
	}
	
	//业务层获取用户的方法
	public User load(long uid)throws ShoppingException{
		String hql="from User s left outer join fetch s.carts where s.uid=?";
		List<User> users=userDao.list(hql, uid);
		return users.get(0);
	}
	
	//业务层修改用户的方法
	public void update(User u)throws ShoppingException{
		userDao.update(u);
	}

	
}
