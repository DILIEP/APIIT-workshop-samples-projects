package com.exam.paper.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.exam.paper.domain.Paper;
import com.exam.paper.enums.Semester;

@Repository
public class ExamPaperRepositoryImpl implements ExamPaperRepository {

	@Override
	public List<Paper> listPapers(LocalDateTime currentTime, Integer year, Semester semester) {
		List<Paper> papersList = new ArrayList<>();
		
		Paper paper = new Paper();
		paper.setId(new Integer(1));
		paper.setSubjectName("SSADM");
		paper.setStartTime(LocalDateTime.of(2016, 12, 07, 10, 30));
		paper.setEndTime(LocalDateTime.of(2016, 12, 07, 12, 30));
		paper.setExaminerRef("APT/EXAM-DPT/10");
		paper.setExamHall("Main Hall");
		papersList.add(paper);
		
		paper = new Paper();
		paper.setId(new Integer(2));
		paper.setSubjectName("RDBMS");
		paper.setStartTime(LocalDateTime.of(2016, 12, 07, 13, 30));
		paper.setEndTime(LocalDateTime.of(2016, 12, 07, 15, 30));
		paper.setExaminerRef("APT/EXAM-DPT/11");
		paper.setExamHall("Math Dpt Building");
		papersList.add(paper);
		
		paper = new Paper();
		paper.setId(new Integer(3));
		paper.setSubjectName("LOGIC");
		paper.setStartTime(LocalDateTime.of(2016, 12, 07, 16, 30));
		paper.setEndTime(LocalDateTime.of(2016, 12, 07, 17, 30));
		paper.setExaminerRef("APT/EXAM-DPT/10");
		paper.setExamHall("IT Dpt Hall2");
		papersList.add(paper);
		
		return papersList;
	}

	@Override
	public Boolean createPapers(LocalDateTime currentTime, Paper paper) {
		return Boolean.TRUE;
	}

}
