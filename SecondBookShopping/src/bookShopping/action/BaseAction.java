package bookShopping.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	
	protected static final String SUCCESS="success";
	protected static final String ERROR="error";
	protected static final String LIST="list";
	protected static final String RELOAD="reload";
	protected static final String UPDATE="update";
	protected static final String ADD="add";
	protected static final String EDIT="edit";
	protected static final String ERROR1="error1";
	protected static final String DETAIL="detail";
	protected static final String Add="add";
	//��ʾǰ̨��������ҳ�룬�ڼ�ҳ
   protected  int pageIndex;
  
  
   //��ֵ�ŵ�page������
   protected void putContext(String key,Object value)
   {
	   ActionContext.getContext().put(key, value);
   }


public String login() {
	// TODO Auto-generated method stub
	return null;
}




public String list() {
	// TODO Auto-generated method stub
	return null;
}


public String add() {
	// TODO Auto-generated method stub
	return null;
}


public String listPro() {
	// TODO Auto-generated method stub
	return null;
}
   

}
