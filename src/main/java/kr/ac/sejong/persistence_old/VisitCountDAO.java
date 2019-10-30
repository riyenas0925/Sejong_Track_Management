package kr.ac.sejong.persistence_old;

import kr.ac.sejong.domain_old.graphVO;
import kr.ac.sejong.domain_old.visitorVO;

import java.util.List;

public interface VisitCountDAO {
    public void visitorCreate(visitorVO vo)throws Exception;

    public Integer todayCount()throws Exception;

    public Integer totalCount()throws Exception;

    public List<visitorVO> list()throws Exception;

    public List<graphVO> deviceGraph()throws Exception;

    public List<graphVO> browserGraph()throws Exception;
}
