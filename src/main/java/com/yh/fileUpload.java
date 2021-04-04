package com.yh;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class fileUpload {
    SimpleDateFormat sdf= new  SimpleDateFormat("/yyyy/MM/dd/");
    @RequestMapping("/fileupload")
    public Map<String,Object> fileupload (MultipartFile file, HttpServletRequest request)  {
    Map<String,Object>  map=new HashMap<>();
        String filename = file.getOriginalFilename();
        if (!filename.endsWith(".doc")){
            map.put("status","error");
            map.put("msg","文件类型不对");
            return  map;
        }
        String format = sdf.format(new Date());
        File file1 = new File("");
        String RealPath = null;
        try {
            RealPath = file1.getCanonicalPath()+format;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //String RealPath = request.getServletContext().getRealPath("/") + format;
        File folder = new File(RealPath);
        if (!folder.exists()){
            folder.mkdir();
        }
        String string = UUID.randomUUID().toString()+".doc";
          //  file.transferTo(new File(folder,string));
            //String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServletPath() + format + string;
            File url = new File(string);
            map.put("status","success");
            map.put("url",url);
        return  map;
    }
}
