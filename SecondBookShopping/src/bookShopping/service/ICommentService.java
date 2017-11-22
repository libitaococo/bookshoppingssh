package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Comment;
import bookShopping.model.Pro;
import bookShopping.tools.Pager;

public interface ICommentService {

	public void add(Comment co)throws ShoppingException;
	//public List<Comment> listbypro(long pid)throws ShoppingException;
    public void delete(long coid)throws ShoppingException;
    //public List<Comment> listByPage(int index,int pageSize,long pid)throws ShoppingException;

}
