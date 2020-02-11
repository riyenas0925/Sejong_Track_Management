package kr.ac.sejong.web.dto;

import kr.ac.sejong.domain.notice.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

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
                .modifiedDate(new Date())
                .build();
    }

}
