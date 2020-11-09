package com.test.classes;

import com.test.entities.Car;
import com.test.entities.Penalty;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class ExcelDocument extends AbstractXlsView {

    private List<Penalty> penalties;

    public ExcelDocument(){}

    public ExcelDocument(List<Penalty> penalties){
        this.penalties = penalties;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet excelSheet = workbook.createSheet("Simple excel example");
        response.setHeader("Content-Disposition", "attachment; filename=rating.xls");

        Row header = excelSheet.createRow(0);
        header.createCell(0).setCellValue("Штраф");
        header.createCell(1).setCellValue("Пошлина");

        int row = 1;

        for (Penalty penalty : penalties) {
            Row data = excelSheet.createRow(row);
            data.createCell(0).setCellValue(penalty.getTypePenalty());
            data.createCell(1).setCellValue(penalty.getTarrif());
            row++;
        }
    }
}
