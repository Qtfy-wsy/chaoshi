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

import com.model.Yhbumen;
import com.service.YhbumenService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("yhbumenAction")
@Scope("prototype")
public class YhbumenAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private YhbumenService yhbumenService;

	private Yhbumen yhbumen;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Yhbumen> yhbumens;

	public Yhbumen getYhbumen() {
		return yhbumen;
	}

	public void setYhbumen(Yhbumen yhbumen) {
		this.yhbumen = yhbumen;
	}

	public YhbumenService getYhbumenService() {
		return yhbumenService;
	}

	@Resource
	public void setYhbumenService(YhbumenService yhbumenService) {
		this.yhbumenService = yhbumenService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addYhbumen() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String yhbumenName = getParam("yhbumenName");
			String yhbumenMark = getParam("yhbumenMark");
			String yhbumenMark1 = getParam("yhbumenMark1");
			String yhbumenMark2 = getParam("yhbumenMark2");
			String yhbumenId = getParam("yhbumenId");
			Yhbumen yhbumen = new Yhbumen();
			
			if (StringUtil.isNotEmpty(yhbumenId)) {
				yhbumen = yhbumenService.getYhbumen(Integer.parseInt(yhbumenId));
			}
			if (StringUtil.isNotEmpty(yhbumenName)) {
				yhbumen.setYhbumenName(yhbumenName);
			}
			if (StringUtil.isNotEmpty(yhbumenMark)) {
				yhbumen.setYhbumenMark(yhbumenMark);
			}
			if (StringUtil.isNotEmpty(yhbumenMark1)) {
				yhbumen.setYhbumenMark1(yhbumenMark1);
			}
			if (StringUtil.isNotEmpty(yhbumenMark2)) {
				yhbumen.setYhbumenMark2(Integer.parseInt(yhbumenMark2));
			}

			if (StringUtil.isNotEmpty(yhbumenId)) {
				yhbumenService.modifyYhbumen(yhbumen);
			} else {
				yhbumenService.save(yhbumen);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteYhbumen() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				yhbumenService.deleteYhbumen(Integer.parseInt(str[i]));
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

	public void getYhbumens() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String yhbumenName = getParam("yhbumenName");
		String yhbumenMark2 = getParam("yhbumenMark2");
		Yhbumen yhbumen = new Yhbumen();
		if (StringUtil.isNotEmpty(yhbumenName)) {
			yhbumen.setYhbumenName(yhbumenName);
		}
		if (StringUtil.isNotEmpty(yhbumenMark2)) {
			yhbumen.setYhbumenMark2(Integer.parseInt(yhbumenMark2));
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(yhbumenService.queryYhbumens(yhbumen, pageBean));
			JSONObject result = new JSONObject();
			int total = yhbumenService.queryYhbumens(yhbumen, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void yhbumenComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("yhbumenName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(yhbumenService.queryYhbumens(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setYhbumens(List<Yhbumen> yhbumens) {
		this.yhbumens = yhbumens;
	}

}
