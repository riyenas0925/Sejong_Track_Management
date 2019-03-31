package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackAllVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class TrackAllDAOImpl implements  TrackAllDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.trackAllMapper";

    @Override
    public trackAllVO trackAll(Integer trackNo) throws Exception{
        return session.selectOne(namespace+".trackAll", trackNo);
    }

    @Override
    public List<Integer> trackAllList(Integer univNo) throws Exception{
        return session.selectList(namespace+".trackAllList", univNo);
    }
}
