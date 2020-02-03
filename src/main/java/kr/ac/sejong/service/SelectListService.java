package kr.ac.sejong.service;

import kr.ac.sejong.domain.degree.Degree;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.univ.Univ;

import java.util.List;

public interface SelectListService {
    public List<Univ> univList() throws Exception;

    public List<Degree> degreeList() throws Exception;

    public List<Track> trackList(Long univId) throws Exception;
}
