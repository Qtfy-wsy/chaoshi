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

import com.model.Spjin;
import com.service.SpjinService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Shangpin;
import com.service.ShangpinService;
import com.model.Sptype;
import com.service.SptypeService;
import com.model.Spcangku;
import com.service.SpcangkuService;
import com.model.Spgys;
import com.service.SpgysService;
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

@Component("spjinAction")
@Scope("prototype")
public class SpjinAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private SpjinService spjinService;

	private Spjin spjin;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Spjin> spjins;

	public Spjin getSpjin() {
		return spjin;
	}

	public void setSpjin(Spjin spjin) {
		this.spjin = spjin;
	}

	public SpjinService getSpjinService() {
		return spjinService;
	}

	@Resource
	public void setSpjinService(SpjinService spjinService) {
		this.spjinService = spjinService;
	}

	@Autowired
	private ShangpinService shangpinService;
	private Shangpin shangpin;

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
	private SpgysService spgysService;
	private Spgys spgys;

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
	private SpcangkuService spcangkuService;
	private Spcangku spcangku;

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
	public void daoruSpjin() throws Exception {
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
				Spjin spjin = new Spjin();
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
					case 9:
						cellValue = cell.getStringCellValue();
						break;
					case 10:
						cellValue = cell.getStringCellValue();
						break;
					case 11:
						cellValue = cell.getStringCellValue();
						break;
					case 12:
						cellValue = cell.getStringCellValue();
						break;
					case 13:
						cellValue = cell.getStringCellValue();
						break;
					}

					switch (j) {// 通过列数来判断对应插如的字段
					case 1:
						spjin.setSpjinName(cellValue);
						break;
					case 2:
						spjin.setSpjinMark(cellValue);
						break;
					case 3:
						spjin.setSpjinMark1(cellValue);
						break;
					case 4:
						spjin.setSpjinMark2(cellValue);
						break;
					case 5:
						spjin.setSpjinMark3(cellValue);
						break;
					case 6:
						spjin.setSpjinZong(Integer.parseInt(cellValue));
						break;
					case 7:
						spjin.setSpjinJine(Double.parseDouble(cellValue));
						break;
					case 8:
						spjin.setSpjinType(Integer.parseInt(cellValue));
						break;
					case 9:
						spjin.setSpjinType1(Integer.parseInt(cellValue));
						break;
					case 10:
						spjin.setShangpinId(Integer.parseInt(cellValue));
						Shangpin shangpin = new Shangpin();
						shangpin = shangpinService.getShangpin(Integer.parseInt(cellValue));
						spjin.setShangpinName(shangpin.getShangpinName());
						spjin.setSptypeId(shangpin.getSptypeId());
						spjin.setSptypeName(shangpin.getSptypeName());
						break;
					case 11:
						spjin.setSpgysId(Integer.parseInt(cellValue));
						Spgys spgys = new Spgys();
						spgys = spgysService.getSpgys(Integer.parseInt(cellValue));
						spjin.setSpgysName(spgys.getSpgysName());
						break;
					case 12:
						spjin.setSpcangkuId(Integer.parseInt(cellValue));
						Spcangku spcangku = new Spcangku();
						spcangku = spcangkuService.getSpcangku(Integer.parseInt(cellValue));
						spjin.setSpcangkuName(spcangku.getSpcangkuName());
						break;
					case 13:
						spjin.setUserId(Integer.parseInt(cellValue));
						User user = new User();
						user = userService.getUser(Integer.parseInt(cellValue));
						spjin.setUserName(user.getUserName());
						spjin.setBumenId(user.getBumenId());
						spjin.setBumenName(user.getBumenName());
						spjin.setRoleId(user.getRoleId());
						spjin.setRoleName(user.getRoleName());
						break;
					}
				}
				spjin.setSpjinZe(spjin.getSpjinJine()*spjin.getSpjinZong());
				spjin.setSpjinType(2);
				spjinService.save(spjin);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void daochuSpjin() {

		String delIds = getParam("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("spjins记录");
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
		headCell.setCellValue("单价");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(10);
		headCell.setCellValue("总额");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(11);
		headCell.setCellValue("状态");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(12);
		headCell.setCellValue("商品");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(13);
		headCell.setCellValue("仓库");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(14);
		headCell.setCellValue("供应商");
		headCell.setCellStyle(cellStyle);

		// 添加数据内容
		for (int i = 0; i < str.length; i++) {
			hssfRow = sheet.createRow(i + 1);
			Spjin spjin = spjinService.getSpjin(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(spjin.getSpjinId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(spjin.getSpjinName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(spjin.getSpjinMark());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(spjin.getSpjinMark1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			cell.setCellValue(spjin.getSpjinMark2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(5);
			cell.setCellValue(spjin.getSpjinMark3());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(6);
			cell.setCellValue(spjin.getSpjinDate());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(spjin.getSpjinDate1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(8);
			cell.setCellValue(spjin.getSpjinZong());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(9);
			cell.setCellValue(spjin.getSpjinJine());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(10);
			cell.setCellValue(spjin.getSpjinZe());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(11);
			if (spjin.getSpjinType() == 0) {
				cell.setCellValue("退货");
				cell.setCellStyle(cellStyle);
			} else if(spjin.getSpjinType() == 1){
				cell.setCellValue("通过");
				cell.setCellStyle(cellStyle);
			} else if(spjin.getSpjinType() == 2){
				cell.setCellValue("提交");
				cell.setCellStyle(cellStyle);
			} else{
				cell.setCellValue("其他");
				cell.setCellStyle(cellStyle);
			}

			cell = hssfRow.createCell(12);
			cell.setCellValue(spjin.getShangpinName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(13);
			cell.setCellValue(spjin.getSpcangkuName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(14);
			cell.setCellValue(spjin.getSpgysName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/spjin"
					+ strdate + ".xls");
			workbook.write(outputStream);
			outputStream.close();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSpjin() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String spjinName = getParam("spjinName");
			String spjinMark = getParam("spjinMark");
			String spjinMark1 = getParam("spjinMark1");
			String spjinMark2 = getParam("spjinMark2");
			String spjinMark3 = getParam("spjinMark3");
			String spjinDate = getParam("spjinDate");
			String spjinDate1 = getParam("spjinDate1");
			String spjinZong = getParam("spjinZong");
			String spjinJine = getParam("spjinJine");
			String spjinType = getParam("spjinType");
			String spjinType1 = getParam("spjinType1");
			String shangpinId = getParam("shangpinId");
			String spgysId = getParam("spgysId");
			String spcangkuId = getParam("spcangkuId");
			String userId = getParam("userId");
			String spjinId = getParam("spjinId");
			Spjin spjin = new Spjin();

			if (StringUtil.isNotEmpty(spjinId)) {
				spjin = spjinService.getSpjin(Integer.parseInt(spjinId));
			}
			if (StringUtil.isNotEmpty(spjinName)) {
				spjin.setSpjinName(spjinName);
			}
			if (StringUtil.isNotEmpty(spjinMark)) {
				spjin.setSpjinMark(spjinMark);
			}
			if (StringUtil.isNotEmpty(spjinMark1)) {
				spjin.setSpjinMark1(spjinMark1);
			}
			if (StringUtil.isNotEmpty(spjinMark2)) {
				spjin.setSpjinMark2(spjinMark2);
			}
			if (StringUtil.isNotEmpty(spjinMark3)) {
				spjin.setSpjinMark3(spjinMark3);
			}
			if (StringUtil.isNotEmpty(spjinDate)) {
				spjin.setSpjinDate(DateUtil.formatString(spjinDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spjinDate1)) {
				spjin.setSpjinDate1(DateUtil.formatString(spjinDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spjinZong)) {
				spjin.setSpjinZong(Integer.parseInt(spjinZong));
			}
			if (StringUtil.isNotEmpty(spjinJine)) {
				spjin.setSpjinJine(Double.parseDouble(spjinJine));
			}
			if (StringUtil.isNotEmpty(spjinType)) {
				spjin.setSpjinType(Integer.parseInt(spjinType));
			}
			if (StringUtil.isNotEmpty(spjinType1)) {
				spjin.setSpjinType1(Integer.parseInt(spjinType1));
			}
			if (StringUtil.isNotEmpty(shangpinId)) {
				spjin.setShangpinId(Integer.parseInt(shangpinId));
				Shangpin shangpin = new Shangpin();
				shangpin = shangpinService.getShangpin(Integer.parseInt(shangpinId));
				spjin.setShangpinName(shangpin.getShangpinName());
				spjin.setSptypeId(shangpin.getSptypeId());
				spjin.setSptypeName(shangpin.getSptypeName());
			}
			if (StringUtil.isNotEmpty(spgysId)) {
				spjin.setSpgysId(Integer.parseInt(spgysId));
				Spgys spgys = new Spgys();
				spgys = spgysService.getSpgys(Integer.parseInt(spgysId));
				spjin.setSpgysName(spgys.getSpgysName());
			}
			if (StringUtil.isNotEmpty(spcangkuId)) {
				spjin.setSpcangkuId(Integer.parseInt(spcangkuId));
				Spcangku spcangku = new Spcangku();
				spcangku = spcangkuService.getSpcangku(Integer.parseInt(spcangkuId));
				spjin.setSpcangkuName(spcangku.getSpcangkuName());
			}
			if (StringUtil.isNotEmpty(userId)) {
				spjin.setUserId(Integer.parseInt(userId));
				User user = new User();
				user = userService.getUser(Integer.parseInt(userId));
				spjin.setUserName(user.getUserName());
				spjin.setBumenId(user.getBumenId());
				spjin.setBumenName(user.getBumenName());
				spjin.setRoleId(user.getRoleId());
				spjin.setRoleName(user.getRoleName());
			}
			if (StringUtil.isNotEmpty(spjinId)) {
				spjin.setSpjinZe(spjin.getSpjinJine()*spjin.getSpjinZong());
				spjinService.modifySpjin(spjin);
				if(spjin.getSpjinType()==1){
					Shangpin shangpin = new Shangpin();
					shangpin = shangpinService.getShangpin(spjin.getShangpinId());
					shangpin.setShangpinZong(shangpin.getShangpinZong()+spjin.getSpjinZong());
					shangpin.setShangpinJin(shangpin.getShangpinJin()+spjin.getSpjinZe());
					shangpin.setShangpinLirun(shangpin.getShangpinXiao()-shangpin.getShangpinJin());
					shangpinService.modifyShangpin(shangpin);
				}
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date date = new Date();
				spjin.setSpjinDate(date);
				spjin.setSpjinZe(spjin.getSpjinJine()*spjin.getSpjinZong());
				spjin.setSpjinType(0);
				spjinService.save(spjin);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanSpjin() throws Exception {
		try {
			String spjinId = getParam("spjinId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Spjin spjin = spjinService.getSpjin(Integer.parseInt(spjinId));
			spjin.setSpjinImg(shangchuandizhi);
			spjin.setSpjinImgName(shangchuanname);
			spjinService.modifySpjin(spjin);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteSpjin() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				spjinService.deleteSpjin(Integer.parseInt(str[i]));
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

	public void getSpjins() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String spjinName = getParam("spjinName");
		String spjinId = getParam("spjinId");
		String spjinType = getParam("spjinType");
		String spjinType1 = getParam("spjinType1");
		String sptypeId = getParam("sptypeId");
		String userId = getParam("userId");
		String bumenId = getParam("bumenId");
		String roleId = getParam("roleId");
		String spcangkuId = getParam("spcangkuId");
		String spgysId = getParam("spgysId");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		Spjin spjin = new Spjin();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(spjinName)) {
				spjin.setSpjinName(spjinName);
			}
			if (StringUtil.isNotEmpty(spjinId)) {
				spjin.setSpjinId(Integer.parseInt(spjinId));
			}
			if (StringUtil.isNotEmpty(spjinType)) {
				spjin.setSpjinType(Integer.parseInt(spjinType));
			}
			if (StringUtil.isNotEmpty(spjinType1)) {
				spjin.setSpjinType1(Integer.parseInt(spjinType1));
			}
			if (StringUtil.isNotEmpty(sptypeId)) {
				spjin.setSptypeId(Integer.parseInt(sptypeId));
			}
			if (StringUtil.isNotEmpty(userId)) {
				spjin.setUserId(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				spjin.setBumenId(Integer.parseInt(bumenId));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				spjin.setRoleId(Integer.parseInt(roleId));
			}
			if (StringUtil.isNotEmpty(spcangkuId)) {
				spjin.setSpcangkuId(Integer.parseInt(spcangkuId));
			}
			if (StringUtil.isNotEmpty(spgysId)) {
				spjin.setSpgysId(Integer.parseInt(spgysId));
			}
			JSONArray jsonArray = JSONArray.fromObject(spjinService.querySpjins(
					spjin, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = spjinService.querySpjins(spjin, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spjinComboList() throws Exception {
		String spjinType = getParam("spjinType");
		Spjin spjin = new Spjin();
		try {
			if (StringUtil.isNotEmpty(spjinType)) {
				spjin.setSpjinType(Integer.parseInt(spjinType));
			}
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("spjinName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(spjinService.querySpjins(spjin,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSpjins(List<Spjin> spjins) {
		this.spjins = spjins;
	}
	
	public void spjinTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String userId=request.getParameter("userId");
		String sptypeId=request.getParameter("sptypeId");
		List<Integer> shangpinIds = new ArrayList<Integer>();
		List<String> shangpinNames = new ArrayList<String>();
		List<Double> spjinZongshus = new ArrayList<Double>();
		List<Shangpin> shangpins = new ArrayList<Shangpin>();
		List<Spjin> spjins = new ArrayList<Spjin>();
		Double zongshuspjin = 0.0;
		Spjin spjin = new Spjin();
		if (StringUtil.isNotEmpty(userId)) {
			spjin.setUserId(Integer.parseInt(userId));
		}
		Shangpin shangpin = new Shangpin();
		if (StringUtil.isNotEmpty(sptypeId)) {
			shangpin.setSptypeId(Integer.parseInt(sptypeId));
		}
		try {
			shangpins = shangpinService.queryShangpins(shangpin, null, null, null, null, null);
			for(int i=0;i<shangpins.size();i++){
				shangpinIds.add(shangpins.get(i).getShangpinId());
				shangpinNames.add(shangpins.get(i).getShangpinName());
			}
			for(int i=0;i<shangpinIds.size();i++){
				Double spjinZongshu = 0.0;
				spjin.setShangpinId(shangpinIds.get(i));
				spjins = spjinService.querySpjins(spjin, null,sdate,edate);
				for(int j=0;j<spjins.size();j++){
					spjinZongshu = spjinZongshu + spjins.get(j).getSpjinZe();
				}
				zongshuspjin = zongshuspjin + spjinZongshu;
				spjinZongshus.add(spjinZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("shangpinNames", shangpinNames);
			session.setAttribute("spjinZongshus", spjinZongshus);
			session.setAttribute("zongshuspjin", zongshuspjin);
			response.sendRedirect("admin/spjintongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void spjinTongjiUser() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		List<Integer> userIds = new ArrayList<Integer>();
		List<String> userNames = new ArrayList<String>();
		List<Integer> spjinZongshus = new ArrayList<Integer>();
		List<User> users = new ArrayList<User>();
		List<Spjin> spjins = new ArrayList<Spjin>();
		Integer zongshu = 0;
		try {
			users = userService.queryUsers(null, null, null, null);
			for(int i=0;i<users.size();i++){
				userIds.add(users.get(i).getUserId());
				userNames.add(users.get(i).getUserName());
			}
			for(int i=0;i<userIds.size();i++){
				Integer spjinZongshu = 0;
				Spjin spjin = new Spjin();
				spjin.setUserId(userIds.get(i));
				spjins = spjinService.querySpjins(spjin, null,sdate,edate);
				for(int j=0;j<spjins.size();j++){
					spjinZongshu = spjinZongshu + spjins.size();
				}
				zongshu = zongshu + spjinZongshu;
				spjinZongshus.add(spjinZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("userNames", userNames);
			session.setAttribute("spjinZongshus", spjinZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/spjintongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
