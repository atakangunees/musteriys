package com.course.musteriys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course.musteriys.model.Musteri;


public interface MusteriService {

	List<Musteri> sayfala(int pageNo, int pageSize);
}
