package kr.ac.sejong.web.dto.track;

import kr.ac.sejong.domain.track.Track;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TrackResponseDto {
    private Long id;
    private String title;
    private Long trackNo;

    public TrackResponseDto(Track entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.trackNo = entity.getTrackNo();
    }
}
