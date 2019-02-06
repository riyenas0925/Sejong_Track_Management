package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.testVO;
import kr.ac.sejong.domain.trackSubjectVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Repository
public class UploadResultDAOImpl implements UploadResultDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.uploadResultMapper";

    @Override
    public testVO readRule(String trackName) throws Exception{
        return session.selectOne(namespace+".readrule", trackName);
    }

    @Override
    public List<trackSubjectVO> readSub(String trackName) throws Exception{
        return session.selectList(namespace+".readsub", trackName);
    }
}
