package kr.ac.sejong;

import kr.ac.sejong.persistence.UploadResultDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class UploadResultDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(UploadResultDAOTest.class);

    @Inject
    private UploadResultDAO dao;

    @Test
    public void testReadRule() throws Exception{
        logger.info(dao.readRule(1).toString());
        logger.info(dao.readRule(2).toString());
    }

    @Test
    public void testReadSub() throws Exception{
        logger.info(dao.readSub(1).toString());
        logger.info(dao.readSub(2).toString());
    }

    @Test
    public void testReadTypeSub() throws Exception{
        logger.info(dao.readTypeSub(1,1).toString());
        logger.info(dao.readTypeSub(1,2).toString());
        logger.info(dao.readTypeSub(1,3).toString());
    }
}
