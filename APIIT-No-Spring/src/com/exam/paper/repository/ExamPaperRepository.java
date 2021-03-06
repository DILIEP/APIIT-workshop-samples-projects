package com.exam.paper.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.exam.paper.domain.Paper;
import com.exam.paper.enums.Semester;

public interface ExamPaperRepository {

	public List<Paper> listPapers(LocalDateTime currentTime, Integer year, Semester semester);

	public Boolean createPapers(LocalDateTime currentTime, Paper paper);
}
