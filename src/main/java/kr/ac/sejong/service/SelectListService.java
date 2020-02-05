package kr.ac.sejong.service;

import kr.ac.sejong.domain.Degree;
import kr.ac.sejong.domain.Track;
import kr.ac.sejong.domain.Univ;

import java.util.List;

public interface SelectListService {
    public List<Univ> univList() throws Exception;

    public List<Degree> degreeList() throws Exception;

    public List<Track> trackList(Long univId) throws Exception;
}
