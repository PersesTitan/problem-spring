package com.shabi.problemspring.domain.problem.dto;

import com.shabi.problemspring.domain.problem.Problem;

public record ProblemItemDTO(Problem problem, String problemNumber, String title, String content, float score, int result) {
}
