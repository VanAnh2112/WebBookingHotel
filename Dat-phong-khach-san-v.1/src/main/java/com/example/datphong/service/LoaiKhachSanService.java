package com.example.datphong.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.datphong.domain.LoaiKhachSan;

public interface LoaiKhachSanService {

	void delete(LoaiKhachSan entity);

	void deleteAll();

	boolean existsById(Long id);

	List<LoaiKhachSan> findAll();

	List<LoaiKhachSan> findAll(Sort sort);

	Optional<LoaiKhachSan> findById(Long id);

	<S extends LoaiKhachSan> S save(S entity);

	<S extends LoaiKhachSan> List<S> saveAll(Iterable<S> entities);

	<S extends LoaiKhachSan> S saveAndFlush(S entity);

	List<LoaiKhachSan> findByTenContaining(String ten);

	void deleteById(Long Id);

	Page<LoaiKhachSan> findByTenContaining(String ten, Pageable pageable);

	Page<LoaiKhachSan> findAll(Pageable pageable);


}
