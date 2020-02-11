package kr.ac.sejong.web.dto.courseschedule;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.web.dto.SubjectRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
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
public class CourseScheduleExcelDto {
    private MultipartFile multipartFile;
    private String fileName;

    @Builder
    public CourseScheduleExcelDto(MultipartFile multipartFile, String fileName) {
        this.multipartFile = multipartFile;
        this.fileName = fileName;
    }

    public List<SubjectRequestDto> toSubjectDtos() throws IOException{

        List<SubjectRequestDto> subjects = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(this.multipartFile.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() != 0) {
                SubjectRequestDto dto = SubjectRequestDto.builder()
                        .courseNum(row.getCell(3).getStringCellValue())
                        .courseTitle(row.getCell(5).getStringCellValue())
                        .completionType(row.getCell(6).getStringCellValue())
                        .selectedArea(row.getCell(7).getStringCellValue())
                        .credit((long) row.getCell(9).getNumericCellValue())
                        .build();

                subjects.add(dto);
            }
        }
        return subjects;
    }
}