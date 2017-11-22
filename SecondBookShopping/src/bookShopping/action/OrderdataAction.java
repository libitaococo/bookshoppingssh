package bookShopping.action;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Orderdata;
import bookShopping.model.Pro;
import bookShopping.service.IOrderdataService;
import bookShopping.service.imp.OrderdataService;
import bookShopping.tools.Pager;

public class OrderdataAction extends BaseAction {
    private int index;
    private long oid;

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public int getIndex() {
	       return index;
    }

     public void setIndex(int index) {
	        this.index = index;
     }
     //注入业务层的类
     private IOrderdataService orderdataService;
     
	 public IOrderdataService getOrderdataService() {
		return orderdataService;
	  }

	 public void setOrderdataService(IOrderdataService orderdataService) {
		this.orderdataService = orderdataService;
	 }

	//订单详情列表的执行方法
		public String list(){
			try {
				List<Orderdata> list=orderdataService.listbyoid(oid);
				putContext("list", list);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "订单详情列表失败！"+e.getMessage());
	        	return ERROR;
			}
			return "listorder_data";
		}
		
		//订单列表分页的执行方法
		public String listByPage(){		
			int pageSize=4;
			
			try {
				Pager<Orderdata> list=orderdataService.listByPage(index, pageSize,oid);
				double tc=list.getTotal();
				double num=Math.ceil(tc/pageSize);
				int totalpage=(int) num;
				putContext("list", list.getDatas());
				putContext("lists", list);
				putContext("index", index);
				putContext("totalpage", totalpage);
			} catch (ShoppingException e) {
				// TODO: handle exceptio
				putContext("errorInfo", "订单详情列表失败！"+e.getMessage());
	        	return ERROR;
			}
			return LIST;
		}

}
