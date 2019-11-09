package com.demo.utils;

import dto.ImportExcelParamDto;
import dto.ImportExcelResultDto;
import dto.ParamDto;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {
    public ImportExcelResultDto imp(ImportExcelParamDto paramDto){
        ImportExcelResultDto result=new ImportExcelResultDto();
        result.setTitle(paramDto.getTitle());
        List<Student> studentList=new ArrayList<Student>();
      String fileName=null;
      Workbook workbook=null;
        try {
            fileName=FileUtil.save(paramDto.getExcel(),FileUtil.path);
            if (fileName!=null) {
                 workbook = WorkbookFactory.create(paramDto.getExcel().getInputStream());
                Sheet sheet = workbook.getSheetAt(0);
                int rowNum = sheet.getLastRowNum();
                for (int i = 0; i <= rowNum; i++) {
                    Row row = sheet.getRow(i);
                    Student student=new Student();
                    student.setName(row.getCell(0).getStringCellValue());
                    student.setAge((int)row.getCell(1).getNumericCellValue());
                    student.setTime(row.getCell(2).getDateCellValue());
                    studentList.add(student);
                }
                result.setStudentList(studentList);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("保存文件失败了");
        }finally {
            if (workbook!=null){
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }
    public Workbook export(Boolean isxlsx) {
        Workbook workbook;
         if (isxlsx){
         workbook=new XSSFWorkbook();
       }else{
             workbook=new HSSFWorkbook();
         }
        Sheet sheet = workbook.createSheet();
         List<List<String>> content=this.getcontent();
        for (int i = 0; i < content.size(); i++) {
            Row row = sheet.createRow(i);
            for(int j=0;j<content.get(i).size();j++){
                 row.createCell(j).setCellValue(content.get(i).get(j));
             }
        }
        return workbook;
    }
    private List<List<String>> getcontent(){
        List<List<String>>  result=new ArrayList<>();
        List<String> row =new ArrayList<>();
        result.add(row);
        row.add("序号");row.add("姓名");row.add("年龄");row.add("时间");
        row=new ArrayList<>();
        result.add(row);
        row.add("1");row.add("甲");row.add("21");row.add("2001-5-23");
        row=new ArrayList<>();
        result.add(row);
        row.add("2");row.add("乙");row.add("15");row.add("2015-8-21");
        return result;
    }

    public static void main(String[] args) {
     new ExcelService().export(false);
    }
}
