package com.shabi.problemspring.domain.problem;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProblemItem implements Serializable {
    @Id
    @GeneratedValue
    @Column(unique = true, name = "problem_item_id")
    private Long id;

    @ToString.Exclude
    @JoinColumn(name = "problem_item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Problem problem;

    private Long tryCount = 0L;     // 시도한 횟수
    private Long answer = 0L;       // 해당 문제를 맞춘 횟수

}
