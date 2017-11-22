package bookShopping.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import bookShopping.model.Cate;
import bookShopping.model.Pro;
import bookShopping.service.ICateService;
import bookShopping.service.IProService;

//ǰ̨��ҳ��action��
@Controller
public class IndexAction extends BaseAction{
	private ICateService cateService;
	private IProService proService;
	
	public ICateService getCateService() {
		return cateService;
	}

	public void setCateService(ICateService cateService) {
		this.cateService = cateService;
	}

	public IProService getProService() {
		return proService;
	}

	public void setProService(IProService proService) {
		this.proService = proService;
	}

	@Override
	public String list(){
		try {
			List<Cate> list=cateService.list();
			putContext("list", list);
			List<Pro> lists=proService.list();
			putContext("lists", lists);
		} catch (Exception e) {
			// TODO: handle exception
			putContext("errorInfo", "��ȡ������Ʒ�б�ʧ�ܣ�"+e.getMessage());
			return ERROR;
		}
		return "index";
	}
}
