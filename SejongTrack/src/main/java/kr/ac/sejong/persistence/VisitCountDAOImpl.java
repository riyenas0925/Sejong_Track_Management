package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.visitorVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class VisitCountDAOImpl implements VisitCountDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.trackStatusMapper";

    @Override
    public void visitorCreate(visitorVO vo)throws Exception{
        session.insert(namespace+".createVisitor", vo);
    }
}
