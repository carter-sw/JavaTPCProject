package Default;

import kr.inflean.ExcelVO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Project03_A {
    public static void main(String[] args) {
        String fileName ="bookList.xls";
        List<ExcelVO> data = new ArrayList<ExcelVO>();

        try(FileInputStream fis = new FileInputStream(fileName)){
            HSSFWorkbook workbook = new HSSFWorkbook(fis);// 엑셀파일을 메모리로 로딩(가상의 엑셀)
            HSSFSheet sheet = workbook.getSheetAt(0); // 엑셀 0번쨰 시트
            Iterator<Row> rows = sheet.rowIterator();
            rows.next();

            String [] imsi  =new String[5]; // 임시 데이터 저장공간

            while (rows.hasNext()){
                HSSFRow row =(HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                int i =0;

                while (cells.hasNext()){
                    HSSFCell cell = (HSSFCell) cells.next();
                    imsi[i] = cell.toString();
                    i++;
                }
                //데이터를 묶고 (VO) -> 담고 (List)
                ExcelVO vo = new ExcelVO(imsi[0],imsi[1],imsi[2],imsi[3],imsi[4]);
                data.add(vo);
            }
            showExcelData(data);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void showExcelData(List<ExcelVO> data) {
        for(ExcelVO vo:data){
            System.out.println(vo);
        }
    }
}
