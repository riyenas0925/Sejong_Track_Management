package kr.ac.sejong.persistence_old;

import kr.ac.sejong.domain_old.resultTrackVO;
import kr.ac.sejong.domain_old.ruleVO;
import kr.ac.sejong.domain_old.trackSubjectVO;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UploadResultDAOImpl implements UploadResultDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.uploadResultMapper";

    @Override
    public ruleVO readRule(Integer ruleNo) throws Exception{
        return session.selectOne(namespace+".readrule", ruleNo);
    }

    @Override
    public List<TrackSubjectJoinDto> readSub(Integer trackNo) throws Exception{
        return session.selectList(namespace+".readsub", trackNo);
    }

    @Override
    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("trackNo", trackNo);
        params.put("subtype", subType);

        return session.selectList(namespace+".readtypesub", params);
    }

    @Override
    public List<resultTrackVO> trackList(Integer univNo)throws Exception{
        return session.selectList(namespace+".resultTrack", univNo);
    }
}
