import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Zhao Qing on 2018/1/7.
 */
public class ExcelUtil {
    public static void main(String[] args) throws Exception{
        ExcelUtil.CreateExcel();
    }

    private static String[] titles = {"部门", "姓名", "加班原因", "加班时长（小时）", "加班日期", "加班地点"};

    public static void CreateExcel() throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();//创建excel文档
        HSSFSheet sheet = workbook.createSheet("产品研发二部月加班记录");

        HSSFFont font = workbook.createFont();//字体样式
        font.setFontName("宋体");

        HSSFCellStyle cellStyle = workbook.createCellStyle();//单元格样式
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);//水平对齐方式
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直对齐方式
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);//边框颜色
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setFont(font);//字体

        HSSFRow title = sheet.createRow(0);//创建第一行
        title.setHeight((short) 500);//行高度
        for (int i = 0; i< titles.length; i++){
            HSSFCell cell = title.createCell(i);//创建一个单元格
            cell.setCellStyle(cellStyle);
            cell.setCellValue(titles[i]);
        }

        HSSFRow row = sheet.createRow(1);
        row.setHeight((short) 500);//行高度
        HSSFCell cell0 = row.createCell(0);//创建单元格
        cell0.setCellStyle(cellStyle);
        cell0.setCellValue("产品研发中心二部");

        HSSFCell cell1 = row.createCell(1);//创建单元格
        cell1.setCellStyle(cellStyle);
        cell1.setCellValue("赵庆");

        HSSFCell cell2 = row.createCell(2);//创建单元格
        cell2.setCellStyle(cellStyle);
        cell2.setCellValue("小程序测试");

        HSSFCell cell3 = row.createCell(3);//创建单元格
        cell3.setCellStyle(cellStyle);
        cell3.setCellValue("2.5");

        HSSFCell cell4 = row.createCell(4);//创建单元格
        cell4.setCellStyle(cellStyle);
        cell4.setCellValue("2017-01-08");

        HSSFCell cell5 = row.createCell(5);//创建单元格
        cell5.setCellStyle(cellStyle);
        cell5.setCellValue("公司");

        sheet.autoSizeColumn((short)0); //调整第一列宽度
        sheet.autoSizeColumn((short)1); //调整第二列宽度
        sheet.autoSizeColumn((short)2); //调整第三列宽度
        sheet.autoSizeColumn((short)3); //调整第四列宽度
        sheet.autoSizeColumn((short)4); //调整第五列宽度
        sheet.autoSizeColumn((short)5); //调整第六列宽度

        try {
            FileOutputStream outputStream = new FileOutputStream("E:\\加班记录.xls");
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("生成excel文件成功");
        }catch (Exception exc){
            System.out.println("生成excel文件失败");
            exc.printStackTrace();
        }

    }
}
