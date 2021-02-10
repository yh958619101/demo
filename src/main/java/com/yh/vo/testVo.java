package com.yh.vo;

import com.yh.anotation.ExcelColum;

public class testVo {
    @ExcelColum(columName = "姓名", columWight = 30, cellPosition = 0)
    private String name;
    @ExcelColum(columName = "年龄", columWight = 30, cellPosition = 1)
    private String age;
}
