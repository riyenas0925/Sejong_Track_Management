package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.visitorVO;

public interface VisitCountDAO {
    public void visitorCreate(visitorVO vo)throws Exception;
}
