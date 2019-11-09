package com.demo.datapro;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExcelService {
    public void imp(FileItem fileItem,String userName) throws Exception {
        Workbook workbook=null;

            workbook= WorkbookFactory.create(fileItem.getInputStream());
            Sheet sheet=workbook.getSheetAt(0);
            int rowNum=sheet.getLastRowNum();
            for (int i = 1; i <= rowNum; i++) {
                Row row=sheet.getRow(i);
                Course course=new Course(row.getCell(0).toString(),row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),row.getCell(4).toString(),
                        userName);
               CourseDaoImpl.getCoursesTable().add(course);
               workbook.close();
            }
        }

    public Workbook export() {
        Workbook workbook=new XSSFWorkbook();
        List<Course> list=CourseDaoImpl.getCoursesTable();
        Sheet sheet=workbook.createSheet("我的课程");
         Row row=sheet.createRow(0);
        row.createCell(0).setCellValue("courseId");
        row.createCell(1).setCellValue("courseName");
        row.createCell(2).setCellValue("coursePath");
        row.createCell(3).setCellValue("courseDes");
        row.createCell(4).setCellValue("courseDuration");
        row.createCell(5).setCellValue("courseOperator");
        for (int i=1;i<=list.size();i++){
             row=sheet.createRow(i);
                row.createCell(0).setCellValue(list.get(i-1).getCourseId());
                row.createCell(1).setCellValue(list.get(i-1).getCourseName());
                row.createCell(2).setCellValue(list.get(i-1).getCoursePath());
                row.createCell(3).setCellValue(list.get(i-1).getCourseDes());
                row.createCell(4).setCellValue(list.get(i-1).getCourseDuration());
                row.createCell(5).setCellValue(list.get(i-1).getCourseOperator());
        }

        return  workbook;

    }
}
