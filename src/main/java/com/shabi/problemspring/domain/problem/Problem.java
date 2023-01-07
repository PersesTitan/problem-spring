package com.shabi.problemspring.domain.problem;

import com.shabi.problemspring.domain.member.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Problem implements Serializable {
    @Id
    @GeneratedValue
    @Column(unique = true, name = "problem_id")
    private Long id;

    @ToString.Exclude
    @JoinColumn(name = "problem_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private Long likeCount = 0L;        // 인기도
    private Long totalCount = 0L;       // 시험 총 횟수
    private Integer problemCount = 0;   // 문제 갯수
    @Max(100) @Min(0)
    private Integer answerRate = 0;     // 정답률

    @PastOrPresent
    private LocalDateTime createDate;   // 생성일
    @PastOrPresent
    private LocalDateTime updateDate;   // 최종 수정일

    @ToString.Exclude
    @JoinColumn(name = "problem_item_id")
    @OneToMany(mappedBy = "problem", orphanRemoval = true)
    private List<ProblemItem> problemItems = new ArrayList<>();
}
