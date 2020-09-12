package com.yh.until;
import com.yh.anotation.ExcelColum;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExcelUtil <T>{

	public static String getCellValue(Cell cell) {
		DecimalFormat df = new DecimalFormat("#");
		String cellValue = null;
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell
						.getNumericCellValue()));
				break;
			}
			cellValue = df.format(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = null;
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			cellValue = String.valueOf(cell.getErrorCellValue());
			break;
		}
		if (cellValue != null && cellValue.trim().length() <= 0) {
			cellValue = null;
		}
		return cellValue;
	}

	
	public static boolean isExcel2003(String fileName) {

		return fileName.matches("^.+\\.(?i)(xls)$");

	}

	
	public static boolean isExcel2007(String fileName) {

		return fileName.matches("^.+\\.(?i)(xlsx)$");

	}

	
	/** 检查文件名是否为空或者是否是Excel格式的文件 */
	public static boolean validateExcel(String fileName) {
		
		if (!(isExcel2003(fileName) || isExcel2007(fileName))) {
			return false;
		}

		return true;

	}

	public Workbook export(Workbook wb, List<T> list, Class<T> type, String sheetName) throws Exception{
		Map<String, Object> map = createSheet(wb, type, sheetName);
		createRowData(list, (Sheet)map.get("sheet"), (TreeMap<Integer,CellVo>)map.get("cellVoTreeMap"));
		return wb;
	}

	public Map<String,Object> createSheet(Workbook wb, Class<T> type , String sheetName){
		Map<String, Object> map = new HashMap<>();
		Sheet sheet = wb.createSheet(sheetName);
		CellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//1.生成字体对象
		Font font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("黑体");
		font.setColor(HSSFColor.BLACK.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗

		style.setFont(font); //调用字体样式对象
		style.setWrapText(true);

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		Field[] fields = type.getDeclaredFields();
		//列标题
		TreeMap<Integer,CellVo> cellVoTreeMap =new TreeMap<>();
		for(Field f:fields){
			//判断属性是否有注解
			if(f.isAnnotationPresent(ExcelColum.class)){
				//获取 Annotation 对象
				ExcelColum excelColum=f.getAnnotation(ExcelColum.class);
				CellVo cellVo=new CellVo();
				cellVo.setCellName(excelColum.columName());
				cellVo.setField(f);
				cellVo.setCellWidht(excelColum.columWight());
				cellVo.setCellPosition(excelColum.cellPosition());
				cellVoTreeMap.put(cellVo.getCellPosition(),cellVo);
			}
		}
		//构造标题行
		//创建1行
		Row row0= sheet.createRow((int) 0);
		row0.setHeight((short) 500);
		int cell0Index=0;
		for(CellVo vo:cellVoTreeMap.values()){
			//创建每行的列
			Cell cell0 = row0.createCell(cell0Index);
			//给列赋值
			cell0.setCellValue(vo.getCellName());
			//设置列宽
			sheet.setColumnWidth(cell0Index, vo.getCellWidht() * 300);
			//给列格式
			cell0.setCellStyle(style);
			cell0Index++;
		}
		map.put("sheet",sheet);
		map.put("cellVoTreeMap",cellVoTreeMap);
		return map;
	}

	private void createRowData(List<T> list, Sheet sheet, TreeMap<Integer, CellVo> cellVoTreeMap) {
		//打印数据行
		BeanWrapperImpl beanWrapper=new BeanWrapperImpl();
		for(int rowIndex=1;rowIndex<=list.size();rowIndex++){
			//创建行
			Row row = sheet.createRow((int) rowIndex);
			int  cellIndex=0;
			for(CellVo cellVo:cellVoTreeMap.values()){
				//创建每行的列
				Cell cell0 = row.createCell(cellIndex);
				beanWrapper.setWrappedInstance(list.get(rowIndex-1));
				Object propertyValue = beanWrapper.getPropertyValue(cellVo.getField().getName());
				cell0.setCellValue( propertyValue==null?"":propertyValue.toString());
				cellIndex++;
			}
		}
	}

	/**
	 * 单独获取数据 使用
	 * @param beanWrapper
	 * @param cell
	 * @return
	 */
	public String getCellFieldValue(BeanWrapperImpl beanWrapper,Object cell){
		CellVo cellVo = (CellVo) cell;
		Object propertyValue = beanWrapper.getPropertyValue(cellVo.getField().getName());
		return propertyValue==null?"":propertyValue.toString();
	}
}

class CellVo{
	String cellName;
	Field field;
	int cellWidht;
	int cellPosition;
	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public int getCellWidht() {
		return cellWidht;
	}

	public void setCellWidht(int cellWidht) {
		this.cellWidht = cellWidht;
	}

	public int getCellPosition() {
		return cellPosition;
	}

	public void setCellPosition(int cellPosition) {
		this.cellPosition = cellPosition;
	}
}
