package kr.ac.sejong.domain.degree;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.rule.Rule;
import lombok.*;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Entity
@Table(name = "degree")
@ToString(exclude = "rules")
@NoArgsConstructor
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    @JsonIgnore
    @OneToMany(mappedBy = "degree", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Rule> rules;

    @Builder
    public Degree(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        final Degree dto = (Degree) obj;

        if(this == dto) {
            return true;
        } else {
            return (this.id.equals(dto.id));
        }
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        return result;
    }
}
