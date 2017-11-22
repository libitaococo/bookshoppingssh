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
     //ע��ҵ������
     private IOrderdataService orderdataService;
     
	 public IOrderdataService getOrderdataService() {
		return orderdataService;
	  }

	 public void setOrderdataService(IOrderdataService orderdataService) {
		this.orderdataService = orderdataService;
	 }

	//���������б��ִ�з���
		public String list(){
			try {
				List<Orderdata> list=orderdataService.listbyoid(oid);
				putContext("list", list);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "���������б�ʧ�ܣ�"+e.getMessage());
	        	return ERROR;
			}
			return "listorder_data";
		}
		
		//�����б��ҳ��ִ�з���
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
				putContext("errorInfo", "���������б�ʧ�ܣ�"+e.getMessage());
	        	return ERROR;
			}
			return LIST;
		}

}
