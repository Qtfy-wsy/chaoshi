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

import com.model.Uxtype;
import com.service.UxtypeService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("uxtypeAction")
@Scope("prototype")
public class UxtypeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UxtypeService uxtypeService;

	private Uxtype uxtype;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Uxtype> uxtypes;

	public Uxtype getUxtype() {
		return uxtype;
	}

	public void setUxtype(Uxtype uxtype) {
		this.uxtype = uxtype;
	}

	public UxtypeService getUxtypeService() {
		return uxtypeService;
	}

	@Resource
	public void setUxtypeService(UxtypeService uxtypeService) {
		this.uxtypeService = uxtypeService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addUxtype() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String uxtypeName = getParam("uxtypeName");
			String uxtypeMark = getParam("uxtypeMark");
			String uxtypeId = getParam("uxtypeId");
			Uxtype uxtype = new Uxtype();
			
			if (StringUtil.isNotEmpty(uxtypeId)) {
				uxtype = uxtypeService.getUxtype(Integer.parseInt(uxtypeId));
			}
			if (StringUtil.isNotEmpty(uxtypeName)) {
				uxtype.setUxtypeName(uxtypeName);
			}
			if (StringUtil.isNotEmpty(uxtypeMark)) {
				uxtype.setUxtypeMark(uxtypeMark);
			}

			if (StringUtil.isNotEmpty(uxtypeId)) {
				uxtypeService.modifyUxtype(uxtype);
			} else {
				uxtypeService.save(uxtype);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteUxtype() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				uxtypeService.deleteUxtype(Integer.parseInt(str[i]));
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

	public void getUxtypes() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String uxtypeName = getParam("uxtypeName");
		Uxtype uxtype = new Uxtype();
		if (StringUtil.isNotEmpty(uxtypeName)) {
			uxtype.setUxtypeName(uxtypeName);
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(uxtypeService.queryUxtypes(uxtype, pageBean));
			JSONObject result = new JSONObject();
			int total = uxtypeService.queryUxtypes(uxtype, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uxtypeComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("uxtypeName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(uxtypeService.queryUxtypes(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUxtypes(List<Uxtype> uxtypes) {
		this.uxtypes = uxtypes;
	}

}
