package test;

import java.io.File;



import log.Log;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file){
		try{
			String fileName = new String(file.getOriginalFilename().getBytes(),"utf-8");
			Log.info(fileName);
			FileUtils.writeByteArrayToFile(new File("E:/upload/"+file.getOriginalFilename()), file.getBytes());
			return "OK";
		}catch(Exception e){
			e.printStackTrace();
			return "wrong";
		}
	}
}
