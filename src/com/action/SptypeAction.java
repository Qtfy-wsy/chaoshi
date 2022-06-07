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

import com.model.Sptype;
import com.service.SptypeService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("sptypeAction")
@Scope("prototype")
public class SptypeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SptypeService sptypeService;

	private Sptype sptype;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Sptype> sptypes;

	public Sptype getSptype() {
		return sptype;
	}

	public void setSptype(Sptype sptype) {
		this.sptype = sptype;
	}

	public SptypeService getSptypeService() {
		return sptypeService;
	}

	@Resource
	public void setSptypeService(SptypeService sptypeService) {
		this.sptypeService = sptypeService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addSptype() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String sptypeName = getParam("sptypeName");
			String sptypeMark = getParam("sptypeMark");
			String sptypeMark1 = getParam("sptypeMark1");
			String sptypeMark2 = getParam("sptypeMark2");
			String sptypeId = getParam("sptypeId");
			Sptype sptype = new Sptype();
			
			if (StringUtil.isNotEmpty(sptypeId)) {
				sptype = sptypeService.getSptype(Integer.parseInt(sptypeId));
			}
			if (StringUtil.isNotEmpty(sptypeName)) {
				sptype.setSptypeName(sptypeName);
			}
			if (StringUtil.isNotEmpty(sptypeMark)) {
				sptype.setSptypeMark(sptypeMark);
			}
			if (StringUtil.isNotEmpty(sptypeMark1)) {
				sptype.setSptypeMark1(sptypeMark1);
			}
			if (StringUtil.isNotEmpty(sptypeMark2)) {
				sptype.setSptypeMark2(Integer.parseInt(sptypeMark2));
			}

			if (StringUtil.isNotEmpty(sptypeId)) {
				sptypeService.modifySptype(sptype);
			} else {
				sptypeService.save(sptype);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteSptype() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				sptypeService.deleteSptype(Integer.parseInt(str[i]));
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

	public void getSptypes() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String sptypeName = getParam("sptypeName");
		String sptypeMark2 = getParam("sptypeMark2");
		Sptype sptype = new Sptype();
		if (StringUtil.isNotEmpty(sptypeName)) {
			sptype.setSptypeName(sptypeName);
		}
		if (StringUtil.isNotEmpty(sptypeMark2)) {
			sptype.setSptypeMark2(Integer.parseInt(sptypeMark2));
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(sptypeService.querySptypes(sptype, pageBean));
			JSONObject result = new JSONObject();
			int total = sptypeService.querySptypes(sptype, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sptypeComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("sptypeName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(sptypeService.querySptypes(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSptypes(List<Sptype> sptypes) {
		this.sptypes = sptypes;
	}

}
