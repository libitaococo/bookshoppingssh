package bookShopping.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cate;
import bookShopping.model.Pro;
import bookShopping.service.ICateService;
import bookShopping.tools.Pager;

//分类的action类
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

	//注入业务层的类
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
	//分类列表的执行方法
	public String list(){
		try {
			List<Cate> list=cateService.list();
			putContext("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			putContext("errorInfo", "获取分类列表失败！"+e.getMessage());
			return ERROR;
		}
		return LIST;
	}
	
	//分类列表分页的执行方法
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
				putContext("errorInfo", "获取商品列表失败！"+e.getMessage());
	        	return ERROR;
			}
			return LIST;
		}
	
	//添加分类的执行方法
	public String add(){
		try {
			Cate c=new Cate();
			c.setCname(cname);
			cateService.add(c);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "添加分类失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//删除分类的执行方法
	public String delete(){
		try {
			cateService.delete(cid);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "删除分类失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//获取分类的执行方法
	public String edit(){
		try {
			Cate c=cateService.load(cid);
			putContext("c", c);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "获取分类失败！"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	
	//修复分类的执行方法
	public String save(){
		Cate c=new Cate();
		c.setCid(cid);
		c.setCname(cname);
		try {
			cateService.update(c);
		} catch (Exception e) {
			// TODO: handle exception
			putContext("errorInfo", "编辑分类失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
}
