package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.model.Gonggao;
import com.service.GonggaoService;
import com.model.PageBean;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Ggtype;
import com.service.GgtypeService;

import com.action.UploadFile;

import java.io.File;
import java.io.InputStream;

@Component("gonggaoAction")
@Scope("prototype")
public class GonggaoAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private GonggaoService gonggaoService;

	private Gonggao gonggao;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Gonggao> gonggaos;

	public Gonggao getGonggao() {
		return gonggao;
	}

	public void setGonggao(Gonggao gonggao) {
		this.gonggao = gonggao;
	}

	public GonggaoService getGonggaoService() {
		return gonggaoService;
	}

	@Resource
	public void setGonggaoService(GonggaoService gonggaoService) {
		this.gonggaoService = gonggaoService;
	}

	@Autowired
	private GgtypeService ggtypeService;
	private Ggtype ggtype;

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

	public void addGonggao() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String gonggaoName = getParam("gonggaoName");
			String gonggaoMark = getParam("gonggaoMark");
			String ggtypeId = getParam("ggtypeId");
			String gonggaoId = getParam("gonggaoId");
			Gonggao gonggao = new Gonggao();

			if (StringUtil.isNotEmpty(gonggaoId)) {
				gonggao = gonggaoService.getGonggao(Integer.parseInt(gonggaoId));
			}
			if (StringUtil.isNotEmpty(gonggaoName)) {
				gonggao.setGonggaoName(gonggaoName);
			}
			if (StringUtil.isNotEmpty(gonggaoMark)) {
				gonggao.setGonggaoMark(gonggaoMark);
			}
			if (StringUtil.isNotEmpty(ggtypeId)) {
				gonggao.setGgtypeId(Integer.parseInt(ggtypeId));
				Ggtype ggtype = new Ggtype();
				ggtype = ggtypeService.getGgtype(Integer.parseInt(ggtypeId));
				gonggao.setGgtypeName(ggtype.getGgtypeName());
			}
			if (StringUtil.isNotEmpty(gonggaoId)) {
				gonggaoService.modifyGonggao(gonggao);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date gonggaoDate = new Date();
				gonggao.setGonggaoDate(gonggaoDate);
				gonggaoService.save(gonggao);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanGonggao() throws Exception {
		try {
			String gonggaoId = getParam("gonggaoId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Gonggao gonggao = gonggaoService.getGonggao(Integer.parseInt(gonggaoId));
			gonggao.setGonggaoImg(shangchuandizhi);
			gonggao.setGonggaoImgName(shangchuanname);
			gonggaoService.modifyGonggao(gonggao);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteGonggao() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				gonggaoService.deleteGonggao(Integer.parseInt(str[i]));
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

	public void getGonggaos() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String gonggaoName = getParam("gonggaoName");
		String gonggaoId = getParam("gonggaoId");
		String ggtypeId = getParam("ggtypeId");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		Gonggao gonggao = new Gonggao();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(gonggaoName)) {
				gonggao.setGonggaoName(gonggaoName);
			}
			if (StringUtil.isNotEmpty(gonggaoId)) {
				gonggao.setGonggaoId(Integer.parseInt(gonggaoId));
			}
			if (StringUtil.isNotEmpty(ggtypeId)) {
				gonggao.setGgtypeId(Integer.parseInt(ggtypeId));
			}
			JSONArray jsonArray = JSONArray.fromObject(gonggaoService.queryGonggaos(
					gonggao, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = gonggaoService.queryGonggaos(gonggao, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gonggaoComboList() throws Exception {
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("gonggaoName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(gonggaoService.queryGonggaos(null,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setGonggaos(List<Gonggao> gonggaos) {
		this.gonggaos = gonggaos;
	}

	public void neirongGonggao() throws Exception {

		String gonggaoId = getParam("gonggaoId");
		Gonggao gonggao = new Gonggao();
		try {
			gonggao = gonggaoService.getGonggao(Integer.parseInt(gonggaoId));
			
			HttpSession session = request.getSession();
			session.setAttribute("gonggao", gonggao);
			response.sendRedirect("gonggaoneirong.jsp");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
