package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.visitorVO;

public interface VisitCountDAO {
    public void visitorCreate(visitorVO vo)throws Exception;

    public Integer todayCount()throws Exception;

    public Integer totalCount()throws Exception;
}
