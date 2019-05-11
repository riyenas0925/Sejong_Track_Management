package kr.ac.sejong;

import kr.ac.sejong.controller.TrackRuleController;
import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.persistence.TrackRuleDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class TrackRuleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(TrackRuleController.class);

    @Inject
    private TrackRuleDAO dao;

    //규칙 추가 테스트
    @Test
    public void testCreate() throws Exception{
        Random random = new Random();
        ruleVO rule = new ruleVO();
        rule.setTrackId(12);
        rule.setBasic(random.nextInt(20));
        rule.setApplied(random.nextInt(20));
        rule.setIndustry(random.nextInt(20));

        dao.create(rule);
    }

    //규칙 생성 10개
    @Test
    public void testCreateMany() throws Exception{
        for(int i=0; i < 10; i++) {
            testCreate();
        }
    }

    //규칙 조회 테스트
    @Test
    public void testRead() throws Exception{
        logger.info(dao.read(1).toString());
    }

    //전체트랙 출력
    @Test
    public void testAllTrack() throws Exception{
        logger.info(dao.listSearch(1).toString());
    }

    //규칙 수정 테스트
    @Test
    public void testUpdate() throws Exception{
        ruleVO rule = new ruleVO();
        rule.setRuleNo(1);
        rule.setTrackId(12);
        rule.setBasic(9);
        rule.setApplied(9);
        rule.setIndustry(9);
        dao.update(rule);
    }

    //규칙 삭제
    @Test
    public void testDelete() throws Exception{
        dao.delete(1);
    }

    //규칙 삭제 전체
    @Test
    public void testDeleteAll() throws Exception{
        for(int i=0; i < 1000; i++){
            dao.delete(i);
        }

        dao.aiInit(1);
    }

    //AI(Auto Increment) 값을 0으로 초기화
    @Test
    public void testAiInit() throws Exception{
        dao.aiInit(1);
    }

    @Test
    public void degreeList() throws Exception{
        logger.info(dao.degreeList().toString());
    }
}
