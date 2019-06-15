package kr.ac.sejong.persistence_old;

import kr.ac.sejong.domain_old.trackVO;
import kr.ac.sejong.domain_old.univVO;

import java.util.List;


public interface UploadFormDAO {
    public List<trackVO> listTrack(Integer univNo)throws Exception;

    public List<univVO> listUniv()throws Exception;
}
