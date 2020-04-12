package kr.ac.sejong.web.dto.excel;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OnlyExcelFileValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyExcelFile {
    String message() default "Only Excel File Xls And Xlsx";

    Class<?>[] groups() default {

    };

    Class<? extends Payload>[] payload() default {

    };
}
