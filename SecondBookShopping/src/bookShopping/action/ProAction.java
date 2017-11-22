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
//��Ʒ��action��
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
	//ע��ҵ������
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
	//��װ�ϴ��ļ���ĳ�Ա����
    private File upload;
    //��װ�ϴ��ļ����͵ĳ�Ա����
    private String uploadContentType;
    //��װ�ϴ��ļ���������
    private String uploadFileName;
    //ֱ����struts.xml�ļ������õĳ�Ա����
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
	//��Ʒ�б��ִ�з���
	public String list(){
		try {
			List<Pro> lists=proService.list();
			putContext("lists", lists);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ��Ʒ�б�ʧ�ܣ�"+e.getMessage());
        	return ERROR;
		}
		return LIST;
	}
	
	//��Ʒ�б��ҳ��ִ�з���
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
			putContext("errorInfo", "��ȡ��Ʒ�б�ʧ�ܣ�"+e.getMessage());
        	return ERROR;
		}
		return LIST;
	}
	
    //�����б��ִ�з���
	public String listCate(){
		try {
			List<Cate> list=cateService.list();
			putContext("list", list);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ�����б�ʧ�ܣ�"+e.getMessage());
        	return ERROR;
		}
		return Add;
	}
   //��Ʒ��ӵ�ִ�з���
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
		    //�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
			try {
				//�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
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
			putContext("errorInfo", "�����Ʒʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//��Ʒɾ����ִ�з���
	public String delete(){
		try{
			proService.delete(pid);
		}catch(ShoppingException e){
			putContext("error", "ɾ����Ʒʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//��ȡ��Ʒ��ִ�з���
	public String edit(){
		try {
			List<Cate> list=cateService.list();
			putContext("list", list);
			
			Pro p=proService.load1(pid);
			putContext("p",p);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ��Ʒʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	
	//��Ʒ�޸ĵ�ִ�з���
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
			try { //�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
				try {
					//�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
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
				putContext("errorInfo", "�޸���Ʒʧ�ܣ�"+e.getMessage());
				return ERROR;
			}
			return RELOAD;
		}
		
		//��Ʒ�����ִ�з���
		public String detail(){
			try {
				Pro p=proService.load(pid);
				putContext("p",p);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "��ȡ��Ʒʧ�ܣ�"+e.getMessage());
				return ERROR;
			}
			return DETAIL;
		}
			
		
		//��ȡ��ҳ��Ʒ����Ϣ
		public String detailPro(){
			try {
				Pro p=proService.load(pid);
				putContext("p",p);
			} catch (ShoppingException e) {
				// TODO: handle exception
				putContext("errorInfo", "��ȡ��Ʒ����ʧ�ܣ�"+e.getMessage());
				return ERROR;
			}
			return "detailpro";
		}
		

		
}
