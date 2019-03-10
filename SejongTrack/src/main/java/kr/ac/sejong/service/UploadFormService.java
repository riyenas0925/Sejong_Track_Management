package kr.ac.sejong.service;

import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;

import java.util.List;

public interface UploadFormService {
    public List<trackVO> listTrack(Integer univNo)throws Exception;

    public List<univVO> listUniv()throws Exception;
}
