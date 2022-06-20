package com.course.musteriys.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.course.musteriys.model.Musteri;

public interface MusteriRepository extends PagingAndSortingRepository<Musteri, Long> {

	

	Iterable<Musteri> findAll(Sort sort);
}
