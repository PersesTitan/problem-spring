package com.shabi.problemspring.domain.member;

import com.shabi.problemspring.domain.member.dto.MemberDTO;
import com.shabi.problemspring.domain.problem.Problem;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
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
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String loginId;
    private String password;

    private final LocalDateTime createDate = LocalDateTime.now(); // 생성일

    @PastOrPresent
    private LocalDateTime updateDate;       // 최종 수정일

    @ToString.Exclude
    @JoinColumn(name = "problem_id")
    @OneToMany(targetEntity = Problem.class, cascade = CascadeType.ALL)
    private final List<Problem> problems = new ArrayList<>();

    private Member(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
        this.updateDate = LocalDateTime.now();
    }

    public static Member create(String loginId, String password) {
        return new Member(loginId, password);
    }

    public static Member create(MemberDTO memberDTO) {
        return new Member(memberDTO.loginId(), memberDTO.password());
    }

    // 업데이트 하였을때 현재 시간으로 수정하는 로직
    public void update() {
        this.updateDate = LocalDateTime.now();
    }

    public void update(String loginId, String password) {
        update();
        this.loginId = loginId;
        this.password = password;
    }
}
