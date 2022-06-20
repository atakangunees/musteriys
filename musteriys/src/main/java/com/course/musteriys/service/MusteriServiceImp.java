package com.course.musteriys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.course.musteriys.model.Musteri;
import com.course.musteriys.repository.MusteriRepository;

@Service
public class MusteriServiceImp implements MusteriService{

	@Autowired
	private MusteriRepository repository;
	
	@Override
	public List<Musteri> sayfala(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Musteri> pagedResult = repository.findAll(paging);
		
		return pagedResult.toList();
	}

}
