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

/**
 * Created by set on 04.03.17.
 */
public class Excel {

    public void method1(Income income, Expenses expenses) {

        String filePath = System.getProperty("user.dir") + File.separator + "eco.xls";

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Тестовый файл");

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd  HH:mm:ss");


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

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(income.balanceMonth());
        row1.createCell(1).setCellValue(expenses.balanceMonth());
        row1.createCell(2).setCellValue(income.balanceMonth() - expenses.balanceMonth());
        row1.createCell(3).setCellValue(formatForDateNow.format(dateNow));



        File file =new File(filePath);
        file.exists();

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//
        System.out.println("Excel файл успешно создан!");
    }
}

