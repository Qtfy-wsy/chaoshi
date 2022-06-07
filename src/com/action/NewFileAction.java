package com.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("newFileAction")
public class NewFileAction extends ActionSupport {
	private File file;// 文件
	private String fileFileName;// 文件名称
	private String fileContentType; // 文件类型
	private String filename;
	private InputStream inputStream;

	public String newFile() {
		File dir = new File(ServletActionContext.getServletContext()
				.getRealPath("files"));
		// 判断文件是否上传，如果上传的话将会创建该目录
		if (!dir.exists()) {
			dir.mkdir(); // 创建该目录
		}
		System.out.println(file);
		System.out.println(fileFileName);
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(dir + "\\" + fileFileName);
			byte[] b = new byte[1024 * 1024];// 每次写入的大小
			int i = 0;
			while ((i = in.read(b)) > 0) {
				out.write(b, 0, i);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return SUCCESS;
	}

	public String downFile() {
		System.out.println(filename);
		inputStream = ServletActionContext.getServletContext()
				.getResourceAsStream("/file/" + filename);
		System.out.println(inputStream);
		return SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}