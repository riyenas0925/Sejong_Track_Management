package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.subjectVO;
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
    public List<subjectVO> readTrack(Integer trackNo) throws Exception{
        return session.selectList(namespace+".readTrack",trackNo);
    }
}
