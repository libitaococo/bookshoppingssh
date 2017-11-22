package bookShopping.service.imp;


import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ICommentDao;
import bookShopping.model.Comment;
import bookShopping.model.Pro;
import bookShopping.service.ICommentService;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;

public  class CommentService implements ICommentService {
   private ICommentDao commentDao;

    public ICommentDao getCommentDao() {
	return commentDao;
    }

    public void setCommentDao(ICommentDao commentDao) {
	this.commentDao = commentDao;
    }
    
    @Override
    //ҵ���������۵ķ���
   public void add(Comment co)throws ShoppingException{
	   commentDao.add(co);
   }
   
    //ҵ��������б�ķ���
   //public  List<Comment> listbypro(long pid)throws ShoppingException{
	 // String hql="select co from Comment as co where co.pid=pid";
	  // return commentDao.list(hql);
   //}
   
   //ҵ���ɾ�����۵ķ���
   public void delete(long coid)throws ShoppingException{
	   commentDao.delete(coid);
   }
   
 //��Ʒ�б�ķ�����ҳ
 //	public List<Comment> listByPage(int index,int pageSize,long pid)throws ShoppingException{
 	//	SystemContext.setPageOffset((index-1)*pageSize);
 	//	SystemContext.setPageSize(pageSize);
 	//	String hql=" from Comment as co where co.Pro.pid=7";
 	//	Pager<Comment> cos=commentDao.find(hql);
 		//return cos;
 	//	return  cos.getDatas();
 		
 		
 	//}
 	
}
