package bookShopping.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.activiti.engine.impl.Page;
import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Cate;
import bookShopping.model.Comment;
import bookShopping.model.Pro;
import bookShopping.service.ICateService;
import bookShopping.service.ICommentService;
import bookShopping.service.IProService;














import bookShopping.service.imp.CommentService;
import bookShopping.tools.Pager;

import com.sun.jmx.snmp.Timestamp;
//商品的action类
@Controller
public class ProAction extends BaseAction {
	 private long pid;
     private String pname;
     private String psn;
     private String pnum;
     private float mprice;
     private float vprice;
     private String image;
     private String cname;
     private String pdesc;
     private long cid;
 	private int size;
 	private int offset;
 	private int index;
 	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	private long total;
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	//注入业务层的类
     private IProService proService;
     private ICateService cateService;
     private ICommentService commentService;
	public ICommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	public ICateService getCateService() {
		return cateService;
	}
	public void setCateService(ICateService cateService) {
		this.cateService = cateService;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsn() {
		return psn;
	}
	public void setPsn(String psn) {
		this.psn = psn;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public float getMprice() {
		return mprice;
	}
	public void setMprice(float mprice) {
		this.mprice = mprice;
	}
	public float getVprice() {
		return vprice;
	}
	public void setVprice(float vprice) {
		this.vprice = vprice;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public IProService getProService() {
		return proService;
	}
	public void setProService(IProService proService) {
		this.proService = proService;
	}
	public String getCname() {
			return cname;
		}
    public void setCname(String cname) {
			this.cname = cname;
		}
	//封装上传文件域的成员变量
    private File upload;
    //封装上传文件类型的成员变量
    private String uploadContentType;
    //封装上传文件名的属性
    private String uploadFileName;
    //直接在struts.xml文件中配置的成员变量
    private String savePath;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String value) {
		this.savePath = value;
	}
	@Override
	//商品列表的执行方法
	public String list(){
		try {
			List<Pro> lists=proService.list();
			putContext("lists", lists);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "获取商品列表失败！"+e.getMessage());
        	return ERROR;
		}
		return LIST;
	}
	
	//商品列表分页的执行方法
	public String listByPage(){		
		int pageSize=4;
		
		try {
			Pager<Pro> lists=proService.listByPage(index, pageSize);
			double tc=lists.getTotal();
			double num=Math.ceil(tc/pageSize);
			int totalpage=(int) num;
			putContext("list", lists.getDatas());
			putContext("lists", lists);
			putContext("index", index);
			putContext("totalpage", totalpage);
		} catch (ShoppingException e) {
			// TODO: handle exceptio
			putContext("errorInfo", "获取商品列表失败！"+e.getMessage());
        	return ERROR;
		}
		return LIST;
	}
	
    //分类列表的执行方法
	public String listCate(){
		try {
			List<Cate> list=cateService.list();
			putContext("list", list);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "获取分类列表失败！"+e.getMessage());
        	return ERROR;
		}
		return Add;
	}
   //商品添加的执行方法
	public String add(){
		try {
			Cate c=new Cate();
			c.setCid(cid);

			Pro p=new Pro();
			p.setCate(c);
			p.setImage(savePath+uploadFileName);
			p.setMprice(mprice);
			p.setPname(pname);
			p.setPnum(pnum);
			p.setPsn(psn);
			p.setVprice(vprice);
			p.setPdesc(pdesc);
			p.setPubtime(new Date());
		    //以服务器的文件保存地址和原文件名建立上传文件输出流
			try {
				//以服务器的文件保存地址和原文件名建立上传文件输出流
				try {
					FileOutputStream fos;
					fos = new FileOutputStream(getSavePath()+"\\"+getUploadFileName());
					FileInputStream fis;
					fis = new FileInputStream(getUpload());
					byte[] buffer=new byte[1024];
					int len=0;
					while ((len=fis.read(buffer))>0) {
						fos.write(buffer,0,len);		
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            proService.add(p);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "添加商品失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//商品删除的执行方法
	public String delete(){
		try{
			proService.delete(pid);
		}catch(ShoppingException e){
			putContext("error", "删除商品失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//获取商品的执行方法
	public String edit(){
		try {
			List<Cate> list=cateService.list();
			putContext("list", list);
			
			Pro p=proService.load1(pid);
			putContext("p",p);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "获取商品失败！"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	
	//商品修改的执行方法
		public String save(){
			Cate c=new Cate();
			c.setCid(cid);
			
			Pro p=new Pro();
			p.setPid(pid);
			p.setCate(c);
			p.setImage(savePath+uploadFileName);
			p.setMprice(mprice);
			p.setPname(pname);
			p.setPnum(pnum);
			p.setPsn(psn);
			p.setVprice(vprice);
			p.setPdesc(pdesc);
			p.setPubtime(new Date());
			try { //以服务器的文件保存地址和原文件名建立上传文件输出流
				try {
					//以服务器的文件保存地址和原文件名建立上传文件输出流
					try {
						FileOutputStream fos;
						fos = new FileOutputStream(getSavePath()+"\\"+getUploadFileName());
						FileInputStream fis;
						fis = new FileInputStream(getUpload());
						byte[] buffer=new byte[1024];
						int len=0;
						while ((len=fis.read(buffer))>0) {
							fos.write(buffer,0,len);		
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				proService.update(p);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "修改商品失败！"+e.getMessage());
				return ERROR;
			}
			return RELOAD;
		}
		
		//商品详情的执行方法
		public String detail(){
			try {
				Pro p=proService.load(pid);
				putContext("p",p);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "获取商品失败！"+e.getMessage());
				return ERROR;
			}
			return DETAIL;
		}
			
		
		//获取主页商品的信息
		public String detailPro(){
			try {
				Pro p=proService.load(pid);
				putContext("p",p);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "获取商品分类失败！"+e.getMessage());
				return ERROR;
			}
			return "detailpro";
		}
		

		
}
