package scau.huangyk.homeworkmanagementsystem.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import scau.huangyk.homeworkmanagementsystem.dto.ExcelData;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExcelUtil {

    public static void exportExcel(HttpServletResponse response, String fileName,ExcelData data){
      log.info("导出解析开始，文件名:{}",fileName);
      try{
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("sheet");
            setTitle(workbook,sheet,data.getTitles());
            setData(sheet,data.getRows());
            setBrowser(response,workbook,fileName);
            log.info("导出解析成功！");
      }catch (Exception e){
          log.error("导出解析失败:{}",e.getMessage());
      }
    }

    private static void setTitle(HSSFWorkbook workbook, HSSFSheet sheet, List<String> titles){
        try{
            HSSFRow row=sheet.createRow(0);
            for(int i=0;i<titles.size();i++){
                sheet.setColumnWidth(i,15*256);
            }

            //设置为居中加粗,格式化时间格式
            HSSFCellStyle style = workbook.createCellStyle();
            HSSFFont font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

            HSSFCell cell;
            for(int i=0;i<titles.size();i++){
                cell=row.createCell(i);
                cell.setCellValue(titles.get(i));
                cell.setCellStyle(style);
            }
        }catch (Exception e){
            log.error("导出时设置表头失败:{}",e.getMessage());
        }
    }

    private static void setData(HSSFSheet sheet,List<List<String>> data){
        try{
            int rowNum=1;
            for(int i=0;i<data.size();i++){
                HSSFRow row=sheet.createRow(rowNum++);
                for(int j=0;j<data.get(i).size();j++){
                    row.createCell(j).setCellValue(data.get(i).get(j));
                }
            }
            log.info("表格赋值成功");
        }catch (Exception e){
            log.error("表格赋值失败:{}",e.getMessage());
        }
    }

    private static void setBrowser(HttpServletResponse response,HSSFWorkbook workbook,String fileName){
        try{
            response.reset();

            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            OutputStream os=new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            workbook.write(os);
            os.flush();
            os.close();
            log.info("设置浏览器下载成功");
        }catch (Exception e){
            log.error("设置浏览器下载失败:{}",e.getMessage());
        }
    }

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    public static List<Map<String,Object>> importExcel(String filePath, List<String> titles){
        log.info("导入解析开始，文件名:{}",filePath);
        try{
            List<Map<String,Object>> list=new ArrayList<>();
            Workbook workbook=null;
            if (isExcel2007(filePath)) {
                workbook = new XSSFWorkbook(new FileInputStream(filePath));
            } else if(isExcel2003(filePath)){
                workbook = new HSSFWorkbook(new FileInputStream(filePath));
            }
            Sheet sheet=workbook.getSheetAt(0);
            int rows=sheet.getPhysicalNumberOfRows();
            for(int i=1;i<rows;i++){
                Row row=sheet.getRow(i);
                Map<String,Object> map=new HashMap<>();
                for(int j=0;j<titles.size();j++){
                    Cell cell=row.getCell(j);
                    if(cell.getCellType()== CellType.NUMERIC){
                        map.put(titles.get(j),cell.getNumericCellValue());
                    }else if(cell.getCellType()== CellType.STRING){
                        map.put(titles.get(j),cell.getStringCellValue());
                    }else if(cell.getCellType()==CellType.BLANK){
                        map.put(titles.get(i),"");
                    }

                }
                list.add(map);
            }
            log.info("导入文件解析成功");
            return list;

        }catch (Exception e){
            log.error("导入文件解析失败:{}",e.getMessage());
        }
        return null;
    }

    public static void main(String[] args){
        String path="C:\\Users\\Pennsy\\Desktop\\1.xlsx";
        List<String> list=new ArrayList(){{
            add("account");add("userName");
        }};
        List<Map<String,Object>> list1=importExcel(path,list);
        for(Map<String,Object> map:list1){
            System.out.println(map.get("account")+":"+map.get("userName"));
        }
    }


}
