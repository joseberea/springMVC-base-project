package es.jmberea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.jmberea.service.DummyService;
import es.jmberea.vo.DummyVO;

@Controller
public class DummyController {
	
	@Autowired
	private DummyService dummyService;
	
	@RequestMapping(value="/")
	public String homeHandler() throws Exception {
		List<DummyVO> list = dummyService.getAll();
		System.out.println("ELEMENTOS: " + list.size());
		return "dummy";
	}
}
