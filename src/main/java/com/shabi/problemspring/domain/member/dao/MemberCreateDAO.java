package com.shabi.problemspring.domain.member.dao;

import com.shabi.problemspring.domain.problem.Problem;

import java.time.LocalDateTime;
import java.util.List;

public record MemberCreateDAO(String loginId, LocalDateTime createDate,
                              LocalDateTime updateDate, List<Problem> problems) {
}
