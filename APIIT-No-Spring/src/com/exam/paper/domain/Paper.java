package com.exam.paper.domain;

import java.time.LocalDateTime;

public class Paper {

	private Integer id;
	
	private String subjectName;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private String examinerRef;

	private String examHall;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getExaminerRef() {
		return examinerRef;
	}

	public void setExaminerRef(String examinerRef) {
		this.examinerRef = examinerRef;
	}

	public String getExamHall() {
		return examHall;
	}

	public void setExamHall(String examHall) {
		this.examHall = examHall;
	}
}
