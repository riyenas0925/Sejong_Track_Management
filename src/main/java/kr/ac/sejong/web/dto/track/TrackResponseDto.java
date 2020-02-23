package kr.ac.sejong.web.dto.track;

import kr.ac.sejong.domain.track.Track;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TrackResponseDto {
    private Long trackId;
    private String trackTitle;
    private Long trackNo;

    public TrackResponseDto(Track entity) {
        this.trackId = entity.getTrackId();
        this.trackTitle = entity.getTrackTitle();
        this.trackNo = entity.getTrackNo();
    }
}
