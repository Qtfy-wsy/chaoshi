package com.action;

import java.util.List;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.model.Bumen;
import com.service.BumenService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("bumenAction")
@Scope("prototype")
public class
BumenAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private BumenService bumenService;

	private Bumen bumen;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Bumen> bumens;

	public Bumen getBumen() {
		return bumen;
	}

	public void setBumen(Bumen bumen) {
		this.bumen = bumen;
	}

	public BumenService getBumenService() {
		return bumenService;
	}

	@Resource
	public void setBumenService(BumenService bumenService) {
		this.bumenService = bumenService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addBumen() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String bumenName = getParam("bumenName");
			String bumenMark = getParam("bumenMark");
			String bumenMark1 = getParam("bumenMark1");
			String bumenMark2 = getParam("bumenMark2");
			String bumenId = getParam("bumenId");
			Bumen bumen = new Bumen();
			
			if (StringUtil.isNotEmpty(bumenId)) {
				bumen = bumenService.getBumen(Integer.parseInt(bumenId));
			}
			if (StringUtil.isNotEmpty(bumenName)) {
				bumen.setBumenName(bumenName);
			}
			if (StringUtil.isNotEmpty(bumenMark)) {
				bumen.setBumenMark(bumenMark);
			}
			if (StringUtil.isNotEmpty(bumenMark1)) {
				bumen.setBumenMark1(bumenMark1);
			}
			if (StringUtil.isNotEmpty(bumenMark2)) {
				bumen.setBumenMark2(Integer.parseInt(bumenMark2));
			}

			if (StringUtil.isNotEmpty(bumenId)) {
				bumenService.modifyBumen(bumen);
			} else {
				bumenService.save(bumen);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteBumen() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				bumenService.deleteBumen(Integer.parseInt(str[i]));
			}
			result.put("success", "true");
			result.put("delNums", str.length);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

	public void getBumens() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String bumenName = getParam("bumenName");
		String bumenMark2 = getParam("bumenMark2");
		Bumen bumen = new Bumen();
		if (StringUtil.isNotEmpty(bumenName)) {
			bumen.setBumenName(bumenName);
		}
		if (StringUtil.isNotEmpty(bumenMark2)) {
			bumen.setBumenMark2(Integer.parseInt(bumenMark2));
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(bumenService.queryBumens(bumen, pageBean));
			JSONObject result = new JSONObject();
			int total = bumenService.queryBumens(bumen, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void bumenComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("bumenName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(bumenService.queryBumens(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setBumens(List<Bumen> bumens) {
		this.bumens = bumens;
	}

}
