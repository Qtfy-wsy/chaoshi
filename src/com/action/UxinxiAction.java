package com.action;

import java.util.Date;
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

import com.model.Uxinxi;
import com.service.UxinxiService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Uxtype;
import com.service.UxtypeService;
import com.model.User;
import com.service.UserService;
import com.action.UploadFile;

import java.io.File;
import java.io.InputStream;

@Component("uxinxiAction")
@Scope("prototype")
public class UxinxiAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private UxinxiService uxinxiService;

	private Uxinxi uxinxi;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Uxinxi> uxinxis;

	public Uxinxi getUxinxi() {
		return uxinxi;
	}

	public void setUxinxi(Uxinxi uxinxi) {
		this.uxinxi = uxinxi;
	}

	public UxinxiService getUxinxiService() {
		return uxinxiService;
	}

	@Resource
	public void setUxinxiService(UxinxiService uxinxiService) {
		this.uxinxiService = uxinxiService;
	}

	@Autowired
	private UxtypeService uxtypeService;
	private Uxtype uxtype;

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

	@Autowired
	private UserService userService;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext
			.get(ServletActionContext.HTTP_RESPONSE);

	private InputStream excelFile;
	private File uploadFile;
	private String uploadFileFileName;

	public InputStream getExcelFile() {
		return excelFile;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public void addUxinxi() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String uxinxiName = getParam("uxinxiName");
			String uxinxiMark = getParam("uxinxiMark");
			String uxinxiMark1 = getParam("uxinxiMark1");
			String uxinxiMark2 = getParam("uxinxiMark2");
			String uxinxiDate = getParam("uxinxiDate");
			String uxinxiType = getParam("uxinxiType");
			String uxinxiType1 = getParam("uxinxiType1");
			String uxtypeId = getParam("uxtypeId");
			String userId = getParam("userId");
			String uxinxiId = getParam("uxinxiId");
			Uxinxi uxinxi = new Uxinxi();

			if (StringUtil.isNotEmpty(uxinxiId)) {
				uxinxi = uxinxiService.getUxinxi(Integer.parseInt(uxinxiId));
			}
			if (StringUtil.isNotEmpty(uxinxiName)) {
				uxinxi.setUxinxiName(uxinxiName);
			}
			if (StringUtil.isNotEmpty(uxinxiMark)) {
				uxinxi.setUxinxiMark(uxinxiMark);
			}
			if (StringUtil.isNotEmpty(uxinxiMark1)) {
				uxinxi.setUxinxiMark1(uxinxiMark1);
			}
			if (StringUtil.isNotEmpty(uxinxiMark2)) {
				uxinxi.setUxinxiMark2(uxinxiMark2);
			}
			if (StringUtil.isNotEmpty(uxinxiDate)) {
				uxinxi.setUxinxiDate(DateUtil.formatString(uxinxiDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(uxinxiType)) {
				uxinxi.setUxinxiType(Integer.parseInt(uxinxiType));
			}
			if (StringUtil.isNotEmpty(uxinxiType1)) {
				uxinxi.setUxinxiType1(Integer.parseInt(uxinxiType1));
			}
			if (StringUtil.isNotEmpty(uxtypeId)) {
				uxinxi.setUxtypeId(Integer.parseInt(uxtypeId));
				Uxtype uxtype = new Uxtype();
				uxtype = uxtypeService.getUxtype(Integer.parseInt(uxtypeId));
				uxinxi.setUxtypeName(uxtype.getUxtypeName());
			}
			if (StringUtil.isNotEmpty(userId)) {
				uxinxi.setUserId(Integer.parseInt(userId));
				User user = new User();
				user = userService.getUser(Integer.parseInt(userId));
				uxinxi.setUserName(user.getUserName());
				uxinxi.setBumenId(user.getBumenId());
				uxinxi.setBumenName(user.getBumenName());
			}
			if (StringUtil.isNotEmpty(uxinxiId)) {
				uxinxiService.modifyUxinxi(uxinxi);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date uxinxiDate1 = new Date();
				uxinxi.setUxinxiDate(uxinxiDate1);
				uxinxiService.save(uxinxi);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanUxinxi() throws Exception {
		try {
			String uxinxiId = getParam("uxinxiId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Uxinxi uxinxi = uxinxiService.getUxinxi(Integer.parseInt(uxinxiId));
			uxinxi.setUxinxiImg(shangchuandizhi);
			uxinxi.setUxinxiImgName(shangchuanname);
			uxinxiService.modifyUxinxi(uxinxi);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteUxinxi() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				uxinxiService.deleteUxinxi(Integer.parseInt(str[i]));
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

	public void getUxinxis() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String uxinxiName = getParam("uxinxiName");
		String uxinxiId = getParam("uxinxiId");
		String uxtypeId = getParam("uxtypeId");
		String uxinxiType = getParam("uxinxiType");
		String uxinxiType1 = getParam("uxinxiType1");
		String userId = getParam("userId");
		String bumenId = getParam("bumenId");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		Uxinxi uxinxi = new Uxinxi();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(uxinxiName)) {
				uxinxi.setUxinxiName(uxinxiName);
			}
			if (StringUtil.isNotEmpty(uxinxiId)) {
				uxinxi.setUxinxiId(Integer.parseInt(uxinxiId));
			}
			if (StringUtil.isNotEmpty(uxtypeId)) {
				uxinxi.setUxtypeId(Integer.parseInt(uxtypeId));
			}
			if (StringUtil.isNotEmpty(uxinxiType)) {
				uxinxi.setUxinxiType(Integer.parseInt(uxinxiType));
			}
			if (StringUtil.isNotEmpty(uxinxiType1)) {
				uxinxi.setUxinxiType1(Integer.parseInt(uxinxiType1));
			}
			if (StringUtil.isNotEmpty(userId)) {
				uxinxi.setUserId(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				uxinxi.setBumenId(Integer.parseInt(bumenId));
			}
			JSONArray jsonArray = JSONArray.fromObject(uxinxiService.queryUxinxis(
					uxinxi, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = uxinxiService.queryUxinxis(uxinxi, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uxinxiComboList() throws Exception {
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("uxinxiName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(uxinxiService.queryUxinxis(null,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUxinxis(List<Uxinxi> uxinxis) {
		this.uxinxis = uxinxis;
	}
}
