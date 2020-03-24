package kr.ac.sejong;

import kr.ac.sejong.service.CourseScheduleService;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
@Commit
public class CourseScheduleTest {

    @Autowired
    private CourseScheduleService courseScheduleService;

    MultipartFile multipartFile;

    @Before
    public void before() throws IOException {
        String fileName = "testCourseSchedule.xlsx";
        String filePath = "src/test/resources/testCourseSchedulel.xlsx";

        //when
        multipartFile = new MockMultipartFile(fileName, new FileInputStream(new File(filePath)));
    }


    @Test
    public void importExcelCourseScheduleFile() throws IOException {
        courseScheduleService.saveCourseScheduleWithSubject(multipartFile);
    }

    @Test
    public void deleteError() throws IOException {
        courseScheduleService.saveCourseScheduleWithSubject(multipartFile);
        courseScheduleService.saveCourseScheduleWithSubject(multipartFile);

        courseScheduleService.delete(2L);
    }

    /*
    @Test
    public void saveCourseSchedule() {
        CourseScheduleRequestDto requestDto = new CourseScheduleRequestDto("testCourseExcel.xls");
        courseScheduleService.save(requestDto);
        log.info(courseScheduleService.findById(1L).toString());
    }

    @Test
    public void updateCourseSchedule() {
        CourseScheduleRequestDto requestDto1 = new CourseScheduleRequestDto("testCourseExcel.xls");
        CourseScheduleRequestDto requestDto2 = new CourseScheduleRequestDto("updateCourseExcel.xls");

        courseScheduleService.save(requestDto1);
        log.info(courseScheduleService.findById(1L).toString());
        courseScheduleService.update(1L, requestDto2);
        log.info(courseScheduleService.findById(1L).toString());

    }

    @Test
    public void deleteCourseSchedule() {
        courseScheduleService.delete(1L);
    }

    @Test
    public void findAllCourseSchedule() {
        log.info(courseScheduleService.findAll().toString());
    }
    */
}