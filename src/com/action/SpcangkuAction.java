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

import com.model.Spcangku;
import com.service.SpcangkuService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Bumen;
import com.service.BumenService;
import com.model.Role;
import com.service.RoleService;

@Component("spcangkuAction")
@Scope("prototype")
public class SpcangkuAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private SpcangkuService spcangkuService;

	private Spcangku spcangku;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Spcangku> spcangkus;

	public Spcangku getSpcangku() {
		return spcangku;
	}

	public void setSpcangku(Spcangku spcangku) {
		this.spcangku = spcangku;
	}

	public SpcangkuService getSpcangkuService() {
		return spcangkuService;
	}

	@Resource
	public void setSpcangkuService(SpcangkuService spcangkuService) {
		this.spcangkuService = spcangkuService;
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

	public void addSpcangku() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String spcangkuName = getParam("spcangkuName");
			String spcangkuPhone = getParam("spcangkuPhone");
			String spcangkuMark = getParam("spcangkuMark");
			String spcangkuMark1 = getParam("spcangkuMark1");
			String spcangkuMark2 = getParam("spcangkuMark2");
			String spcangkuDizhi = getParam("spcangkuDizhi");
			String spcangkuDate = getParam("spcangkuDate");
			String spcangkuDate1 = getParam("spcangkuDate1");
			String spcangkuType = getParam("spcangkuType");
			String spcangkuType1 = getParam("spcangkuType1");
			String spcangkuId = getParam("spcangkuId");
			Spcangku spcangku = new Spcangku();

			if (StringUtil.isNotEmpty(spcangkuId)) {
				spcangku = spcangkuService.getSpcangku(Integer.parseInt(spcangkuId));
			}
			if (StringUtil.isNotEmpty(spcangkuName)) {
				spcangku.setSpcangkuName(spcangkuName);
			}
			if (StringUtil.isNotEmpty(spcangkuPhone)) {
				spcangku.setSpcangkuPhone(spcangkuPhone);
			}
			if (StringUtil.isNotEmpty(spcangkuMark)) {
				spcangku.setSpcangkuMark(spcangkuMark);
			}
			if (StringUtil.isNotEmpty(spcangkuMark1)) {
				spcangku.setSpcangkuMark1(spcangkuMark1);
			}
			if (StringUtil.isNotEmpty(spcangkuMark2)) {
				spcangku.setSpcangkuMark2(spcangkuMark2);
			}
			if (StringUtil.isNotEmpty(spcangkuDizhi)) {
				spcangku.setSpcangkuDizhi(spcangkuDizhi);
			}
			if (StringUtil.isNotEmpty(spcangkuDate)) {
				spcangku.setSpcangkuDate(DateUtil.formatString(spcangkuDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spcangkuDate1)) {
				spcangku.setSpcangkuDate1(DateUtil.formatString(spcangkuDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spcangkuType)) {
				spcangku.setSpcangkuType(Integer.parseInt(spcangkuType));
			}
			if (StringUtil.isNotEmpty(spcangkuType1)) {
				spcangku.setSpcangkuType1(Integer.parseInt(spcangkuType1));
			}
			if (StringUtil.isNotEmpty(spcangkuId)) {
				spcangkuService.modifySpcangku(spcangku);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				spcangkuService.save(spcangku);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSpcangku() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				spcangkuService.deleteSpcangku(Integer.parseInt(str[i]));
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

	public void getSpcangkus() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String spcangkuName = getParam("spcangkuName");
		String spcangkuPhone = getParam("spcangkuPhone");
		String spcangkuId = getParam("spcangkuId");
		String spcangkuType1 = getParam("spcangkuType1");
		String spcangkuType = getParam("spcangkuType");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		Spcangku spcangku = new Spcangku();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(spcangkuName)) {
				spcangku.setSpcangkuName(spcangkuName);
			}
			if (StringUtil.isNotEmpty(spcangkuPhone)) {
				spcangku.setSpcangkuPhone(spcangkuPhone);
			}
			if (StringUtil.isNotEmpty(spcangkuId)) {
				spcangku.setSpcangkuId(Integer.parseInt(spcangkuId));
			}
			if (StringUtil.isNotEmpty(spcangkuType)) {
				spcangku.setSpcangkuType(Integer.parseInt(spcangkuType));
			}
			if (StringUtil.isNotEmpty(spcangkuType1)) {
				spcangku.setSpcangkuType1(Integer.parseInt(spcangkuType1));
			}
			JSONArray jsonArray = JSONArray.fromObject(spcangkuService.querySpcangkus(
					spcangku, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = spcangkuService.querySpcangkus(spcangku, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spcangkuComboList() throws Exception {
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("spcangkuName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(spcangkuService.querySpcangkus(null,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSpcangkus(List<Spcangku> spcangkus) {
		this.spcangkus = spcangkus;
	}
}
