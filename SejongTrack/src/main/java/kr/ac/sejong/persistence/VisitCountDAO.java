package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.graphVO;
import kr.ac.sejong.domain.visitorVO;

import java.util.List;

public interface VisitCountDAO {
    public void visitorCreate(visitorVO vo)throws Exception;

    public Integer todayCount()throws Exception;

    public Integer totalCount()throws Exception;

    public List<visitorVO> list()throws Exception;

    public List<graphVO> deviceGraph()throws Exception;

    public List<graphVO> browserGraph()throws Exception;
}
