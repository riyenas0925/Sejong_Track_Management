package kr.ac.sejong.domain.notice;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "tbl_notice")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @CreationTimestamp
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Builder
    public Notice(String title, String content, String author, Date modifiedDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.modifiedDate = modifiedDate;
    }

    public void update(String title, String author, String content){
        this.title = title;
        this.author = author;
        this.content = content;
        this.modifiedDate = new Date();

    }

}
