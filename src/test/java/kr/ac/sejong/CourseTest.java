package kr.ac.sejong;

import kr.ac.sejong.service.CourseScheduleService;
import kr.ac.sejong.service.CourseService;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.CourseScheduleExcelDto;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleRequestDto;
import kr.ac.sejong.web.dto.course.CourseRequestDto;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class CourseTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseScheduleService courseScheduleService;

    private MultipartFile multipartFile;

    @Before
    public void before() throws IOException {
        String fileName = "testCourseSchedule.xlsx";
        String filePath = "src/test/resources/testCourseSchedulel.xlsx";

        //when
        multipartFile = new MockMultipartFile(fileName, new FileInputStream(new File(filePath)));
    }

    @Test
    public void importCourseScheduleExcelFile() throws IOException {

        //HTTP Response
        ExcelDto excelDto = ExcelDto.builder()
                .multipartFile(multipartFile)
                .build();

        List<CourseScheduleExcelDto> courseScheduleRequestDto = excelDto.toCourseScheduleExcelDtos();

        log.info(courseScheduleRequestDto.toString());
    }

    @Test
    public void test() throws IOException {
        ExcelDto excelDto = ExcelDto.builder()
                .multipartFile(multipartFile)
                .build();

        CourseScheduleRequestDto courseScheduleRequestDto = CourseScheduleRequestDto.builder()
                .name(excelDto.getFileName())
                .courses(
                        excelDto.toCourseScheduleExcelDtos().stream()
                                .map(CourseScheduleExcelDto::toSubjectDto)
                                .distinct()
                                .collect(Collectors.toList())
                )
                .build();

        log.info(courseScheduleRequestDto.toString());
    }

    @Test
    public void nonDistinctSubjcetsTest() {
        List<CourseRequestDto> requestDtos = Arrays.asList(
                CourseRequestDto.builder()
                        .title("test1")
                        .courseNo("9888")
                        .credit(3L)
                        .build(),
                CourseRequestDto.builder()
                        .title("test")
                        .courseNo("9999")
                        .credit(3L)
                        .build(),
                CourseRequestDto.builder()
                        .title("test")
                        .courseNo("9999")
                        .credit(2L)
                        .build(),
                CourseRequestDto.builder()
                        .title("test")
                        .courseNo("9999")
                        .credit(1L)
                        .build()
        );

        requestDtos = requestDtos.stream()
                .distinct()
                .collect(Collectors.toList());

        Assert.assertThat(requestDtos.size(), is(4));
    }
}
