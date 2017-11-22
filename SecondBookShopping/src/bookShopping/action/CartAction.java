package bookShopping.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;

import sun.security.krb5.internal.crypto.crc32;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cart;
import bookShopping.model.Pro;
import bookShopping.model.User;
import bookShopping.service.ICartService;
import bookShopping.service.IUserService;
import bookShopping.service.imp.CartService;


@Controller
public class CartAction extends BaseAction {
	private Integer cnum;
	private long pid;
	private long uid;
	private long ctid;
	private float oprice=0;
	private Integer onum=0;
	public Integer getOnum() {
		return onum;
	}

	public void setOnum(Integer onum) {
		this.onum = onum;
	}

	public float getOprice() {
		return oprice;
	}

	public void setOprice(float oprice) {
		this.oprice = oprice;
	}

	public long getCtid() {
		return ctid;
	}

	public void setCtid(long ctid) {
		this.ctid = ctid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}
	public Integer getCnum() {
		return cnum;
	}

	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	//ע��ҵ������
	private ICartService cartService;
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}
	
	@Override
	//���ﳵ��ӵ�ִ�з���
	public String add(){
		try {
			 Pro p=new Pro();
			 p.setPid(pid);
			// System.out.println(pid);
			 User u=new User();
			 u.setUid(uid);
			 
			 Cart ct=new Cart();
			// ct.setCnum(cnum);
			 ct.setPro(p);
			 ct.setUser(u);
			 
			if(ActionContext.getContext().getSession().get("existUser")!=null){
				
				List<Cart> list=cartService.listbypid(pid);
				  if(list.size()==0){
					  ct.setCnum(cnum);
					  cartService.add(ct);
				}else{
					list.get(0).setCnum(cnum+list.get(0).getCnum());
					  cartService.update(list.get(0));
				}
				}else{
					return "login";
				}
		} catch (ShoppingException e) {
			  putContext("errorInfo", "��ӹ��ﳵʧ�ܣ�"+e.getMessage());
			  return ERROR;
		}
		return RELOAD;
	}
	
	

	//��ȡ�û����ﳵ���б��ִ�з���
	public String listcart(){
		try {
			  User user=(User) ActionContext.getContext().getSession().get("existUser");
		      uid=user.getUid();
			   
		      if(user!=null){     
				     List<Cart> u=cartService.listbyuid(uid);
				     for(int i=0;i<u.size();i++){
				    	 oprice+=u.get(i).getCnum()*u.get(i).getPro().getVprice();
				    	 onum+=u.get(i).getCnum();
				     }				    			         									
					   putContext("oprice", oprice);
					   putContext("onum", onum);
			           putContext("u",u);					   
				}else{
					return "login";
				}
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ�û����ﳵ���б�ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return "listcart";
	}
	
	//ɾ�����ﳵ��ִ�з���
	public String delete(){
		try {
			cartService.delete(ctid);
		} catch (ShoppingException e) {
			putContext("errorInfo", "ɾ���û����ﳵʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return "reload1";
	}

}
