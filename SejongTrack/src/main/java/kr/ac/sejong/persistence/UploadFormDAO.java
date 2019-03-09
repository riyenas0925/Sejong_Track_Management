package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;

import java.util.List;


public interface UploadFormDAO {
    public List<trackVO> listTrack(Integer univNo)throws Exception;

    public List<univVO> listUniv()throws Exception;
}
