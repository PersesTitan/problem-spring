package com.shabi.problemspring.domain.member;

import com.shabi.problemspring.domain.problem.Problem;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements Serializable {
    @Id
    @GeneratedValue
    @Column(unique = true, name = "member_id")
    private Long id;

    @Column(unique = true)
    private String loginId;
    private String password;

    @PastOrPresent
    private LocalDateTime createDate;
    @PastOrPresent
    private LocalDateTime updateDate;

    @ToString.Exclude
    @JoinColumn(name = "problem_id")
    @OneToMany(mappedBy = "member", orphanRemoval = true)
    private final List<Problem> problems = new ArrayList<>();

    private Member(String loginId, String password, LocalDateTime createDate, LocalDateTime updateDate) {
        this.loginId = loginId;
        this.password = password;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void addProblem(Problem problem) {
        this.problems.add(problem);
    }

}
