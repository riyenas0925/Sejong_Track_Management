package kr.ac.sejong.web.dto.notice;

import kr.ac.sejong.domain.notice.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeRequestDto {

    private String title;
    private String content;
    private String author;

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
