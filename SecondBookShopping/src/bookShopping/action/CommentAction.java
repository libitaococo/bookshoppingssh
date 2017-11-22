package bookShopping.action;

import java.util.List;
import java.util.Set;

import org.aspectj.org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cate;
import bookShopping.model.Comment;
import bookShopping.model.Pro;
import bookShopping.model.User;
import bookShopping.service.ICommentService;
import bookShopping.service.IProService;
import bookShopping.service.imp.ProService;
import bookShopping.tools.Pager;

public class CommentAction extends BaseAction{
	private long coid;
	private String content;
	private int score;
	
	private long pid;
	private long uid;
	private long cid;
	private int index;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	//注入业务层的类
	private ICommentService commentService;
	private IProService proService;
	
   public IProService getProService() {
		return proService;
	}

	public void setProService(IProService proService) {
		this.proService = proService;
	}

public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

public long getCoid() {
		return coid;
	}

	public void setCoid(long coid) {
		this.coid = coid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
    
	//商品列表分页的执行方法
	//public String listByPage(){		
		//int pageSize=4;
		
		//try {
		//	Pager<Comment> list=commentService.listByPage(index, pageSize);
		//	double tc=list.getTotal();
			//double num=Math.ceil(tc/pageSize);
			///int totalpage=(int) num;
		//	putContext("list", list.getDatas());
			//putContext("lists", list);
			//putContext("index", index);
			//putContext("totalpage", totalpage);
		//} catch (ShoppingException e) {
			// TODO: handle exceptio
			//putContext("errorInfo", "获取商品列表失败！"+e.getMessage());
        	//return ERROR;
		//}
		//return LIST;
	//}
	
	//评论添加的执行方法
      public String handle(){
	      try{
	    	 
		    Pro p=new Pro();
		    p.setPid(pid);

		    
		    User u=(User) ActionContext.getContext().getSession().get("existUser");
           
			Comment co=new Comment();
			co.setCoid(coid);
			co.setContent(content);
			co.setPro(p);
			co.setScore(score);
			co.setUser(u);
			if(ActionContext.getContext().getSession().get("existUser")!=null){
			   commentService.add(co);
			}else{
				return "login";
			}
		}catch(ShoppingException e){
			putContext("errorInfo", "添加评论失败！"+e.getMessage());
			return ERROR;
		}
	   return RELOAD;
   }
      
      //删除评论的执行方法
      public String delete(){
    	  try {
    		 
			commentService.delete(coid);
		
		} catch (ShoppingException e) {
			putContext("errorInfo", "删除评论失败！"+e.getMessage());
			return ERROR;
		}
    	  return RELOAD;
      }
      
     
}
