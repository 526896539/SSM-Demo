package cn.supertimor.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Controller
@RequestMapping("/mvc")
public class fileUpload {
	
	@RequestMapping("/fileUp")
	public String fileUp(){
		return "fileUpload";
	}
	
	 @RequestMapping("/upload")  
	    public String addUser(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request){  
	          
	        for(int i = 0;i<files.length;i++){  
	            System.out.println("fileName---------->" + files[i].getOriginalFilename());  
	            String path=System.getProperty("user.dir");
	            System.out.println("12312312123---------->" + path);  
	            if(!files[i].isEmpty()){  
	                int pre = (int) System.currentTimeMillis();  
	                try {  
	                    //拿到输出流，同时重命名上传的文件  
	                    FileOutputStream os = new FileOutputStream("E:/static/imgUp" + new Date().getTime() + files[i].getOriginalFilename());  
	                    //拿到上传文件的输入流  
	                    FileInputStream in = (FileInputStream) files[i].getInputStream();  
	                      
	                    //以写字节的方式写文件  
	                    int b = 0;  
	                    while((b=in.read()) != -1){  
	                        os.write(b);  
	                    }  
	                    os.flush();  
	                    os.close();  
	                    in.close();  
	                    int finaltime = (int) System.currentTimeMillis();  
	                    System.out.println(finaltime - pre);  
	                      
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                    System.out.println("上传出错");  
	                }  
	        }  
	        }  
	        return "index";  
	    }  
	      
	      
	    @RequestMapping("/upload2"  )  
	    public String upload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
	        //创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){  
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //取得request中的所有文件名  
	            Iterator<String> iter = multiRequest.getFileNames();  
	            while(iter.hasNext()){  
	                //记录上传过程起始时的时间，用来计算上传时间  
	                int pre = (int) System.currentTimeMillis();  
	                //取得上传文件  
	                MultipartFile file = multiRequest.getFile(iter.next());  
	                if(file != null){  
	                    //取得当前上传文件的文件名称  
	                    String myFileName = file.getOriginalFilename();  
	                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
	                    if(myFileName.trim() !=""){  
	                        System.out.println(myFileName);  
	                        //重命名上传后的文件名  
	                        String fileName = "demoUpload" + file.getOriginalFilename();  
	                        //定义上传路径  
	                        String   ssString = request.getSession().getServletContext().getRealPath("/")+ "upload/";
	                        String path = ssString + fileName;  
	                        File localFile = new File(path);  
	                        file.transferTo(localFile);  
	                    }  
	                }  
	                //记录上传该文件后的时间  
	                int finaltime = (int) System.currentTimeMillis();  
	                System.out.println(finaltime - pre);  
	            }  
	              
	        }  
	        return "index";  
	    }  
	      
	    @RequestMapping(value="/uploadFile",method=RequestMethod.POST)
		public String upload(HttpServletRequest req) throws Exception {
			MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
			MultipartFile file = mreq.getFile("file");
			String fileName = file.getOriginalFilename();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String   ssString = req.getSession().getServletContext().getRealPath("/")+ "upload/";
			System.out.println(ssString+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/")+ "upload/"
					+ sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'))); fos.write(file.getBytes());
					fos.flush(); fos.close(); return "index";
				}
	}  

	

