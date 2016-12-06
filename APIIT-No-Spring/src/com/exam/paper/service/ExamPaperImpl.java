package com.exam.paper.service;

import java.time.LocalDateTime;
import java.util.List;

import com.exam.paper.domain.Paper;
import com.exam.paper.enums.Semester;
import com.exam.paper.repository.ExamPaperRepository;
import com.exam.paper.repository.ExamPaperRepositoryImpl;

public class ExamPaperImpl implements ExamPaper {

	private ExamPaperRepository examPaperRepository;
	
	public ExamPaperImpl(){
		this.examPaperRepository = new ExamPaperRepositoryImpl();
	}
	
	@Override
	public List<Paper> listPapers(LocalDateTime currentTime, Integer year, Semester semester) {
		return this.examPaperRepository.listPapers(currentTime, year, semester);
	}

	public ExamPaperRepository getExamPaperRepository() {
		return examPaperRepository;
	}

	public void setExamPaperRepository(ExamPaperRepository examPaperRepository) {
		this.examPaperRepository = examPaperRepository;
	}

	@Override
	public Boolean createPapers(LocalDateTime currentTime, Paper paper) {
		return this.examPaperRepository.createPapers(currentTime, paper);
	}
}
