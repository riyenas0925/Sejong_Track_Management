package kr.ac.sejong;

import kr.ac.sejong.persistence.TrackAllDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class TrackAllDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(TrackAllDAOTest.class);

    @Inject
    private TrackAllDAO dao;

    @Test
    public void trackListTest() throws Exception{
        logger.info(dao.trackAllList(2).toString());
    }
}
