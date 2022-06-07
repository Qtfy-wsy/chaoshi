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

import com.model.Ggtype;
import com.service.GgtypeService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("ggtypeAction")
@Scope("prototype")
public class GgtypeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GgtypeService ggtypeService;

	private Ggtype ggtype;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Ggtype> ggtypes;

	public Ggtype getGgtype() {
		return ggtype;
	}

	public void setGgtype(Ggtype ggtype) {
		this.ggtype = ggtype;
	}

	public GgtypeService getGgtypeService() {
		return ggtypeService;
	}

	@Resource
	public void setGgtypeService(GgtypeService ggtypeService) {
		this.ggtypeService = ggtypeService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addGgtype() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String ggtypeName = getParam("ggtypeName");
			String ggtypeMark = getParam("ggtypeMark");
			String ggtypeId = getParam("ggtypeId");
			Ggtype ggtype = new Ggtype();
			
			if (StringUtil.isNotEmpty(ggtypeId)) {
				ggtype = ggtypeService.getGgtype(Integer.parseInt(ggtypeId));
			}
			if (StringUtil.isNotEmpty(ggtypeName)) {
				ggtype.setGgtypeName(ggtypeName);
			}
			if (StringUtil.isNotEmpty(ggtypeMark)) {
				ggtype.setGgtypeMark(ggtypeMark);
			}

			if (StringUtil.isNotEmpty(ggtypeId)) {
				ggtypeService.modifyGgtype(ggtype);
			} else {
				ggtypeService.save(ggtype);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteGgtype() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				ggtypeService.deleteGgtype(Integer.parseInt(str[i]));
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

	public void getGgtypes() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String ggtypeName = getParam("ggtypeName");
		Ggtype ggtype = new Ggtype();
		if (StringUtil.isNotEmpty(ggtypeName)) {
			ggtype.setGgtypeName(ggtypeName);
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(ggtypeService.queryGgtypes(ggtype, pageBean));
			JSONObject result = new JSONObject();
			int total = ggtypeService.queryGgtypes(ggtype, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ggtypeComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("ggtypeName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(ggtypeService.queryGgtypes(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setGgtypes(List<Ggtype> ggtypes) {
		this.ggtypes = ggtypes;
	}

}
