package com.yh;

import com.yh.entity.User;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class export {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        int j = 100000;
        for (int i = 0; i < j; i++) {
            userList.add(new User("yh", 19));
        }
        String name = "测试-" + System.currentTimeMillis() + ".xls";
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("stud");
        // 声明一行
        HSSFRow row = sheet.createRow(0);
        row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
        int index = 0;//记录额外创建的sheet数量
        for (int i = 0; i < userList.size(); i++) {
            if ((i + 1) % 65535 == 0) {
                sheet = book.createSheet("stud" + index);
                row = sheet.createRow(0);
                row.createCell(0).setCellValue("姓名");
                row.createCell(1).setCellValue("年龄");
                index++;
            }
            row = sheet.createRow((i + 1) - (index * 65535));
            // 第四步，创建单元格，并设置值
            row.createCell( 0).setCellValue(userList.get(i).getName());
            row.createCell(  1).setCellValue(userList.get(i).getAge());
        }
        // 第六步，将文件存到指定位置
        String fileName = "";
        try {
            fileName = name + ".xls";
            name = "导出.xls";
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fout = new FileOutputStream(fileName);
            book.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
