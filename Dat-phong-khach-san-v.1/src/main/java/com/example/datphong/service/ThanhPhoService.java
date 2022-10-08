package com.example.datphong.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.datphong.domain.ThanhPho;

public interface ThanhPhoService {

	ThanhPho getById(Long id);

	void deleteAll();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(ThanhPho entity);

	void deleteById(Long id);

	<S extends ThanhPho> boolean exists(Example<S> example);

	long count();

	boolean existsById(Long id);

	<S extends ThanhPho> List<S> saveAll(Iterable<S> entities);

	Optional<ThanhPho> findById(Long id);

	List<ThanhPho> findAllById(Iterable<Long> ids);

	List<ThanhPho> findAll(Sort sort);

	Page<ThanhPho> findAll(Pageable pageable);

	List<ThanhPho> findAll();

	<S extends ThanhPho> Optional<S> findOne(Example<S> example);

	<S extends ThanhPho> S save(S entity);

	Page<ThanhPho> findByTenContaining(String ten, Pageable pageable);

	List<ThanhPho> findByTenContaining(String ten);

}
