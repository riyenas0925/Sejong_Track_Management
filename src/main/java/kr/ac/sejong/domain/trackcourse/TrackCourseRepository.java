package kr.ac.sejong.domain.trackcourse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackCourseRepository extends  JpaRepository<TrackCourse, Long>, TrackCourseCustomRepository {

}