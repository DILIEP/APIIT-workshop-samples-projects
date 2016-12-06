package com.exam.paper.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.paper.domain.Paper;
import com.exam.paper.enums.Semester;
import com.exam.paper.repository.ExamPaperRepository;

@Service
public class ExamPaperImpl implements ExamPaper {

	@Autowired
	private ExamPaperRepository examPaperRepository;
	
	@Override
	public List<Paper> listPapers(LocalDateTime currentTime, Integer year, Semester semester) {
		return this.examPaperRepository.listPapers(currentTime, year, semester);
	}

	@Override
	public Boolean createPapers(LocalDateTime currentTime, Paper paper) {
		return this.examPaperRepository.createPapers(currentTime, paper);
	}
}
