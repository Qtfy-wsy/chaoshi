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

import com.model.Yxtype;
import com.service.YxtypeService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("yxtypeAction")
@Scope("prototype")
public class YxtypeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private YxtypeService yxtypeService;

	private Yxtype yxtype;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Yxtype> yxtypes;

	public Yxtype getYxtype() {
		return yxtype;
	}

	public void setYxtype(Yxtype yxtype) {
		this.yxtype = yxtype;
	}

	public YxtypeService getYxtypeService() {
		return yxtypeService;
	}

	@Resource
	public void setYxtypeService(YxtypeService yxtypeService) {
		this.yxtypeService = yxtypeService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addYxtype() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String yxtypeName = getParam("yxtypeName");
			String yxtypeMark = getParam("yxtypeMark");
			String yxtypeId = getParam("yxtypeId");
			Yxtype yxtype = new Yxtype();
			
			if (StringUtil.isNotEmpty(yxtypeId)) {
				yxtype = yxtypeService.getYxtype(Integer.parseInt(yxtypeId));
			}
			if (StringUtil.isNotEmpty(yxtypeName)) {
				yxtype.setYxtypeName(yxtypeName);
			}
			if (StringUtil.isNotEmpty(yxtypeMark)) {
				yxtype.setYxtypeMark(yxtypeMark);
			}

			if (StringUtil.isNotEmpty(yxtypeId)) {
				yxtypeService.modifyYxtype(yxtype);
			} else {
				yxtypeService.save(yxtype);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteYxtype() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				yxtypeService.deleteYxtype(Integer.parseInt(str[i]));
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

	public void getYxtypes() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String yxtypeName = getParam("yxtypeName");
		Yxtype yxtype = new Yxtype();
		if (StringUtil.isNotEmpty(yxtypeName)) {
			yxtype.setYxtypeName(yxtypeName);
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(yxtypeService.queryYxtypes(yxtype, pageBean));
			JSONObject result = new JSONObject();
			int total = yxtypeService.queryYxtypes(yxtype, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void yxtypeComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("yxtypeName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(yxtypeService.queryYxtypes(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setYxtypes(List<Yxtype> yxtypes) {
		this.yxtypes = yxtypes;
	}

}
