package bookShopping.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cate;
import bookShopping.model.Pro;
import bookShopping.service.ICateService;
import bookShopping.tools.Pager;

//�����action��
@Controller
public class CateAction extends BaseAction {
    private long cid;
    private String cname;
    private int index;
    public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	//ע��ҵ������
    private ICateService cateService;
    
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public ICateService getCateService() {
		return cateService;
	}
	public void setCateService(ICateService cateService) {
		this.cateService = cateService;
	}
	
	@Override
	//�����б��ִ�з���
	public String list(){
		try {
			List<Cate> list=cateService.list();
			putContext("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ�����б�ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return LIST;
	}
	
	//�����б��ҳ��ִ�з���
		public String listByPage(){		
			int pageSize=4;
			
			try {
				Pager<Cate> list=cateService.listByPage(index, pageSize);
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
	
	//��ӷ����ִ�з���
	public String add(){
		try {
			Cate c=new Cate();
			c.setCname(cname);
			cateService.add(c);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ӷ���ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//ɾ�������ִ�з���
	public String delete(){
		try {
			cateService.delete(cid);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "ɾ������ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//��ȡ�����ִ�з���
	public String edit(){
		try {
			Cate c=cateService.load(cid);
			putContext("c", c);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ����ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	
	//�޸������ִ�з���
	public String save(){
		Cate c=new Cate();
		c.setCid(cid);
		c.setCname(cname);
		try {
			cateService.update(c);
		} catch (Exception e) {
			// TODO: handle exception
			putContext("errorInfo", "�༭����ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
}
