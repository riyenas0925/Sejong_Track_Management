package kr.ac.sejong.web.dto.excel;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class OnlyExcelFileValidator implements ConstraintValidator<OnlyExcelFile, MultipartFile> {

    @Override
    public void initialize(OnlyExcelFile onlyExcelFile) {

    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {

        String regExp = "^\\S+.(?i)(xls|xlsx)$";

        boolean isOnlyExcelFile = file.getOriginalFilename().matches(regExp);

        if (!isOnlyExcelFile) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    MessageFormat.format("{0} is not Excel File", file.getOriginalFilename()))
                    .addConstraintViolation();
        }
        return isOnlyExcelFile;
    }
}
