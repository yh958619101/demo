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
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello")
public String  sayhello(){
        System.out.println(0000);
        return "hello";
}

    public static void main(String[] args) throws Exception {

        String sheetName="测试"+".xls";
        File file=new File(sheetName);
        Workbook workbook=new HSSFWorkbook() ;
        ExcelUtil excelUtil=new ExcelUtil();
        List<User> userList=  new ArrayList<>();
        userList.add(new User("yh",19));
        userList.add(new User("yh",19));
        userList.add(new User("yh",19));
        userList.add(new User("yh",19));
        excelUtil.export(workbook,userList, testVo.class,sheetName);

        FileOutputStream out=new FileOutputStream(sheetName);
        workbook.write(out);
        out.flush();
        if (out!=null){
            out.close();
        }
        String to="958619101@qq.com";
        boolean send = MailUtil.send(to, "测试", sheetName);
        System.out.println(send);
    }

}
