package com.example.datphong.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.datphong.domain.Phong;

public interface PhongService {

	Phong getById(Long id);

	void deleteAll();

	void delete(Phong entity);

	void deleteById(Long id);

	long count();

	<S extends Phong> List<S> saveAll(Iterable<S> entities);

	Optional<Phong> findById(Long id);

	List<Phong> findAll(Sort sort);

	Page<Phong> findAll(Pageable pageable);

	List<Phong> findAll();

	<S extends Phong> S save(S entity);

	Page<Phong> findByTenContaining(String ten, Pageable pageable);

	List<Phong> findByTenContaining(String ten);
	Phong findById1(Long id);
	

}
