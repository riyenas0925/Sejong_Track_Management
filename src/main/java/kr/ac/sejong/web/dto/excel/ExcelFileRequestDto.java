package kr.ac.sejong.web.dto.excel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@ToString
public class ExcelFileRequestDto {
    @OnlyExcelFile(message = "valid error")
    private MultipartFile multipartFile;
}
