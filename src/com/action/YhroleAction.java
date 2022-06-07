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

import com.model.Yhrole;
import com.service.YhroleService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("yhroleAction")
@Scope("prototype")
public class YhroleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private YhroleService yhroleService;

	private Yhrole yhrole;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Yhrole> yhroles;

	public Yhrole getYhrole() {
		return yhrole;
	}

	public void setYhrole(Yhrole yhrole) {
		this.yhrole = yhrole;
	}

	public YhroleService getYhroleService() {
		return yhroleService;
	}

	@Resource
	public void setYhroleService(YhroleService yhroleService) {
		this.yhroleService = yhroleService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addYhrole() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String yhroleName = getParam("yhroleName");
			String yhroleMark = getParam("yhroleMark");
			String yhroleMark1 = getParam("yhroleMark1");
			String yhroleMark2 = getParam("yhroleMark2");
			String yhroleId = getParam("yhroleId");
			Yhrole yhrole = new Yhrole();
			
			if (StringUtil.isNotEmpty(yhroleId)) {
				yhrole = yhroleService.getYhrole(Integer.parseInt(yhroleId));
			}
			if (StringUtil.isNotEmpty(yhroleName)) {
				yhrole.setYhroleName(yhroleName);
			}
			if (StringUtil.isNotEmpty(yhroleMark)) {
				yhrole.setYhroleMark(yhroleMark);
			}
			if (StringUtil.isNotEmpty(yhroleMark1)) {
				yhrole.setYhroleMark1(yhroleMark1);
			}
			if (StringUtil.isNotEmpty(yhroleMark2)) {
				yhrole.setYhroleMark2(Integer.parseInt(yhroleMark2));
			}

			if (StringUtil.isNotEmpty(yhroleId)) {
				yhroleService.modifyYhrole(yhrole);
			} else {
				yhroleService.save(yhrole);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteYhrole() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				yhroleService.deleteYhrole(Integer.parseInt(str[i]));
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

	public void getYhroles() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String yhroleName = getParam("yhroleName");
		String yhroleMark2 = getParam("yhroleMark2");
		Yhrole yhrole = new Yhrole();
		if (StringUtil.isNotEmpty(yhroleName)) {
			yhrole.setYhroleName(yhroleName);
		}
		if (StringUtil.isNotEmpty(yhroleMark2)) {
			yhrole.setYhroleMark2(Integer.parseInt(yhroleMark2));
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(yhroleService.queryYhroles(yhrole, pageBean));
			JSONObject result = new JSONObject();
			int total = yhroleService.queryYhroles(yhrole, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void yhroleComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("yhroleName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(yhroleService.queryYhroles(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setYhroles(List<Yhrole> yhroles) {
		this.yhroles = yhroles;
	}

}
