package kr.ac.sejong.persistence_old;

import kr.ac.sejong.domain_old.degreeVO;
import kr.ac.sejong.domain_old.ruleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ruleVO readRule(Integer degree, Integer trackNo)throws Exception{

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("degree", degree);
        params.put("trackNo", trackNo);

        return session.selectOne(namespace + ".readRule", params);
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
    public List<ruleVO> listSearch(Integer univNo)throws Exception{
        return session.selectList(namespace + ".listSearch", univNo);
    }

    @Override
    public void aiInit(Integer aiNo) throws Exception{
        session.insert(namespace+".aiInit", aiNo);
    }

    @Override
    public List<degreeVO> degreeList()throws Exception{
        return session.selectList(namespace + ".degreeList");
    }
}
