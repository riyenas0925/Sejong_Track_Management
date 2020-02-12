package kr.ac.sejong.web.dto.excel;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class ExcelDto {
    private MultipartFile multipartFile;
    private String fileName;
    private Long size;

    @Builder
    public ExcelDto(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
        this.fileName = multipartFile.getOriginalFilename();
        this.size = multipartFile.getSize();
    }

    public List<CourseScheduleExcelDto> toCourseScheduleExcelDtos() throws IOException {

        List<CourseScheduleExcelDto> CourseScheduleExcelSubjects = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(this.multipartFile.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() != 0) {
                CourseScheduleExcelDto dto = CourseScheduleExcelDto.builder()
                        .no((long) row.getCell(0).getNumericCellValue())
                        .department(row.getCell(1).getStringCellValue())
                        .major(row.getCell(2).getStringCellValue())
                        .courseNum(row.getCell(3).getStringCellValue())
                        .courseTitle(row.getCell(5).getStringCellValue())
                        .completionType(row.getCell(6).getStringCellValue())
                        .selectedArea(row.getCell(7).getStringCellValue())
                        .year((long) row.getCell(8).getNumericCellValue())
                        .credit((long) row.getCell(9).getNumericCellValue())
                        .classType(row.getCell(17).getStringCellValue())
                        .language(row.getCell(19).getStringCellValue())
                        .build();

                CourseScheduleExcelSubjects.add(dto);
            }
        }
        return CourseScheduleExcelSubjects;
    }

    public List<ReportCardExcelDto> toReportCardExcelDtos() throws IOException {
        List<ReportCardExcelDto> reportCardExcelSubjects = new ArrayList<>();

        HSSFWorkbook workbook = new HSSFWorkbook(this.multipartFile.getInputStream());
        HSSFSheet sheet = workbook.getSheetAt(0);

        for(Row row : sheet)
            if(row.getRowNum() != 0){
                ReportCardExcelDto dto = ReportCardExcelDto.builder()
                        .year(row.getCell(0).getStringCellValue())
                        .semester(row.getCell(1).getStringCellValue())
                        .courseNum(row.getCell(2).getStringCellValue())
                        .courseTitle(row.getCell(3).getStringCellValue())
                        .completionType(row.getCell(4).getStringCellValue())
                        .teaching(row.getCell(5).getStringCellValue())
                        .selectedArea(row.getCell(6).getStringCellValue())
                        .credit(row.getCell(7).getStringCellValue())
                        .evaluation(row.getCell(8).getStringCellValue())
                        //.grade(row.getCell(9).getStringCellValue())
                        .gradePoint(row.getCell(10).getStringCellValue())
                        .departmentCode(row.getCell(11).getStringCellValue())
                        .build();

                reportCardExcelSubjects.add(dto);
            }

        return reportCardExcelSubjects;
    }
}