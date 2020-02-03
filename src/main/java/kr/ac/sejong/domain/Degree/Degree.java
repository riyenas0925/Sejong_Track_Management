package kr.ac.sejong.domain.Degree;

import kr.ac.sejong.domain.Rule.Rule;
import lombok.*;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Entity
@Table(name = "tbl_degree")
@ToString(exclude = "rules")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long degreeId;

    private String degreeTitle;
    
    @JsonIgnore
    @OneToMany(mappedBy = "degree", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Rule> rules;
    
    public Degree() {
        
    }
    
    @Builder
    public Degree(Long degreeId, String degreeTitle) {
        this.degreeId = degreeId;
        this.degreeTitle = degreeTitle;
    }
}
