package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.ruleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class TrackRuleDAOImpl implements TrackRuleDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.TrackRuleMapper";

    @Override
    public void create(ruleVO vo) throws Exception{
        session.insert(namespace+".create", vo);
    }

    @Override
    public ruleVO read(Integer ruleNo) throws Exception{
        return session.selectOne(namespace+".read", ruleNo);
    }

    @Override
    public void update(ruleVO vo) throws Exception{
        session.update(namespace+".update", vo);
    }

    @Override
    public void delete(Integer ruleNo) throws Exception{
        session.delete(namespace+".delete", ruleNo);
    }

    @Override
    public List<ruleVO> listAll() throws Exception {
        return session.selectList(namespace + ".listAll");
    }

    @Override
    public void aiInit(Integer aiNo) throws Exception{
        session.insert(namespace+".aiInit", aiNo);
    }
}
