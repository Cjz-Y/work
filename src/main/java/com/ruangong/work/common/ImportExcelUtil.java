package com.ruangong.work.common;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 用于excel的导入
 *
 */
public class ImportExcelUtil {

    final static String PATH = "../execlFile/";


    public static List<Object> readExcel(String filePath, Class clz){
        File file = new File(filePath);
        if (!file.exists()){
            System.out.println("文件不存在");
        }

        ArrayList<Object> objects = new ArrayList<Object>();

        Field[] fields=  clz.getDeclaredFields();

        Workbook workBook = getAvailableWorkBook(filePath);
        FormulaEvaluator evaluator = workBook.getCreationHelper().createFormulaEvaluator();

        if (workBook == null){

        }

        for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
            Sheet sheet = workBook.getSheetAt(numSheet);
            if (numSheet > 0) {
                break;
            }
            //sheet页是隐藏的
            boolean sheetHidden = workBook.isSheetHidden(numSheet);

            //sheet页是超级隐藏的
            boolean sheetVeryHidden = workBook.isSheetVeryHidden(numSheet);
            if (sheet == null || sheetHidden || sheetVeryHidden) {
                continue;
            }

            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                Object obj = null;
                try{
                    obj = clz.getConstructor().newInstance();
                }   catch(Exception exception){
                    exception.printStackTrace();
                }

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    if (j >= fields.length) break;

                    Cell cell = row.getCell(j);
                    Field field = fields[j];
                    field.setAccessible(true);          //私有属性，修改权限
                    try{
                        switch (cell.getCellTypeEnum()){
                            case FORMULA:
                                field.set(obj, getFormualValue(evaluator.evaluate(cell)));
                                break;
                            case NUMERIC:

                                if (HSSFDateUtil.isCellDateFormatted(cell)){
                                    field.set(obj, cell.getDateCellValue());
                                }   else    {
                                    if ("java.lang.Integer".equals(field.getType().getName()))
                                        field.set(obj, ((Double)(cell.getNumericCellValue())).intValue());
                                    else if ("java.lang.Long".equals(field.getType().getName()))
                                        field.set(obj, (long)(cell.getNumericCellValue()));
                                    else if ("java.lang.String".equals(field.getType().getName()))
                                        field.set(obj, ((Double)(cell.getNumericCellValue())).toString());
                                    else
                                        field.set(obj, cell.getNumericCellValue());
                                }

                                break;

                            case STRING:

                                field.set(obj, cell.getStringCellValue());
                                break;

                            default:
                        }
                    }   catch(Exception exception){
                        exception.printStackTrace();
                    }


                }
                objects.add(obj);
            }

        }

        return objects;

    }

    public static Workbook getAvailableWorkBook(String filePath){
        String extension = filePath.lastIndexOf('.') == -1 ? "" : filePath.substring(filePath.lastIndexOf('.'));
        BufferedInputStream is = null;
        try{
            is = new BufferedInputStream(new FileInputStream(filePath));

            if (".xls".equals(extension)){
                POIFSFileSystem fs = new POIFSFileSystem(is);
                return new HSSFWorkbook(fs);
            }   else if (".xlsx".equals(extension) || ".xlsm".equals(extension)){
                return new XSSFWorkbook(is);
            }

        }   catch (Exception exception){
            if (exception instanceof FileNotFoundException) System.out.println("找不到文件");
            exception.printStackTrace();
        }
        return null;
    }

    public static double getFormualValue(CellValue cellValue){
        return cellValue.getNumberValue();
    }


    /**
     * 上传excel
     * @param file
     * @param response
     * @throws IOException
     */
    public static String uploadExcelData(MultipartFile file, HttpServletResponse response) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = PATH+ UUID.randomUUID().toString()+"_"+fileName;
        File excelFile = new File(filePath);
        if (!excelFile.getParentFile().exists()) {
            excelFile.getParentFile().mkdirs();
        }
        if (!excelFile.exists()) {
            excelFile.createNewFile();
        }
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        inputStream = new BufferedInputStream(file.getInputStream());
        outputStream = new BufferedOutputStream(new FileOutputStream(excelFile));

        int temp;
        //一个一个字节的读取并写入
        while((temp=inputStream.read())!=(-1))
        {
            outputStream.write(temp);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
        /*file.transferTo(excelFile);*/
        PrintWriter out = response.getWriter();
        out.write("success");
        out.close();

        return filePath;
    }

}

