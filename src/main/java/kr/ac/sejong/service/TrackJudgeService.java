package kr.ac.sejong.service;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
@Log
public class TrackJudgeService {

    @Transactional
    public List<TrackJudge> trackJudge(Map<TrackCourse.Type, Rule> trackRule,
                                       List<Course> transcriptTrack,
                                       Map<Track, List<TrackCourse>> standardTracks) {

        List<TrackJudge> trackJudges = new ArrayList<>();

        standardTracks.forEach((key, value) -> {
            TrackJudge trackJudge = new TrackJudge(transcriptTrack, value, trackRule);
            trackJudges.add(trackJudge);
        });

        return trackJudges;
    }
}
