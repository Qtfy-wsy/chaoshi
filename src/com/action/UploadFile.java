package com.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class UploadFile {

	public static File Upload(File uploadFile, String uploadFileFileName,String targetDirectory)throws Exception {
		File target = new File(targetDirectory, uploadFileFileName);
		if (target.exists()) {
			target.delete();
		}
		FileUtils.copyFile(uploadFile, target);
		return target;
	}
}