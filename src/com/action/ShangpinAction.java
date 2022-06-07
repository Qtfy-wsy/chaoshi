package com.action;

import java.util.ArrayList;
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

import com.model.Shangpin;
import com.service.ShangpinService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Sptype;
import com.service.SptypeService;
import com.model.User;
import com.service.UserService;

import com.action.UploadFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@Component("shangpinAction")
@Scope("prototype")
public class ShangpinAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private ShangpinService shangpinService;

	private Shangpin shangpin;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Shangpin> shangpins;

	public Shangpin getShangpin() {
		return shangpin;
	}

	public void setShangpin(Shangpin shangpin) {
		this.shangpin = shangpin;
	}

	public ShangpinService getShangpinService() {
		return shangpinService;
	}

	@Resource
	public void setShangpinService(ShangpinService shangpinService) {
		this.shangpinService = shangpinService;
	}

	@Autowired
	private SptypeService sptypeService;
	private Sptype sptype;

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

	// 导入Excel
	@SuppressWarnings("deprecation")
	public void daoruShangpin() throws Exception {
		try {
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);
			excelFile = new FileInputStream(target);
			Workbook wb = new HSSFWorkbook(excelFile);
			Sheet sheet = wb.getSheetAt(0);
			int rowNum = sheet.getLastRowNum() + 1;
			for (int i = 1; i < rowNum; i++) {
				Shangpin shangpin = new Shangpin();
				Row row = sheet.getRow(i);
				int cellNum = row.getLastCellNum();
				for (int j = 0; j < cellNum; j++) {
					Cell cell = row.getCell(j);
					String cellValue = null;
					switch (cell.getCellType()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0:
						cellValue = String.valueOf((int) cell
								.getNumericCellValue());
						break;
					case 1:
						cellValue = cell.getStringCellValue();
						break;
					case 2:
						cellValue = cell.getStringCellValue();
						break;
					case 3:
						cellValue = cell.getStringCellValue();
						break;
					case 4:
						cellValue = cell.getStringCellValue();
						break;
					case 5:
						cellValue = cell.getStringCellValue();
						break;
					case 6:
						cellValue = cell.getStringCellValue();
						break;
					case 7:
						cellValue = cell.getStringCellValue();
						break;
					case 8:
						cellValue = cell.getStringCellValue();
						break;
					}

					switch (j) {// 通过列数来判断对应插如的字段
					case 1:
						shangpin.setShangpinName(cellValue);
						break;
					case 2:
						shangpin.setShangpinMark(cellValue);
						break;
					case 3:
						shangpin.setShangpinMark1(cellValue);
						break;
					case 4:
						shangpin.setShangpinMark2(cellValue);
						break;
					case 5:
						shangpin.setShangpinMark3(cellValue);
						break;
					case 6:
						shangpin.setShangpinType(Integer.parseInt(cellValue));
						break;
					case 7:
						shangpin.setShangpinType1(Integer.parseInt(cellValue));
						break;
					case 8:
						shangpin.setSptypeId(Integer.parseInt(cellValue));
						Sptype sptype = new Sptype();
						sptype = sptypeService.getSptype(Integer.parseInt(cellValue));
						shangpin.setSptypeName(sptype.getSptypeName());
						break;
					}
				}
				shangpinService.save(shangpin);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void daochuShangpin() {

		String delIds = getParam("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("shangpins记录");
		// 添加表头行
		HSSFRow hssfRow = sheet.createRow(0);
		// 设置单元格格式居中
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

		// 添加表头内容
		HSSFCell headCell = hssfRow.createCell(0);
		headCell.setCellValue("编号");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(1);
		headCell.setCellValue("商品");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(2);
		headCell.setCellValue("备注");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(3);
		headCell.setCellValue("备注1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(4);
		headCell.setCellValue("备注2");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(5);
		headCell.setCellValue("备注3");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(6);
		headCell.setCellValue("时间");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(7);
		headCell.setCellValue("时间1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(8);
		headCell.setCellValue("总数");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(9);
		headCell.setCellValue("进总");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(10);
		headCell.setCellValue("出总");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(11);
		headCell.setCellValue("利润");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(12);
		headCell.setCellValue("标志1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(13);
		headCell.setCellValue("总数");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(14);
		headCell.setCellValue("类型");
		headCell.setCellStyle(cellStyle);

		// 添加数据内容
		for (int i = 0; i < str.length; i++) {
			hssfRow = sheet.createRow(i + 1);
			Shangpin shangpin = shangpinService.getShangpin(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(shangpin.getShangpinId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(shangpin.getShangpinName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(shangpin.getShangpinMark());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(shangpin.getShangpinMark1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			cell.setCellValue(shangpin.getShangpinMark2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(5);
			cell.setCellValue(shangpin.getShangpinMark3());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(6);
			cell.setCellValue(shangpin.getShangpinDate());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(shangpin.getShangpinDate1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(8);
			cell.setCellValue(shangpin.getShangpinZong());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(9);
			cell.setCellValue(shangpin.getShangpinJin());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(10);
			cell.setCellValue(shangpin.getShangpinXiao());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(11);
			cell.setCellValue(shangpin.getShangpinLirun());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(12);
			if (shangpin.getShangpinType() == 0) {
				cell.setCellValue("否");
				cell.setCellStyle(cellStyle);
			} else {
				cell.setCellValue("是");
				cell.setCellStyle(cellStyle);
			}

			cell = hssfRow.createCell(13);
			cell.setCellValue(shangpin.getShangpinType1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(14);
			cell.setCellValue(shangpin.getSptypeName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/shangpin"
					+ strdate + ".xls");
			workbook.write(outputStream);
			outputStream.close();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addShangpin() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String shangpinName = getParam("shangpinName");
			String shangpinMark = getParam("shangpinMark");
			String shangpinMark1 = getParam("shangpinMark1");
			String shangpinMark2 = getParam("shangpinMark2");
			String shangpinMark3 = getParam("shangpinMark3");
			String shangpinDate = getParam("shangpinDate");
			String shangpinDate1 = getParam("shangpinDate1");
			String shangpinZong = getParam("shangpinZong");
			String shangpinType = getParam("shangpinType");
			String shangpinType1 = getParam("shangpinType1");
			String sptypeId = getParam("sptypeId");
			String shangpinJin = getParam("shangpinJin");
			String userId = getParam("userId");
			String shangpinId = getParam("shangpinId");
			Shangpin shangpin = new Shangpin();

			if (StringUtil.isNotEmpty(shangpinId)) {
				shangpin = shangpinService.getShangpin(Integer.parseInt(shangpinId));
			}
			if (StringUtil.isNotEmpty(shangpinName)) {
				shangpin.setShangpinName(shangpinName);
			}
			if (StringUtil.isNotEmpty(shangpinMark)) {
				shangpin.setShangpinMark(shangpinMark);
			}
			if (StringUtil.isNotEmpty(shangpinMark1)) {
				shangpin.setShangpinMark1(shangpinMark1);
			}
			if (StringUtil.isNotEmpty(shangpinMark2)) {
				shangpin.setShangpinMark2(shangpinMark2);
			}
			if (StringUtil.isNotEmpty(shangpinMark3)) {
				shangpin.setShangpinMark3(shangpinMark3);
			}
			if (StringUtil.isNotEmpty(shangpinDate)) {
				shangpin.setShangpinDate(DateUtil.formatString(shangpinDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(shangpinDate1)) {
				shangpin.setShangpinDate1(DateUtil.formatString(shangpinDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(shangpinZong)) {
				shangpin.setShangpinZong(Integer.parseInt(shangpinZong));
			}
			if (StringUtil.isNotEmpty(shangpinType)) {
				shangpin.setShangpinType(Integer.parseInt(shangpinType));
			}
			if (StringUtil.isNotEmpty(shangpinType1)) {
				shangpin.setShangpinType1(Integer.parseInt(shangpinType1));
			}
			if (StringUtil.isNotEmpty(sptypeId)) {
				shangpin.setSptypeId(Integer.parseInt(sptypeId));
				Sptype sptype = new Sptype();
				sptype = sptypeService.getSptype(Integer.parseInt(sptypeId));
				shangpin.setSptypeName(sptype.getSptypeName());
			}
			if (StringUtil.isNotEmpty(userId)) {
				shangpin.setUserId(Integer.parseInt(userId));
				User user = new User();
				user = userService.getUser(Integer.parseInt(userId));
				shangpin.setUserName(user.getUserName());
				shangpin.setBumenId(user.getBumenId());
				shangpin.setBumenName(user.getBumenName());
				shangpin.setRoleId(user.getRoleId());
				shangpin.setRoleName(user.getRoleName());
			}
			if (StringUtil.isNotEmpty(shangpinJin)) {
				shangpin.setShangpinJin(Double.parseDouble(shangpinJin));
			}
			if (StringUtil.isNotEmpty(shangpinId)) {
				shangpinService.modifyShangpin(shangpin);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date date = new Date();
				shangpin.setShangpinDate(date);
				shangpin.setShangpinType(0);
				shangpin.setShangpinZong(0);
				shangpin.setShangpinXiao(0.0);
				shangpin.setShangpinJin(0.0);
				shangpin.setShangpinLirun(0.0);
				shangpinService.save(shangpin);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanShangpin() throws Exception {
		try {
			String shangpinId = getParam("shangpinId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Shangpin shangpin = shangpinService.getShangpin(Integer.parseInt(shangpinId));
			shangpin.setShangpinImg(shangchuandizhi);
			shangpin.setShangpinImgName(shangchuanname);
			shangpinService.modifyShangpin(shangpin);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteShangpin() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				shangpinService.deleteShangpin(Integer.parseInt(str[i]));
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

	public void getShangpins() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String shangpinName = getParam("shangpinName");
		String shangpinId = getParam("shangpinId");
		String shangpinType = getParam("shangpinType");
		String shangpinType1 = getParam("shangpinType1");
		String sptypeId = getParam("sptypeId");
		String userId = getParam("userId");
		String bumenId = getParam("bumenId");
		String roleId = getParam("roleId");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		String sdate1 = getParam("sdate1");
		String edate1 = getParam("edate1");
		Shangpin shangpin = new Shangpin();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(shangpinName)) {
				shangpin.setShangpinName(shangpinName);
			}
			if (StringUtil.isNotEmpty(shangpinId)) {
				shangpin.setShangpinId(Integer.parseInt(shangpinId));
			}
			if (StringUtil.isNotEmpty(shangpinType)) {
				shangpin.setShangpinType(Integer.parseInt(shangpinType));
			}
			if (StringUtil.isNotEmpty(shangpinType1)) {
				shangpin.setShangpinType1(Integer.parseInt(shangpinType1));
			}
			if (StringUtil.isNotEmpty(sptypeId)) {
				shangpin.setSptypeId(Integer.parseInt(sptypeId));
			}
			if (StringUtil.isNotEmpty(userId)) {
				shangpin.setUserId(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				shangpin.setBumenId(Integer.parseInt(bumenId));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				shangpin.setRoleId(Integer.parseInt(roleId));
			}
			if (StringUtil.isNotEmpty(sdate1)) {
				Date date = new Date();
				sdate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
			}
			if (StringUtil.isNotEmpty(edate1)) {
				Date date = new Date();
				edate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
			}
			JSONArray jsonArray = JSONArray.fromObject(shangpinService.queryShangpins(
					shangpin, pageBean, sdate, edate, sdate1, edate1));
			JSONObject result = new JSONObject();
			int total = shangpinService.queryShangpins(shangpin, null, sdate, edate, sdate1, edate1).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangpinComboList() throws Exception {

		String shangpinType = getParam("shangpinType");
		Shangpin shangpin = new Shangpin();
		try {
			if (StringUtil.isNotEmpty(shangpinType)) {
				shangpin.setShangpinType(Integer.parseInt(shangpinType));
			}
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("shangpinName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(shangpinService.queryShangpins(shangpin,
					null, null, null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setShangpins(List<Shangpin> shangpins) {
		this.shangpins = shangpins;
	}
	
	public void shangpinTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String userId=request.getParameter("userId");
		List<Integer> shangpinIds = new ArrayList<Integer>();
		List<String> shangpinNames = new ArrayList<String>();
		List<Integer> shangpinZongshus = new ArrayList<Integer>();
		List<Shangpin> shangpins = new ArrayList<Shangpin>();
		Integer zongshushuliang = 0;
		Shangpin shangpin = new Shangpin();
		if (StringUtil.isNotEmpty(userId)) {
			shangpin.setUserId(Integer.parseInt(userId));
		}
		try {
			shangpins = shangpinService.queryShangpins(null, null, sdate, edate, null, null);
			for(int i=0;i<shangpins.size();i++){
				shangpinIds.add(shangpins.get(i).getShangpinId());
				shangpinNames.add(shangpins.get(i).getShangpinName());
				Integer shangpinZongshu = 0;
				shangpinZongshu = shangpins.get(i).getShangpinZong();
				zongshushuliang = zongshushuliang + shangpinZongshu;
				shangpinZongshus.add(shangpinZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("shangpinNames", shangpinNames);
			session.setAttribute("shangpinZongshus", shangpinZongshus);
			session.setAttribute("zongshushuliang", zongshushuliang);
			response.sendRedirect("admin/shangpintongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void caigouTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String userId=request.getParameter("userId");
		List<Integer> shangpinIds = new ArrayList<Integer>();
		List<String> shangpinNames = new ArrayList<String>();
		List<Double> shangpinZongshus = new ArrayList<Double>();
		List<Shangpin> shangpins = new ArrayList<Shangpin>();
		Double zongshucaigou = 0.0;
		Shangpin shangpin = new Shangpin();
		if (StringUtil.isNotEmpty(userId)) {
			shangpin.setUserId(Integer.parseInt(userId));
		}
		try {
			shangpins = shangpinService.queryShangpins(null, null, sdate, edate, null, null);
			for(int i=0;i<shangpins.size();i++){
				shangpinIds.add(shangpins.get(i).getShangpinId());
				shangpinNames.add(shangpins.get(i).getShangpinName());
				Double shangpinZongshu = 0.0;
				shangpinZongshu = shangpins.get(i).getShangpinJin();
				zongshucaigou = zongshucaigou + shangpinZongshu;
				shangpinZongshus.add(shangpinZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("shangpinNames", shangpinNames);
			session.setAttribute("shangpinZongshus", shangpinZongshus);
			session.setAttribute("zongshucaigou", zongshucaigou);
			response.sendRedirect("admin/shangpintongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xiaoshouTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String userId=request.getParameter("userId");
		List<Integer> shangpinIds = new ArrayList<Integer>();
		List<String> shangpinNames = new ArrayList<String>();
		List<Double> shangpinZongshus = new ArrayList<Double>();
		List<Shangpin> shangpins = new ArrayList<Shangpin>();
		Double zongshuxiaoshou = 0.0;
		Shangpin shangpin = new Shangpin();
		if (StringUtil.isNotEmpty(userId)) {
			shangpin.setUserId(Integer.parseInt(userId));
		}
		try {
			shangpins = shangpinService.queryShangpins(null, null, sdate, edate, null, null);
			for(int i=0;i<shangpins.size();i++){
				shangpinIds.add(shangpins.get(i).getShangpinId());
				shangpinNames.add(shangpins.get(i).getShangpinName());
				Double shangpinZongshu = 0.0;
				shangpinZongshu = shangpins.get(i).getShangpinXiao();
				zongshuxiaoshou = zongshuxiaoshou + shangpinZongshu;
				shangpinZongshus.add(shangpinZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("shangpinNames", shangpinNames);
			session.setAttribute("shangpinZongshus", shangpinZongshus);
			session.setAttribute("zongshuxiaoshou", zongshuxiaoshou);
			response.sendRedirect("admin/shangpintongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
