package kr.ac.sejong.service;

import kr.ac.sejong.domain_jpa.Degree;
import kr.ac.sejong.domain_jpa.Track;
import kr.ac.sejong.domain_jpa.Univ;

import java.util.List;

public interface SelectListService {
    public List<Univ> univList() throws Exception;

    public List<Degree> degreeList() throws Exception;

    public List<Track> trackList(Long univId) throws Exception;
}
