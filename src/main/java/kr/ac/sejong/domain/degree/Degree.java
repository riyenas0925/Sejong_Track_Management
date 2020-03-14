package kr.ac.sejong.domain.degree;

import kr.ac.sejong.domain.rule.Rule;
import lombok.*;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Entity
@Table(name = "degree")
@ToString(exclude = "rules")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    @JsonIgnore
    @OneToMany(mappedBy = "degree", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Rule> rules;
    
    public Degree() {
        
    }
    
    @Builder
    public Degree(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
