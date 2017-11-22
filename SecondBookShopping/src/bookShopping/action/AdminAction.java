package bookShopping.action;

import java.util.List;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Pro;
import bookShopping.service.IAdminService;
import bookShopping.tools.Pager;


//����Ա��action��
@Controller
public class AdminAction extends BaseAction{
	private long id;
	private String adminname;
	private String adminpassword;
	private int index;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	//ע��ҵ�����
	private IAdminService adminService;
	
	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	@Override
	//����Ա�б��ִ�з���
	public String list(){
        try{
        	List<Admin> list=adminService.list();
        	putContext("list", list);
        }catch(ShoppingException e){
        	putContext("errorInfo", "��ȡ����Ա�б�ʧ�ܣ�"+e.getMessage());
        	return ERROR;
        }
        return LIST;
	}
	
	//����Ա�б��ҳ��ִ�з���
		public String listByPage(){		
			int pageSize=4;			
			try {
				Pager<Admin> list=adminService.listByPage(index, pageSize);
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
	
	//����Ա��ӵ�ִ�з���
	public String add(){
		try{
			Admin a=new Admin();
			a.setAdminname(adminname);
			a.setAdminpassword(adminpassword);
			adminService.add(a);
		}catch(ShoppingException e){
			putContext("errorInfo", "��ӹ���Աʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
	   return RELOAD;
	}
	
	//����Աɾ����ִ�з���
	public String delete(){
		try{
			adminService.delete(id);
		}catch(ShoppingException e){
			putContext("error", "ɾ������Աʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//��ȡ����Ա��ִ�з���
	public String edit(){
		try {
			Admin a=adminService.load(id);
			putContext("a",a);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ����Աʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	//����Ա�޸ĵ�ִ�з���
	public String save(){
		Admin a=new Admin();
		a.setAdminname(adminname);
		a.setAdminpassword(adminpassword);
		a.setId(id);
		try {
			adminService.update(a);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "�޸Ĺ���Աʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	//��¼ִ�еķ���
	public String login(){
		Admin a=new Admin();
		a.setAdminname(adminname);
		a.setAdminpassword(adminpassword);
		//����ҵ������
		Admin existAdmin=adminService.login(a);
		if(existAdmin==null){
			//��¼ʧ��
			this.addActionError("�û������������");
		    return INPUT;
			
		}else{
			//��¼�ɹ�
			ActionContext.getContext().getSession().put("existAdmin",existAdmin);
			return SUCCESS;
		}
	}
	
	//��¼�˳���ִ�з���
	public String logout(){
		 ActionContext.getContext().getSession().remove("existAdmin");
	     return INPUT;
	}
	
}
