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

import com.model.Yxinxi;
import com.service.YxinxiService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Yxtype;
import com.service.YxtypeService;
import com.model.Yonghu;
import com.service.YonghuService;
import com.action.UploadFile;

import java.io.File;
import java.io.InputStream;

@Component("yxinxiAction")
@Scope("prototype")
public class YxinxiAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private YxinxiService yxinxiService;

	private Yxinxi yxinxi;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Yxinxi> yxinxis;

	public Yxinxi getYxinxi() {
		return yxinxi;
	}

	public void setYxinxi(Yxinxi yxinxi) {
		this.yxinxi = yxinxi;
	}

	public YxinxiService getYxinxiService() {
		return yxinxiService;
	}

	@Resource
	public void setYxinxiService(YxinxiService yxinxiService) {
		this.yxinxiService = yxinxiService;
	}

	@Autowired
	private YxtypeService yxtypeService;
	private Yxtype yxtype;

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

	@Autowired
	private YonghuService yonghuService;
	private Yonghu yonghu;

	public Yonghu getYonghu() {
		return yonghu;
	}

	public void setYonghu(Yonghu yonghu) {
		this.yonghu = yonghu;
	}

	public YonghuService getYonghuService() {
		return yonghuService;
	}

	@Resource
	public void setYonghuService(YonghuService yonghuService) {
		this.yonghuService = yonghuService;
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

	public void addYxinxi() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String yxinxiName = getParam("yxinxiName");
			String yxinxiMark = getParam("yxinxiMark");
			String yxinxiMark1 = getParam("yxinxiMark1");
			String yxinxiMark2 = getParam("yxinxiMark2");
			String yxinxiDate = getParam("yxinxiDate");
			String yxinxiType = getParam("yxinxiType");
			String yxinxiType1 = getParam("yxinxiType1");
			String yxtypeId = getParam("yxtypeId");
			String yonghuId = getParam("yonghuId");
			String yxinxiId = getParam("yxinxiId");
			Yxinxi yxinxi = new Yxinxi();

			if (StringUtil.isNotEmpty(yxinxiId)) {
				yxinxi = yxinxiService.getYxinxi(Integer.parseInt(yxinxiId));
			}
			if (StringUtil.isNotEmpty(yxinxiName)) {
				yxinxi.setYxinxiName(yxinxiName);
			}
			if (StringUtil.isNotEmpty(yxinxiMark)) {
				yxinxi.setYxinxiMark(yxinxiMark);
			}
			if (StringUtil.isNotEmpty(yxinxiMark1)) {
				yxinxi.setYxinxiMark1(yxinxiMark1);
			}
			if (StringUtil.isNotEmpty(yxinxiMark2)) {
				yxinxi.setYxinxiMark2(yxinxiMark2);
			}
			if (StringUtil.isNotEmpty(yxinxiDate)) {
				yxinxi.setYxinxiDate(DateUtil.formatString(yxinxiDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(yxinxiType)) {
				yxinxi.setYxinxiType(Integer.parseInt(yxinxiType));
			}
			if (StringUtil.isNotEmpty(yxinxiType1)) {
				yxinxi.setYxinxiType1(Integer.parseInt(yxinxiType1));
			}
			if (StringUtil.isNotEmpty(yxtypeId)) {
				yxinxi.setYxtypeId(Integer.parseInt(yxtypeId));
				Yxtype yxtype = new Yxtype();
				yxtype = yxtypeService.getYxtype(Integer.parseInt(yxtypeId));
				yxinxi.setYxtypeName(yxtype.getYxtypeName());
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				yxinxi.setYonghuId(Integer.parseInt(yonghuId));
				Yonghu yonghu = new Yonghu();
				yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
				yxinxi.setYonghuName(yonghu.getYonghuName());
				yxinxi.setYhbumenId(yonghu.getYhbumenId());
				yxinxi.setYhbumenName(yonghu.getYhbumenName());
			}
			if (StringUtil.isNotEmpty(yxinxiId)) {
				yxinxiService.modifyYxinxi(yxinxi);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date yxinxiDate1 = new Date();
				yxinxi.setYxinxiDate(yxinxiDate1);
				yxinxiService.save(yxinxi);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanYxinxi() throws Exception {
		try {
			String yxinxiId = getParam("yxinxiId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Yxinxi yxinxi = yxinxiService.getYxinxi(Integer.parseInt(yxinxiId));
			yxinxi.setYxinxiImg(shangchuandizhi);
			yxinxi.setYxinxiImgName(shangchuanname);
			yxinxiService.modifyYxinxi(yxinxi);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteYxinxi() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				yxinxiService.deleteYxinxi(Integer.parseInt(str[i]));
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

	public void getYxinxis() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String yxinxiName = getParam("yxinxiName");
		String yxinxiId = getParam("yxinxiId");
		String yxtypeId = getParam("yxtypeId");
		String yxinxiType = getParam("yxinxiType");
		String yxinxiType1 = getParam("yxinxiType1");
		String yonghuId = getParam("yonghuId");
		String yhbumenId = getParam("yhbumenId");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		Yxinxi yxinxi = new Yxinxi();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(yxinxiName)) {
				yxinxi.setYxinxiName(yxinxiName);
			}
			if (StringUtil.isNotEmpty(yxinxiId)) {
				yxinxi.setYxinxiId(Integer.parseInt(yxinxiId));
			}
			if (StringUtil.isNotEmpty(yxtypeId)) {
				yxinxi.setYxtypeId(Integer.parseInt(yxtypeId));
			}
			if (StringUtil.isNotEmpty(yxinxiType)) {
				yxinxi.setYxinxiType(Integer.parseInt(yxinxiType));
			}
			if (StringUtil.isNotEmpty(yxinxiType1)) {
				yxinxi.setYxinxiType1(Integer.parseInt(yxinxiType1));
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				yxinxi.setYonghuId(Integer.parseInt(yonghuId));
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				yxinxi.setYhbumenId(Integer.parseInt(yhbumenId));
			}
			JSONArray jsonArray = JSONArray.fromObject(yxinxiService.queryYxinxis(
					yxinxi, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = yxinxiService.queryYxinxis(yxinxi, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yxinxiComboList() throws Exception {
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("yxinxiName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(yxinxiService.queryYxinxis(null,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setYxinxis(List<Yxinxi> yxinxis) {
		this.yxinxis = yxinxis;
	}
}
