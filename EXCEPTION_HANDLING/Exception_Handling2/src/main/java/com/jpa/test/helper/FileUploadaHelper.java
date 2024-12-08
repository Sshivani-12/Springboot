package com.jpa.test.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadaHelper {
	public final String upload_Dir = "C:\\Users\\hp\\Documents" + "\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\"
	+ "BootRestBook\\src\\main\\resources\\static\\images";

	 
	public static boolean uploadFile(MultipartFile multipartfile) {
		boolean f = false;
		try {
			InputStream is = multipartfile.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);

			// write
			FileOutputStream fos = FileOutputStream(upload_Dir + File.separator + multipartfile.getOriginalFilename());
			fos.write(data);
			fos.close();
			fos.flush();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	//or 
	
	private FileOutputStream FileOutputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
