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

import com.model.Spchu;
import com.service.SpchuService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Shangpin;
import com.service.ShangpinService;
import com.model.Sptype;
import com.service.SptypeService;
import com.model.Yonghu;
import com.service.YonghuService;
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

@Component("spchuAction")
@Scope("prototype")
public class SpchuAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private SpchuService spchuService;

	private Spchu spchu;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Spchu> spchus;

	public Spchu getSpchu() {
		return spchu;
	}

	public void setSpchu(Spchu spchu) {
		this.spchu = spchu;
	}

	public SpchuService getSpchuService() {
		return spchuService;
	}

	@Resource
	public void setSpchuService(SpchuService spchuService) {
		this.spchuService = spchuService;
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
	public void daoruSpchu() throws Exception {
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
				Spchu spchu = new Spchu();
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
					}

					switch (j) {// 通过列数来判断对应插如的字段
					case 1:
						spchu.setSpchuName(cellValue);
						break;
					case 2:
						spchu.setSpchuMark(cellValue);
						break;
					case 3:
						spchu.setSpchuMark1(cellValue);
						break;
					case 4:
						spchu.setSpchuMark2(cellValue);
						break;
					case 5:
						spchu.setSpchuMark3(cellValue);
						break;
					case 6:
						spchu.setSpchuZong(Integer.parseInt(cellValue));
						break;
					case 7:
						spchu.setSpchuJine(Double.parseDouble(cellValue));
						break;
					case 8:
						spchu.setSpchuType(Integer.parseInt(cellValue));
						break;
					case 9:
						spchu.setSpchuType1(Integer.parseInt(cellValue));
						break;
					case 10:
						spchu.setShangpinId(Integer.parseInt(cellValue));
						Shangpin shangpin = new Shangpin();
						shangpin = shangpinService.getShangpin(Integer.parseInt(cellValue));
						spchu.setShangpinName(shangpin.getShangpinName());
						spchu.setSptypeId(shangpin.getSptypeId());
						spchu.setSptypeName(shangpin.getSptypeName());
						break;
					case 11:
						spchu.setYonghuId(Integer.parseInt(cellValue));
						Yonghu yonghu = new Yonghu();
						yonghu = yonghuService.getYonghu(Integer.parseInt(cellValue));
						spchu.setYonghuName(yonghu.getYonghuName());
						spchu.setYhbumenId(yonghu.getYhbumenId());
						spchu.setYhbumenName(yonghu.getYhbumenName());
						spchu.setYhroleId(yonghu.getYhroleId());
						spchu.setYhroleName(yonghu.getYhroleName());
						break;
					case 12:
						spchu.setUserId(Integer.parseInt(cellValue));
						User user = new User();
						user = userService.getUser(Integer.parseInt(cellValue));
						spchu.setUserName(user.getUserName());
						spchu.setBumenId(user.getBumenId());
						spchu.setBumenName(user.getBumenName());
						spchu.setRoleId(user.getRoleId());
						spchu.setRoleName(user.getRoleName());
						break;
					}
				}
				spchu.setSpchuZe(spchu.getSpchuJine()*spchu.getSpchuZong());
				spchu.setSpchuType(2);
				spchuService.save(spchu);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void daochuSpchu() {

		String delIds = getParam("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("spchus记录");
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
		headCell.setCellValue("yonghus");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(14);
		headCell.setCellValue("users");
		headCell.setCellStyle(cellStyle);

		// 添加数据内容
		for (int i = 0; i < str.length; i++) {
			hssfRow = sheet.createRow(i + 1);
			Spchu spchu = spchuService.getSpchu(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(spchu.getSpchuId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(spchu.getSpchuName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(spchu.getSpchuMark());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(spchu.getSpchuMark1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			cell.setCellValue(spchu.getSpchuMark2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(5);
			cell.setCellValue(spchu.getSpchuMark3());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(6);
			cell.setCellValue(spchu.getSpchuDate());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(spchu.getSpchuDate1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(8);
			cell.setCellValue(spchu.getSpchuZong());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(9);
			cell.setCellValue(spchu.getSpchuJine());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(10);
			cell.setCellValue(spchu.getSpchuZe());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(11);
			if (spchu.getSpchuType() == 0) {
				cell.setCellValue("退货");
				cell.setCellStyle(cellStyle);
			} else if(spchu.getSpchuType() == 1){
				cell.setCellValue("通过");
				cell.setCellStyle(cellStyle);
			} else if(spchu.getSpchuType() == 2){
				cell.setCellValue("提交");
				cell.setCellStyle(cellStyle);
			} else{
				cell.setCellValue("其他");
				cell.setCellStyle(cellStyle);
			}

			cell = hssfRow.createCell(12);
			cell.setCellValue(spchu.getShangpinName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(13);
			cell.setCellValue(spchu.getYonghuName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(14);
			cell.setCellValue(spchu.getUserName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/spchu"
					+ strdate + ".xls");
			workbook.write(outputStream);
			outputStream.close();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSpchu() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String spchuName = getParam("spchuName");
			String spchuMark = getParam("spchuMark");
			String spchuMark1 = getParam("spchuMark1");
			String spchuMark2 = getParam("spchuMark2");
			String spchuMark3 = getParam("spchuMark3");
			String spchuDate = getParam("spchuDate");
			String spchuDate1 = getParam("spchuDate1");
			String spchuZong = getParam("spchuZong");
			String spchuJine = getParam("spchuJine");
			String spchuType = getParam("spchuType");
			String spchuType1 = getParam("spchuType1");
			String shangpinId = getParam("shangpinId");
			String yonghuId = getParam("yonghuId");
			String userId = getParam("userId");
			String spchuId = getParam("spchuId");
			Spchu spchu = new Spchu();

			if (StringUtil.isNotEmpty(spchuId)) {
				spchu = spchuService.getSpchu(Integer.parseInt(spchuId));
			}
			if (StringUtil.isNotEmpty(spchuName)) {
				spchu.setSpchuName(spchuName);
			}
			if (StringUtil.isNotEmpty(spchuMark)) {
				spchu.setSpchuMark(spchuMark);
			}
			if (StringUtil.isNotEmpty(spchuMark1)) {
				spchu.setSpchuMark1(spchuMark1);
			}
			if (StringUtil.isNotEmpty(spchuMark2)) {
				spchu.setSpchuMark2(spchuMark2);
			}
			if (StringUtil.isNotEmpty(spchuMark3)) {
				spchu.setSpchuMark3(spchuMark3);
			}
			if (StringUtil.isNotEmpty(spchuDate)) {
				spchu.setSpchuDate(DateUtil.formatString(spchuDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spchuDate1)) {
				spchu.setSpchuDate1(DateUtil.formatString(spchuDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spchuZong)) {
				spchu.setSpchuZong(Integer.parseInt(spchuZong));
			}
			if (StringUtil.isNotEmpty(spchuJine)) {
				spchu.setSpchuJine(Double.parseDouble(spchuJine));
			}
			if (StringUtil.isNotEmpty(spchuType)) {
				spchu.setSpchuType(Integer.parseInt(spchuType));
			}
			if (StringUtil.isNotEmpty(spchuType1)) {
				spchu.setSpchuType1(Integer.parseInt(spchuType1));
			}
			if (StringUtil.isNotEmpty(shangpinId)) {
				spchu.setShangpinId(Integer.parseInt(shangpinId));
				Shangpin shangpin = new Shangpin();
				shangpin = shangpinService.getShangpin(Integer.parseInt(shangpinId));
				spchu.setShangpinName(shangpin.getShangpinName());
				spchu.setSptypeId(shangpin.getSptypeId());
				spchu.setSptypeName(shangpin.getSptypeName());
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				spchu.setYonghuId(Integer.parseInt(yonghuId));
				Yonghu yonghu = new Yonghu();
				yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
				spchu.setYonghuName(yonghu.getYonghuName());
				spchu.setYhbumenId(yonghu.getYhbumenId());
				spchu.setYhbumenName(yonghu.getYhbumenName());
				spchu.setYhroleId(yonghu.getYhroleId());
				spchu.setYhroleName(yonghu.getYhroleName());
			}
			if (StringUtil.isNotEmpty(userId)) {
				spchu.setUserId(Integer.parseInt(userId));
				User user = new User();
				user = userService.getUser(Integer.parseInt(userId));
				spchu.setUserName(user.getUserName());
				spchu.setBumenId(user.getBumenId());
				spchu.setBumenName(user.getBumenName());
				spchu.setRoleId(user.getRoleId());
				spchu.setRoleName(user.getRoleName());
			}
			if (StringUtil.isNotEmpty(spchuId)) {
				spchu.setSpchuZe(spchu.getSpchuJine()*spchu.getSpchuZong());
				spchuService.modifySpchu(spchu);
				if(spchu.getSpchuType()==1){
					Shangpin shangpin = new Shangpin();
					shangpin = shangpinService.getShangpin(spchu.getShangpinId());
					shangpin.setShangpinZong(shangpin.getShangpinZong()+spchu.getSpchuZong());
					shangpin.setShangpinXiao(shangpin.getShangpinXiao()-spchu.getSpchuZe());
					shangpin.setShangpinLirun(shangpin.getShangpinXiao()-shangpin.getShangpinJin());
					shangpinService.modifyShangpin(shangpin);
				}
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date date = new Date();
				spchu.setSpchuDate(date);
				spchu.setSpchuZe(spchu.getSpchuJine()*spchu.getSpchuZong());
				spchu.setSpchuType(0);
				Shangpin shangpin = new Shangpin();
				shangpin = shangpinService.getShangpin(spchu.getShangpinId());
				if(spchu.getSpchuZong()>shangpin.getShangpinZong()){
					result.put("success", "true");
					result.put("errorMsg", "商品库存不够！");
					ResponseUtil.write(response, result);
				}else{
					spchuService.save(spchu);
					shangpin.setShangpinZong(shangpin.getShangpinZong()-spchu.getSpchuZong());
					shangpin.setShangpinXiao(shangpin.getShangpinXiao()+spchu.getSpchuZe());
					shangpin.setShangpinLirun(shangpin.getShangpinXiao()-shangpin.getShangpinJin());
					shangpinService.modifyShangpin(shangpin);
					result.put("success", "true");
					ResponseUtil.write(response, result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanSpchu() throws Exception {
		try {
			String spchuId = getParam("spchuId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Spchu spchu = spchuService.getSpchu(Integer.parseInt(spchuId));
			spchu.setSpchuImg(shangchuandizhi);
			spchu.setSpchuImgName(shangchuanname);
			spchuService.modifySpchu(spchu);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteSpchu() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				spchuService.deleteSpchu(Integer.parseInt(str[i]));
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

	public void getSpchus() throws Exception {

		String page = getParam("page");
		String rows = getParam("rows");
		String spchuName = getParam("spchuName");
		String spchuId = getParam("spchuId");
		String spchuType = getParam("spchuType");
		String spchuType1 = getParam("spchuType1");
		String sptypeId = getParam("sptypeId");
		String yonghuId = getParam("yonghuId");
		String yhroleId = getParam("yhroleId");
		String yhbumenId = getParam("yhbumenId");
		String userId = getParam("userId");
		String bumenId = getParam("bumenId");
		String roleId = getParam("roleId");
		String sdate = getParam("sdate");
		String edate = getParam("edate");
		Spchu spchu = new Spchu();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(spchuName)) {
				spchu.setSpchuName(spchuName);
			}
			if (StringUtil.isNotEmpty(spchuId)) {
				spchu.setSpchuId(Integer.parseInt(spchuId));
			}
			if (StringUtil.isNotEmpty(spchuType)) {
				spchu.setSpchuType(Integer.parseInt(spchuType));
			}
			if (StringUtil.isNotEmpty(spchuType1)) {
				spchu.setSpchuType1(Integer.parseInt(spchuType1));
			}
			if (StringUtil.isNotEmpty(sptypeId)) {
				spchu.setSptypeId(Integer.parseInt(sptypeId));
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				spchu.setYonghuId(Integer.parseInt(yonghuId));
			}
			if (StringUtil.isNotEmpty(yhroleId)) {
				spchu.setYhroleId(Integer.parseInt(yhroleId));
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				spchu.setYhbumenId(Integer.parseInt(yhbumenId));
			}
			if (StringUtil.isNotEmpty(userId)) {
				spchu.setUserId(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				spchu.setBumenId(Integer.parseInt(bumenId));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				spchu.setRoleId(Integer.parseInt(roleId));
			}
			JSONArray jsonArray = JSONArray.fromObject(spchuService.querySpchus(
					spchu, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = spchuService.querySpchus(spchu, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spchuComboList() throws Exception {
		String spchuType = getParam("spchuType");
		Spchu spchu = new Spchu();
		try {
			if (StringUtil.isNotEmpty(spchuType)) {
				spchu.setSpchuType(Integer.parseInt(spchuType));
			}
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("spchuName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(spchuService.querySpchus(spchu,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSpchus(List<Spchu> spchus) {
		this.spchus = spchus;
	}
	
	public void spchuTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String userId=request.getParameter("userId");
		String yonghuId=request.getParameter("yonghuId");
		String sptypeId=request.getParameter("sptypeId");
		List<Integer> shangpinIds = new ArrayList<Integer>();
		List<String> shangpinNames = new ArrayList<String>();
		List<Double> spchuZongshus = new ArrayList<Double>();
		List<Shangpin> shangpins = new ArrayList<Shangpin>();
		List<Spchu> spchus = new ArrayList<Spchu>();
		Double zongshuspchu = 0.0;
		Spchu spchu = new Spchu();
		if (StringUtil.isNotEmpty(yonghuId)) {
			spchu.setYonghuId(Integer.parseInt(yonghuId));
		}
		if (StringUtil.isNotEmpty(userId)) {
			spchu.setUserId(Integer.parseInt(userId));
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
				Double spchuZongshu = 0.0;
				spchu.setShangpinId(shangpinIds.get(i));
				spchu.setSpchuType(0);
				spchus = spchuService.querySpchus(spchu, null,sdate,edate);
				for(int j=0;j<spchus.size();j++){
					spchuZongshu = spchuZongshu + spchus.get(j).getSpchuZe();
				}
				zongshuspchu = zongshuspchu + spchuZongshu;
				spchuZongshus.add(spchuZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("shangpinNames", shangpinNames);
			session.setAttribute("spchuZongshus", spchuZongshus);
			session.setAttribute("zongshuspchu", zongshuspchu);
			response.sendRedirect("admin/spchutongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void spchuTongjiUser() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		List<Integer> userIds = new ArrayList<Integer>();
		List<String> userNames = new ArrayList<String>();
		List<Integer> spchuZongshus = new ArrayList<Integer>();
		List<User> users = new ArrayList<User>();
		List<Spchu> spchus = new ArrayList<Spchu>();
		Integer zongshu = 0;
		try {
			users = userService.queryUsers(null, null, null, null);
			for(int i=0;i<users.size();i++){
				userIds.add(users.get(i).getUserId());
				userNames.add(users.get(i).getUserName());
			}
			for(int i=0;i<userIds.size();i++){
				Integer spchuZongshu = 0;
				Spchu spchu = new Spchu();
				spchu.setUserId(userIds.get(i));
				spchus = spchuService.querySpchus(spchu, null,sdate,edate);
				for(int j=0;j<spchus.size();j++){
					spchuZongshu = spchuZongshu + spchus.size();
				}
				zongshu = zongshu + spchuZongshu;
				spchuZongshus.add(spchuZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("userNames", userNames);
			session.setAttribute("spchuZongshus", spchuZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/spchutongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
