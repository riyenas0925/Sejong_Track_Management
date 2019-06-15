package kr.ac.sejong.persistence_old;

import kr.ac.sejong.domain_old.trackVO;
import kr.ac.sejong.domain_old.univVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


@Repository
public class UploadFormDAOImpl implements UploadFormDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.uploadFormMapper";

    @Override
    public List<trackVO> listTrack(Integer univNo) throws Exception{
        return session.selectList(namespace+".listTrack", univNo);
    }

    @Override
    public List<univVO> listUniv() throws Exception{
        return session.selectList(namespace+".listUniv");
    }

}
