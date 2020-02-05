package kr.ac.sejong;

import kr.ac.sejong.service.CourseScheduleService;
import kr.ac.sejong.service.SubjectService;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleExcelDto;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleRequestDto;
import kr.ac.sejong.web.dto.SubjectRequestDto;
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
public class SubjectTest {

    @Autowired
    private SubjectService subjectService;

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
        CourseScheduleExcelDto excelDto = CourseScheduleExcelDto.builder()
                .multipartFile(multipartFile)
                .fileName(multipartFile.getOriginalFilename())
                .build();


        CourseScheduleRequestDto courseScheduleRequestDto = CourseScheduleRequestDto.builder()
                .name(excelDto.getFileName())
                .subjects(
                        excelDto.toSubjectDtos().stream()
                                .distinct()
                                .collect(Collectors.toList())
                )
                .build();

        courseScheduleService.save(courseScheduleRequestDto);

        log.info(courseScheduleService.findAll().toString());
    }

    @Test
    public void nonDistinctSubjcetsTest() {
        List<SubjectRequestDto> requestDtos = Arrays.asList(
                SubjectRequestDto.builder()
                        .courseTitle("test1")
                        .courseNum("9888")
                        .credit(3L)
                        .build(),
                SubjectRequestDto.builder()
                        .courseTitle("test")
                        .courseNum("9999")
                        .credit(3L)
                        .build(),
                SubjectRequestDto.builder()
                        .courseTitle("test")
                        .courseNum("9999")
                        .credit(2L)
                        .build(),
                SubjectRequestDto.builder()
                        .courseTitle("test")
                        .courseNum("9999")
                        .credit(1L)
                        .build()
        );

        requestDtos = requestDtos.stream()
                .distinct()
                .collect(Collectors.toList());

        Assert.assertThat(requestDtos.size(), is(4));
    }
}
