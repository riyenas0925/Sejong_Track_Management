package kr.ac.sejong.service;

import kr.ac.sejong.domain.Degree.Degree;
import kr.ac.sejong.domain.Track.Track;
import kr.ac.sejong.domain.Univ.Univ;

import java.util.List;

public interface SelectListService {
    public List<Univ> univList() throws Exception;

    public List<Degree> degreeList() throws Exception;

    public List<Track> trackList(Long univId) throws Exception;
}
