package scau.huangyk.homeworkmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.util.UUIDUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件控制器
 * @author huangyk
 * @since 2019-03-05
 */
@Controller
@RequestMapping("/file")
@Slf4j
public class FileController {

//    private final String HOMEWORK="homework";
//    private final String RESOURCE="resource";
//    private final String COURSE="course";

    private final String UPLOAD_ROOT="upload";

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResultModel upload(@RequestParam("file") MultipartFile file,String typeName){
        if(file.isEmpty()){
            return new ResultModel(Constants.FAIL,"文件为空，上传失败");
        }
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        String fileName=file.getOriginalFilename();
        log.debug("上传文件名为：{},文件大小为：{}字节",file,file.getSize());
        String prefix=fileName.substring(0,fileName.lastIndexOf("."));
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        fileName="/"+UPLOAD_ROOT+"/"+prefix+System.currentTimeMillis()+suffix;
        //String path=Paths.get(UPLOAD_ROOT,dateFormat.format(new Date()),fileName).toString();
        String path="C:/Users/Pennsy/Desktop/homework-management-system(2)/homework-management-system(2)/src/main/resources/static"+fileName;
        File temp=new File(path);
        if(!temp.getParentFile().exists()){
            temp.getParentFile().mkdirs();
        }
        try {
            file.transferTo(temp);
            //Files.copy(file.getInputStream(),Paths.get(UPLOAD_ROOT,dateFormat.format(new Date()),fileName));
            log.info("生成文件：{}",path);
            String targetPath=fileName;
            Map<String,String> data=new HashMap(){{
                put("src",targetPath);
            }};
            return new ResultModel(Constants.DEFAULT,"上传成功",data);
        } catch (IOException e) {
           log.error("文件写入失败：{}",e.getMessage());
        }
        return new ResultModel(Constants.FAIL,"上传失败");
    }

//    @RequestMapping(value = "/download1")
//    public ResultModel download(String srcPath, HttpServletResponse response) throws UnsupportedEncodingException {
//        File file=new File(srcPath);
//        if(file.exists()){
//            response.setContentType("text/html; charset = UTF-8");
//            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(file.getName(),"UTF-8"));
//            byte[] buffer=new byte[1024];
//            FileInputStream fis=null;
//            BufferedInputStream bis=null;
//            OutputStream os=null;
//            try{
//                os=response.getOutputStream();
//                fis=new FileInputStream(file);
//                bis=new BufferedInputStream(fis);
//                log.debug("开始下载文件：{}",file.getAbsolutePath());
//                int index;
//                while((index=bis.read(buffer))>0){
//                    os.write(buffer,0,index);
//                }
//                os.flush();
//                log.debug("文件：{}，下载完毕",file.getAbsolutePath());
//            }catch (Exception e){
//                log.error(e.getMessage());
//            }
//            try {
//                bis.close();
//                fis.close();
//            }catch (IOException e){
//                log.error(e.getMessage());
//            }
//        }
//        return null;
//    }

    @RequestMapping(value = "/download")
    public ResponseEntity<InputStreamResource> download(String srcPath) throws IOException {
        FileSystemResource file = new FileSystemResource(srcPath);
        if(file.exists()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", String.format("attachment; filename=", file.getFilename()));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.contentLength())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(file.getInputStream()));
        }
        return null;

    }

    @RequestMapping(value="/export")
    public ResultModel export(){
        return null;
    }

}
