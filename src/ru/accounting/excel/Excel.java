package ru.accounting.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import ru.accounting.Expenses;
import ru.accounting.Income;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by set on 05.03.17.
 */
public class Excel {
    public void addHistory (Income income, Expenses expenses) {

        String filePath = System.getProperty("user.dir") + File.separator + "ecoHistory.xls";


        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("История");


        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");


        HSSFFont font = workbook.createFont();
        // указываем, что хотим его видеть жирным
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // создаем стиль для ячейки
        font.setFontHeightInPoints((short) 12);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);


        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Доход");
        row.getCell(0).setCellStyle(style);
        row.createCell(1).setCellValue("Расход");
        row.getCell(1).setCellStyle(style);
        row.createCell(2).setCellValue("Баланс");
        row.getCell(2).setCellStyle(style);
        row.createCell(3).setCellValue("Дата");
        row.getCell(3).setCellStyle(style);


        List<Double> inc = income.getMi();
        List<Double> min = expenses.getCm();
        int max = inc.size() > min.size()? inc.size(): min.size();

        for(int i = 0; i < max; i++) {
            Row row1 = sheet.createRow(i + 1);
            if (i < inc.size()) {
                row1.createCell(0).setCellValue(inc.get(i));
                row1.createCell(3).setCellValue(formatForDateNow.format(dateNow));
            }
            if (i < min.size()) {
                row1.createCell(1).setCellValue(min.get(i));
                row1.createCell(3).setCellValue(formatForDateNow.format(dateNow));
            }


        }
        Row row1 = sheet.createRow(max+1);
        row1.createCell(1).setCellValue("Итого:");
        row1.getCell(1).setCellStyle(style);
        row1.createCell(2).setCellValue(balanceMonth(inc) - balanceMonth(min));

/*

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(income.balanceMonth());
        row1.createCell(1).setCellValue(expenses.balanceMonth());
//        row1.createCell(2).setCellValue(income.balanceMonth() - expenses.balanceMonth());
        row1.createCell(2).setCellValue(formatForDateNow.format(dateNow));
*/


        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//
        System.out.println("Excel файл успешно создан!");
    }
    public double balanceMonth(List<Double> list){
        double sum = 0.0;
        for(Double d : list){
            sum += d;
        }

        return sum;
    }

    public  double balanceYear(List<Double> list){
        return balanceMonth(list)*12;
    }
}

