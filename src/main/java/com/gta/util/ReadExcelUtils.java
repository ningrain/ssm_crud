package com.gta.util;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 读取Excel工具
 * User: jiangningning
 * Date: 2018/1/8
 * Time: 9:45
 */
public class ReadExcelUtils {

    private static Logger logger = Logger.getLogger(ReadExcelUtils.class);
    private Workbook wb;
    private Sheet sheet;
    private Row row;

    public ReadExcelUtils(String filePath) {
        if (filePath == null) {
            return;
        }
        String ext = filePath.substring(filePath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filePath);
            if (".xls".equals(ext)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        }
    }

    /**
     * 方法 readExcelTitle 功能：
     *
     * @return String[] 表头内容的数组
     * @author ningning.jiang 2018年01月08日 10:08:17
     */
    public String[] readExcelTitle() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空。");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        logger.info("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = row.getCell(i).getRichStringCellValue().getString();
        }
        return title;
    }

    public Map<Integer, Map<Integer, Object>> readExcelContent() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空。");
        }
        Map<Integer, Map<Integer, Object>> content = new HashMap<>();
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        //row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文应该从第二行开始，第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer, Object> cellValue = new HashMap<>();
            while (j < colNum) {
                Object obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);
                j++;
            }
            content.put(i, cellValue);
        }
        return content;
    }

    private Object getCellFormatValue(Cell cell) {
        Object cellValue;
        if (cell != null) {
            //判断当前cell的Type
            switch (cell.getCellTypeEnum()) {
                // 如果当前Cell的Type为NUMERIC
                case NUMERIC: {
                }
                case FORMULA: {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式
                        // data格式是带时分秒的：2013-7-10 0:00:00
                        // cellValue = cell.getDateCellValue().toLocaleString();
                        // data格式是不带带时分秒的：2013-7-10
                        cellValue = cell.getDateCellValue();
                    } else { // 如果是纯数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default: {
                    cellValue = "";
                }
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }
}
