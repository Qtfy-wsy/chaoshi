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

 

import com.model.Admin;
import com.service.AdminService;
import net.sf.json.JSONObject;

@Component("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private AdminService adminService;

	private Admin admin;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Admin> admins;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	@Resource
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext
			.get(ServletActionContext.HTTP_RESPONSE);

	public void mimaAdmin() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String adminPassword = getParam("adminPassword");
			String adminPassword1 = getParam("adminPassword1");
			Admin admin = new Admin();
			admin.setAdminName("admin");
			admin.setAdminPassword(adminPassword);
			if ((getAdminService()).login(admin).size() == 1) {
				admin = (getAdminService()).login(admin).get(0);
				admin.setAdminPassword(adminPassword1);
				adminService.modifyAdmin(admin);
				request.setAttribute("error", "密码修改成功！");
				request.getRequestDispatcher("adminmima.jsp").forward(request,
						response);
			}else{
				result.put("success", "true");
				request.setAttribute("error", "原密码错误，请重新输入！");
				request.getRequestDispatcher("adminmima.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
}
