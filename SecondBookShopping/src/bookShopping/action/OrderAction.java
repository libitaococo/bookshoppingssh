package bookShopping.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cart;
import bookShopping.model.Order;
import bookShopping.model.Orderdata;
import bookShopping.model.Pro;
import bookShopping.model.User;
import bookShopping.service.ICartService;
import bookShopping.service.IOrderService;
import bookShopping.service.IOrderdataService;
import bookShopping.service.IUserService;
import bookShopping.service.imp.CartService;
import bookShopping.service.imp.OrderdataService;
import bookShopping.tools.Pager;

public class OrderAction extends BaseAction {
    private long oid;
	//private Integer oid;
   // private Random oname;
    private float oprice;
    private Integer onum;
    private long uid;
    private long odid;
    private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getOdid() {
		return odid;
	}

	public void setOdid(long odid) {
		this.odid = odid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}


	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}


	public float getOprice() {
		return oprice;
	}

	public void setOprice(float oprice) {
		this.oprice = oprice;
	}

	public Integer getOnum() {
		return onum;
	}

	public void setOnum(Integer onum) {
		this.onum = onum;
	}



	//注入业务层的类
	private IOrderService orderService;
	private ICartService cartService;
	private IOrderdataService orderdataService;

	public IOrderdataService getOrderdataService() {
		return orderdataService;
	}

	public void setOrderdataService(IOrderdataService orderdataService) {
		this.orderdataService = orderdataService;
	}


	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	//订单添加的执行方法
	public String add(){
		try {
			 User user=(User) ActionContext.getContext().getSession().get("existUser");
			 uid=user.getUid();
			 
			 Random rand = new Random();
			 int rannum = (int) (rand.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
			 Order o=new Order();
			 o.setOid(rannum);
			 //o.setOid(oid);
			 
			 o.setUser(user);
			 o.setOnum(onum);
			 o.setOprice(oprice);  
			 
			 List<Cart> carts=cartService.listbyuid(uid);
			 
			//Set<Order_data> order_datas=new HashSet<Order_data>();
		    for(int i=0;i<carts.size();i++){
				 Orderdata od = new Orderdata();
				 od.setOdid(odid);
	             od.setPro(carts.get(i).getPro());
	             od.setSum(carts.get(i).getCnum());
	             //od.setOrder(order);
	             od.setOid(rannum);
	             orderdataService.add(od);
	             cartService.delete(carts.get(i).getCtid());
	            // order_datas.add(od);
			}
	       // o.setOrder_datas(order_datas);
	        orderService.add(o);
	         
	    
			  
		} catch (ShoppingException e) {
			putContext("errorInfo", "添加订单失败！"+e.getMessage());
			  return ERROR;
		}
		 return LIST;
		
	}
	//订单列表的执行方法
	public String list(){
		try {
			User user=(User) ActionContext.getContext().getSession().get("existUser");
			uid=user.getUid();
			
			if(user!=null){
			List<Order> list=orderService.list(uid);
			putContext("list", list);
			}else{
				return "login";
			}
		} catch (Exception e) {
			putContext("errorInfo", "获取订单列表失败！"+e.getMessage());
        	return ERROR;
		}
		return "listorder";
		
	}
	
	//订单列表分页的执行方法
		public String listByPage(){		
			int pageSize=4;
			
			try {
				Pager<Order> list=orderService.listByPage(index, pageSize);
				double tc=list.getTotal();
				double num=Math.ceil(tc/pageSize);
				int totalpage=(int) num;
				putContext("list", list.getDatas());
				putContext("lists", list);
				putContext("index", index);
				putContext("totalpage", totalpage);
			} catch (ShoppingException e) {
				// TODO: handle exceptio
				putContext("errorInfo", "获取商品列表失败！"+e.getMessage());
	        	return ERROR;
			}
			return "reload1";
		}
		
		//后台删除订单的执行方法
				public String delete1(){
					try {
						orderService.delete(oid);
					} catch (ShoppingException e) {
						// TODO: handle exception
						putContext("errorInfo", "删除订单失败！"+e.getMessage());
			        	return ERROR;
					}
					return "reload1";
				}
		
	//删除订单的执行方法
		public String delete(){
			try {
				orderService.delete(oid);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "删除订单失败！"+e.getMessage());
	        	return ERROR;
			}
			return RELOAD;
		}
}
