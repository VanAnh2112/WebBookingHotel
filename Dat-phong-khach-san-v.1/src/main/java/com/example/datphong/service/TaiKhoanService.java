package com.example.datphong.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.datphong.domain.TaiKhoan;

public interface TaiKhoanService {

	TaiKhoan getById(Long id);

	void deleteAll();

	TaiKhoan getOne(Long id);

	void delete(TaiKhoan entity);

	void deleteById(Long id);

	long count();

	boolean existsById(Long id);

	Optional<TaiKhoan> findById(Long id);

	List<TaiKhoan> findAllById(Iterable<Long> ids);

	List<TaiKhoan> findAll();

	<S extends TaiKhoan> S save(S entity);

	Page<TaiKhoan> findByTenContaining(String ten, Pageable pageable);

	List<TaiKhoan> findByTenContaining(String ten);

	List<TaiKhoan> findAll(Sort sort);

	Page<TaiKhoan> findAll(Pageable pageable);

	Optional<TaiKhoan> findByTen(String ten);

	TaiKhoan login(String ten, String matKhau);

}
