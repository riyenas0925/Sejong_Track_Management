package kr.ac.sejong.service;

import kr.ac.sejong.domain_old.trackVO;
import kr.ac.sejong.domain_old.univVO;

import java.util.List;

public interface UploadFormService {
    public List<trackVO> listTrack(Integer univNo)throws Exception;

    public List<univVO> listUniv()throws Exception;
}
