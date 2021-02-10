package com.yh;

import com.yh.entity.User;
import com.yh.until.ExcelUtil;
import com.yh.until.MailUtil;
import com.yh.vo.testVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayhello() {
        System.out.println(0000);
        return "hello";
    }

    public static void main(String[] args) throws Exception {
        //生成随机数
        String s = UUID.randomUUID().toString();
      //  long time  = new Date().getTime();
        long time  = System.currentTimeMillis();
        String sheetName = "测试-" + time+ ".xls";
        File file = new File(sheetName);
        Workbook workbook = new HSSFWorkbook();
        ExcelUtil excelUtil = new ExcelUtil();
        List<User> userList = new ArrayList<>();
        int j=65536;
        for (int i=0;i<j;i++){
            userList.add(new User("yh", 19));
        }
        excelUtil.export(workbook, userList, testVo.class, sheetName);
        FileOutputStream out = new FileOutputStream(sheetName);
        workbook.write(out);
        out.flush();
        if (out != null) {
            out.close();
        }


        String to = "958619101@qq.com";
        boolean send = MailUtil.send(to, "测试", sheetName);
        System.out.println(send);
    }

}
