package com.demo.utils;

import dto.ImportWordParamDto;
import dto.ImportWordResultDto;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WordService {
    public ImportWordResultDto imp(ImportWordParamDto dto ) {
        ImportWordResultDto result=new ImportWordResultDto();
        result.setTitle(dto.getTitle());
        HWPFDocument doc=null;
        try {
            doc=new HWPFDocument(dto.getWord().getInputStream());
            result.setContent(doc.getDocumentText().replace("\r","<br/>"));
        }catch (OfficeXmlFileException e){
            System.out.println("这可能是一个07版的word");
        }
        catch (IOException e) {
          result.setMsg("这可能不是一个Word");
          return result;
        }finally {
            if (doc!=null){
                try {
                    doc.close();
                    return  result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        XWPFDocument docx=null;
        try {
             docx= new XWPFDocument(dto.getWord().getInputStream());
           List <XWPFParagraph> paragraphlist = docx.getParagraphs();
           StringBuilder content=new StringBuilder();
           for (int i=0;i<paragraphlist.size();i++){
               if (i!=0){
                   content.append("<br/>");
               }
               content.append(paragraphlist.get(i));
           }
           result.setContent(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (docx!=null){
                try {
                    docx.close();
                    return  result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }

    public HWPFDocument export03(Map<String,String>  replacecontent ) {

    HWPFDocument doc=null;
        try {
            doc=new HWPFDocument(new FileInputStream(""));
            Range range = doc.getRange();
            for (Map.Entry<String,String> entry:replacecontent.entrySet()){
                range.replaceText(entry.getKey(),entry.getValue());
            }

        } catch (Exception e) {
            return  null;
        }
        return  doc ;
    }
    public XWPFDocument export07(Map<String,String>  replacecontent ) {

        XWPFDocument docx=null;
        try {
            docx=new XWPFDocument(new FileInputStream(""));
            List<XWPFParagraph> paragraphsList=docx.getParagraphs();
            for (XWPFParagraph paragraph:paragraphsList){
            List<XWPFRun> runs=paragraph.getRuns();
            for (XWPFRun run:runs){
                String str=run.getText(run.getTextPosition());
                for (Map.Entry<String,String> entry:replacecontent.entrySet()){
                    str=str.replace(entry.getKey(),entry.getValue());
                }
                run.setText(str,0);
               }
            }
        } catch (Exception e) {
            return  null;
        }
        return  docx ;
    }
}
