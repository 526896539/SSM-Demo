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
	                    //�õ��������ͬʱ�������ϴ����ļ�  
	                    FileOutputStream os = new FileOutputStream("E:/static/imgUp" + new Date().getTime() + files[i].getOriginalFilename());  
	                    //�õ��ϴ��ļ���������  
	                    FileInputStream in = (FileInputStream) files[i].getInputStream();  
	                      
	                    //��д�ֽڵķ�ʽд�ļ�  
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
	                    System.out.println("�ϴ�����");  
	                }  
	        }  
	        }  
	        return "index";  
	    }  
	      
	      
	    @RequestMapping("/upload2"  )  
	    public String upload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
	        //����һ��ͨ�õĶಿ�ֽ�����  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        //�ж� request �Ƿ����ļ��ϴ�,���ಿ������  
	        if(multipartResolver.isMultipart(request)){  
	            //ת���ɶಿ��request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //ȡ��request�е������ļ���  
	            Iterator<String> iter = multiRequest.getFileNames();  
	            while(iter.hasNext()){  
	                //��¼�ϴ�������ʼʱ��ʱ�䣬���������ϴ�ʱ��  
	                int pre = (int) System.currentTimeMillis();  
	                //ȡ���ϴ��ļ�  
	                MultipartFile file = multiRequest.getFile(iter.next());  
	                if(file != null){  
	                    //ȡ�õ�ǰ�ϴ��ļ����ļ�����  
	                    String myFileName = file.getOriginalFilename();  
	                    //������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������  
	                    if(myFileName.trim() !=""){  
	                        System.out.println(myFileName);  
	                        //�������ϴ�����ļ���  
	                        String fileName = "demoUpload" + file.getOriginalFilename();  
	                        //�����ϴ�·��  
	                        String   ssString = request.getSession().getServletContext().getRealPath("/")+ "upload/";
	                        String path = ssString + fileName;  
	                        File localFile = new File(path);  
	                        file.transferTo(localFile);  
	                    }  
	                }  
	                //��¼�ϴ����ļ����ʱ��  
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

	

