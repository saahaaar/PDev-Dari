package tn.esprit.spring.pi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	//http://localhost:8081/SpringMVC/Servlet/fileuploads
  public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
  @RequestMapping("/fileuploads")
  public String UploadPage(Model model) {
	  return "uploadview";
  }
  //http://localhost:8081/SpringMVC/Servlet/upload
  @RequestMapping("/upload")
  public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
	  StringBuilder fileNames = new StringBuilder();
	  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
	  return "uploadstatusview";
  }
  
  
}