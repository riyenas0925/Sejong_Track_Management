package kr.ac.sejong;

import kr.ac.sejong.domain.visitorVO;
import kr.ac.sejong.persistence.UploadResultDAO;
import kr.ac.sejong.persistence.VisitCountDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class VisitCountDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(VisitCountDAOTest.class);

    @Inject
    @Qualifier("VisitCountDAO")
    private VisitCountDAO dao;

    @Test
    public void createVisit()throws Exception{
        visitorVO vo = new visitorVO("1","2","3","4");

        dao.visitorCreate(vo);
    }

    @Test
    public void list() throws Exception{
        logger.info(dao.list().toString());
    }
}
