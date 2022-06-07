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

import com.model.Spgys;
import com.service.SpgysService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Bumen;
import com.service.BumenService;
import com.model.Role;
import com.service.RoleService;

@Component("spgysAction")
@Scope("prototype")
public class SpgysAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private SpgysService spgysService;

	private Spgys spgys;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Spgys> spgyss;

	public Spgys getSpgys() {
		return spgys;
	}

	public void setSpgys(Spgys spgys) {
		this.spgys = spgys;
	}

	public SpgysService getSpgysService() {
		return spgysService;
	}

	@Resource
	public void setSpgysService(SpgysService spgysService) {
		this.spgysService = spgysService;
	}

	@Autowired
	private BumenService bumenService;
	private Bumen bumen;

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

	@Autowired
	private RoleService roleService;
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext
			.get(ServletActionContext.HTTP_RESPONSE);

	public void addSpgys() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String spgysName = getParam("spgysName");
			String spgysPhone = getParam("spgysPhone");
			String spgysMark = getParam("spgysMark");
			String spgysMark1 = getParam("spgysMark1");
			String spgysMark2 = getParam("spgysMark2");
			String spgysDizhi = getParam("spgysDizhi");
			String spgysDate = getParam("spgysDate");
			String spgysDate1 = getParam("spgysDate1");
			String spgysType = getParam("spgysType");
			String spgysType1 = getParam("spgysType1");
			String spgysId = getParam("spgysId");
			Spgys spgys = new Spgys();

			if (StringUtil.isNotEmpty(spgysId)) {
				spgys = spgysService.getSpgys(Integer.parseInt(spgysId));
			}
			if (StringUtil.isNotEmpty(spgysName)) {
				spgys.setSpgysName(spgysName);
			}
			if (StringUtil.isNotEmpty(spgysPhone)) {
				spgys.setSpgysPhone(spgysPhone);
			}
			if (StringUtil.isNotEmpty(spgysMark)) {
				spgys.setSpgysMark(spgysMark);
			}
			if (StringUtil.isNotEmpty(spgysMark1)) {
				spgys.setSpgysMark1(spgysMark1);
			}
			if (StringUtil.isNotEmpty(spgysMark2)) {
				spgys.setSpgysMark2(spgysMark2);
			}
			if (StringUtil.isNotEmpty(spgysDizhi)) {
				spgys.setSpgysDizhi(spgysDizhi);
			}
			if (StringUtil.isNotEmpty(spgysDate)) {
				spgys.setSpgysDate(DateUtil.formatString(spgysDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spgysDate1)) {
				spgys.setSpgysDate1(DateUtil.formatString(spgysDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spgysType)) {
				spgys.setSpgysType(Integer.parseInt(spgysType));
			}
			if (StringUtil.isNotEmpty(spgysType1)) {
				spgys.setSpgysType1(Integer.parseInt(spgysType1));
			}
			if (StringUtil.isNotEmpty(spgysId)) {
				spgysService.modifySpgys(spgys);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				spgysService.save(spgys);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSpgys() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				spgysService.deleteSpgys(Integer.parseInt(str[i]));
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

	public void getSpgyss() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String spgysName = getParam("spgysName");
		String spgysPhone = getParam("spgysPhone");
		String spgysId = getParam("spgysId");
		String spgysType1 = getParam("spgysType1");
		String spgysType = getParam("spgysType");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		Spgys spgys = new Spgys();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(spgysName)) {
				spgys.setSpgysName(spgysName);
			}
			if (StringUtil.isNotEmpty(spgysPhone)) {
				spgys.setSpgysPhone(spgysPhone);
			}
			if (StringUtil.isNotEmpty(spgysId)) {
				spgys.setSpgysId(Integer.parseInt(spgysId));
			}
			if (StringUtil.isNotEmpty(spgysType)) {
				spgys.setSpgysType(Integer.parseInt(spgysType));
			}
			if (StringUtil.isNotEmpty(spgysType1)) {
				spgys.setSpgysType1(Integer.parseInt(spgysType1));
			}
			JSONArray jsonArray = JSONArray.fromObject(spgysService.querySpgyss(
					spgys, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = spgysService.querySpgyss(spgys, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spgysComboList() throws Exception {
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("spgysName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(spgysService.querySpgyss(null,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSpgyss(List<Spgys> spgyss) {
		this.spgyss = spgyss;
	}
}
