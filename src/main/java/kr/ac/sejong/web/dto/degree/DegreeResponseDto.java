package kr.ac.sejong.web.dto.degree;

import kr.ac.sejong.domain.degree.Degree;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DegreeResponseDto {
    private Long id;
    private String title;

    public DegreeResponseDto(Degree entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
    }
}
