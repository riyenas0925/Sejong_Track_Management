package kr.ac.sejong.domain.track;

import kr.ac.sejong.web.dto.TrackAllViewDto;
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
    public List<TrackAllViewDto> trackAllList(Integer univId) throws Exception{

        return session.selectList(namespace+".trackAllList", univId);
    }
}
