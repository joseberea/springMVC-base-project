package es.jmberea.service;

import java.util.List;

import org.springframework.stereotype.Component;

import es.jmberea.vo.DummyVO;

@Component("dummyService")
public interface DummyService {
	public List<DummyVO> getAll() throws Exception;
}
