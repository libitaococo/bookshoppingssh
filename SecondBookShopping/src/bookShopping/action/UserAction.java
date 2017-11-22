package bookShopping.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Pro;
import bookShopping.model.User;
import bookShopping.service.IUserService;
import bookShopping.tools.Pager;

//�û���action��
@Controller
public class UserAction extends BaseAction {
	private long uid;
	private String user;
    private String password;
    private String email;
    private String name;
    private int index;
  public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	//ע��ҵ�����
    private IUserService userService;
    public long getUid() {
  		return uid;
  	}
  	public void setUid(long uid) {
  		this.uid = uid;
  	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
    //�û��б��ִ�з���
	public String list(){
		 try{
	        	List<User> list=userService.list();
	        	putContext("list", list);
	        }catch(ShoppingException e){
	        	putContext("errorInfo", "��ȡ�û��б�ʧ�ܣ�"+e.getMessage());
	        	return ERROR;
	        }
	        return LIST;
	}
	
	//�û��б��ҳ��ִ�з���
			public String listByPage(){		
				int pageSize=4;			
				try {
					Pager<User> list=userService.listByPage(index, pageSize);
					double tc=list.getTotal();
					double num=Math.ceil(tc/pageSize);
					int totalpage=(int) num;
					putContext("list", list.getDatas());
					putContext("lists", list);
					putContext("index", index);
					putContext("totalpage", totalpage);
				} catch (ShoppingException e) {
					// TODO: handle exceptio
					putContext("errorInfo", "��ȡ��Ʒ�б�ʧ�ܣ�"+e.getMessage());
		        	return ERROR;
				}
				return LIST;
			}
	
	//�û�ɾ����ִ�з���
	public String delete(){
		try {
			userService.delete(uid);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "�û�ɾ��ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//��ȡ�û���ִ�з���
	public String edit(){
		try {
			User u=userService.load(uid);
			putContext("u",u);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ�û�ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	
	//�޸��û���ִ�з���
	public String save(){
		User u=new User();
		u.setUser(user);
		u.setPassword(password);
		u.setEmail(email);
		u.setUid(uid);
		try {
			userService.update(u);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "�޸Ĺ���Աʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//�û��ĵ�¼ִ�еķ���
	public String login(){
		User u=new User();
		u.setUser(user);
		u.setPassword(password);
		//����ҵ������
		User existUser=userService.login(u);
		if(existUser==null){
			//��¼ʧ��
			this.addActionError("�û������������");
			return INPUT;
		}else{
			//��¼�ɹ�
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
		
	}
	
	//�û�ע���ִ�з���
	public String register(){
		User u=new User();
		u.setUser(user);
		u.setPassword(password);
		u.setEmail(email);
		u.setName(name);
		System.out.print(password);
		//����ҵ������
		User existUser=userService.register(u);
		if(existUser==null){
			//ע��ɹ�
			userService.add(u);
			return INPUT;
		}else{
			//ע��ʧ��
			this.addActionError("�û����Ѵ��ڣ�");
			return ERROR1;
		}
	}
	
	//��¼�˳���ִ�з���
	public String logout(){
		    ActionContext.getContext().getSession().remove("existUser");
			return INPUT;
	}
	

}
