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

import com.model.Role;
import com.service.RoleService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("roleAction")
@Scope("prototype")
public class RoleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RoleService roleService;

	private Role role;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Role> roles;

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
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	public void addRole() throws Exception {
		try {
			JSONObject result = new JSONObject();
			
			String roleName = getParam("roleName");
			String roleMark = getParam("roleMark");
			String roleMark1 = getParam("roleMark1");
			String roleMark2 = getParam("roleMark2");
			String roleId = getParam("roleId");
			Role role = new Role();
			
			if (StringUtil.isNotEmpty(roleId)) {
				role = roleService.getRole(Integer.parseInt(roleId));
			}
			if (StringUtil.isNotEmpty(roleName)) {
				role.setRoleName(roleName);
			}
			if (StringUtil.isNotEmpty(roleMark)) {
				role.setRoleMark(roleMark);
			}
			if (StringUtil.isNotEmpty(roleMark1)) {
				role.setRoleMark1(roleMark1);
			}
			if (StringUtil.isNotEmpty(roleMark2)) {
				role.setRoleMark2(Integer.parseInt(roleMark2));
			}

			if (StringUtil.isNotEmpty(roleId)) {
				roleService.modifyRole(role);
			} else {
				roleService.save(role);
			}
			result.put("success", "true");

			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deleteRole() throws Exception {
		try {
						
			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				roleService.deleteRole(Integer.parseInt(str[i]));
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

	public void getRoles() throws Exception {
			
		String page = getParam("page");
		String rows = getParam("rows");
		String roleName = getParam("roleName");
		String roleMark2 = getParam("roleMark2");
		Role role = new Role();
		if (StringUtil.isNotEmpty(roleName)) {
			role.setRoleName(roleName);
		}
		if (StringUtil.isNotEmpty(roleMark2)) {
			role.setRoleMark2(Integer.parseInt(roleMark2));
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(roleService.queryRoles(role, pageBean));
			JSONObject result = new JSONObject();
			int total = roleService.queryRoles(role, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void roleComboList() throws Exception {
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("roleName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(roleService.queryRoles(null,null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
