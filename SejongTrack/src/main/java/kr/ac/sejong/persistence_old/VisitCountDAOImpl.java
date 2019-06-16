package kr.ac.sejong.persistence_old;

import kr.ac.sejong.domain_old.graphVO;
import kr.ac.sejong.domain_old.visitorVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class VisitCountDAOImpl implements VisitCountDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.trackStatusMapper";

    @Override
    public void visitorCreate(visitorVO vo)throws Exception{
       session.insert(namespace+".createVisitor", vo);
    }

    @Override
    public Integer todayCount()throws Exception{
       return session.selectOne(namespace + ".todayCount");
    }

    @Override
    public Integer totalCount()throws Exception{
        return session.selectOne(namespace + ".totalCount");
    }

    @Override
    public List<visitorVO> list() throws Exception{
        return session.selectList(namespace + ".list");
    }

    @Override
    public List<graphVO> deviceGraph()throws Exception{
        return session.selectList(namespace + ".deviceGraph");
    }

    @Override
    public List<graphVO> browserGraph()throws Exception{
        return session.selectList(namespace + ".browserGraph");
    }
}
