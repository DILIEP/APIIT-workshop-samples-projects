package com.exam.paper;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doGet()................ request");
		
		List<Paper> papersList = examPaper.listPapers(LocalDateTime.now(), 2016, Semester.FIRST);

		StringBuilder sb = new StringBuilder();
		sb.append("<html><body>");
		sb.append("<table border=\"1\">");
		sb.append("<tr><th>Subject</th><th>Start Time</th><th>End Time</th><th>Examnor</th><th>Location</th></tr>");

		papersList.forEach((paper) -> sb.append("<tr><td>" + paper.getSubjectName() + "</td>" + "<td>"
				+ paper.getStartTime() + "</td>" + "<td>" + paper.getEndTime() + "</td>" + "<td>"
				+ paper.getExaminerRef() + "</td>" + "<td>" + paper.getExamHall() + "</td></tr>"));

		sb.append("</table>");
		sb.append("</body></html>");

		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
