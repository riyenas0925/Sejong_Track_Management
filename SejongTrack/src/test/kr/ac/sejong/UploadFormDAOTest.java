package kr.ac.sejong;

import kr.ac.sejong.persistence.UploadFormDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class UploadFormDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(UploadFormDAOTest.class);

    @Inject
    private UploadFormDAO dao;

    @Test
    public void trackList() throws Exception{
        logger.info(dao.listTrack(1).toString());
    }

    @Test
    public void univList() throws Exception{
        logger.info(dao.listUniv().toString());
    }
}
