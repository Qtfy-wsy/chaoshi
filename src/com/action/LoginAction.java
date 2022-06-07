package com.action;
import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Admin;
import com.model.User;
import com.model.Yonghu;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminService;
import com.service.UserService;
import com.service.YonghuService;
import com.util.StringUtil;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	private Admin admin = new Admin();

	private User user = new User();

	public AdminService getAdminService() {
		return adminService;
	}

	@Resource
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	@Autowired
	private YonghuService yonghuService;
	private Yonghu yonghu;

	public YonghuService getYonghuService() {
		return yonghuService;
	}

	@Resource
	public void setYonghuService(YonghuService yonghuService) {
		this.yonghuService = yonghuService;
	}

	public Yonghu getYonghu() {
		return yonghu;
	}

	public void setYonghu(Yonghu yonghu) {
		this.yonghu = yonghu;
	}
	
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);

	public String loginUser() {

		String userName = getParam("userName");
		String password = getParam("password");
		String loginType = getParam("loginType");
		/**********如果没有选择就默认user*********/
		if(StringUtil.isEmpty(loginType)){
			loginType="user";
		}
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
			request.setAttribute("error", "用户名或密码为空！");
			return ERROR;
		} else {
			if (loginType.equals("admin")) {
				Admin admin = new Admin();
				admin.setAdminName(getParam("userName"));
				admin.setAdminPassword(getParam("password"));
				System.out.println("过来了：LoginAction.login；loginType==admin");
				try {
					if ((getAdminService()).login(admin).size() == 1) {						
						ActionContext context = ActionContext.getContext();
						Map session = context.getSession();
						session.put("admin", admin);

						return "admin";
						
					}else{
						request.setAttribute("error", "用户名或密码错误！");
						return ERROR;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			} else if (loginType.equals("yonghu")){
				Yonghu yonghu = new Yonghu();
				yonghu.setYonghuName(getParam("userName"));
				yonghu.setYonghuPassword(getParam("password"));
				try {
					if ((getYonghuService()).login(yonghu).size() == 1) {
						Yonghu yonghuLogin = (getYonghuService()).login(yonghu).get(0);
						ActionContext context = ActionContext.getContext();
						Map session = context.getSession();
						session.put("yonghu", yonghuLogin);
						return "yonghu";
						/**********权限开始*****************/
						//int yonghuType1 = yonghuLogin.getYonghuType1();
						//if(yonghuType1==0){
						//	request.setAttribute("error", "用户已注销，请联系管理员！");
						//	return ERROR;
						//}
						//String yhroleName = yonghuLogin.getYhroleName();
						//return yhroleName;
						/**********权限结束*****************/
					}else{
						request.setAttribute("error", "用户名或密码错误！");
						return ERROR;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			}else{
				User user = new User();
				user.setUserName(getParam("userName"));
				user.setUserPassword(getParam("password"));
				System.out.println("过来了：LoginAction.login；loginType==user");
				try {
					if ((getUserService()).login(user).size() == 1) {
						User userLogin = (getUserService()).login(user).get(0);
						ActionContext context = ActionContext.getContext();
						Map session = context.getSession();
						session.put("user", userLogin);
						//return "user";
						/**********权限开始*****************/
						//int userType1 = userLogin.getUserType1();
						//if(userType1==0){
						//	request.setAttribute("error", "用户已注销，请联系管理员！");
						//	return ERROR;
						//}
						String bumenName = userLogin.getBumenName();
						return bumenName;
						/**********权限结束*****************/
					}else{
						request.setAttribute("error", "用户名或密码错误！");
						return ERROR;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			}
		}
	}

	protected String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

}