package es.jmberea.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.jmberea.service.DummyService;
import es.jmberea.vo.DummyVO;
import exception.ServiceException;

@Controller
public class DummyController {

	private static final Logger logger = LogManager.getLogger(DummyController.class);

	@Autowired
	private DummyService dummyService;

	@RequestMapping(value = "/")
	public String homeHandler(HttpServletRequest request) throws ServiceException {
		MDC.put("sessionId", request.getSession().getId());
		List<DummyVO> list = dummyService.getAll();
		// DummyVO vo = dummyService.getById(null);
		logger.info("ELEMENTOS: " + list.size());
		return "dummy";
	}
}
