package com.exam.paper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.paper.domain.Paper;
import com.exam.paper.enums.Semester;
import com.exam.paper.service.ExamPaper;

@Controller
public class ExamPaperController {

	@Autowired
	private ExamPaper examPaper;
	
	@RequestMapping(value = "/exampaper",method = RequestMethod.GET)
	public String doGet(Model model) throws ServletException, IOException {
		
		System.out.println("doGet()................ request");
		
		List<Paper> listOfPapers = examPaper.listPapers(LocalDateTime.now(), 2016, Semester.FIRST);
		model.addAttribute("papersList", listOfPapers);
		
		return "papersList";
	}
}
