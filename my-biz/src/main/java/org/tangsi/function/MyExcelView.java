package org.tangsi.function;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * 
 * @Project my-biz
 * @Description:excel视图
 * @Company youku
 * @Create 2016年4月1日下午4:23:49
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */
public class MyExcelView extends AbstractExcelView
{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		
		 // 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开  
        response.setContentType("APPLICATION/OCTET-STREAM");  
        response.setHeader("Content-Disposition", "attachment; filename="  
                + URLEncoder.encode("excel日程表单.xls", "UTF-8"));
			
		HSSFSheet sheet = workbook.createSheet("ts的日程");
		sheet.setDefaultColumnWidth(12);

		HSSFCell hssfCell = getCell(sheet, 0, 0);
		setText(hssfCell, "测试生成excel");
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		hssfCell = getCell(sheet, 1, 0);
		hssfCell.setCellValue("日期：2016-04-01");
		getCell(sheet, 2, 0).setCellValue("开发1");
		getCell(sheet, 3, 0).setCellValue("开发2");

		HSSFRow hssfRow = sheet.createRow(3);
		for (int i = 0; i < 10; i++)
		{
			hssfRow.createCell(i).setCellValue(i * 10);
		}
	}

}
