package com.example.datphong.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import com.example.datphong.domain.KhachSan;

public interface KhachSanService {

	KhachSan getReferenceById(Long id);

	KhachSan getById(Long id);

	void deleteAll();

	void delete(KhachSan entity);

	void deleteById(Long id);

	<S extends KhachSan> boolean exists(Example<S> example);

	boolean existsById(Long id);

	<S extends KhachSan> List<S> saveAll(Iterable<S> entities);

	Optional<KhachSan> findById(Long id);
	
	List<KhachSan> findAllById(Iterable<Long> ids);

	List<KhachSan> findAll(Sort sort);

	Page<KhachSan> findAll(Pageable pageable);

	List<KhachSan> findAll();

	<S extends KhachSan> S save(S entity);

	Page<KhachSan> findByTenContaining(String ten, Pageable pageable);

	List<KhachSan> findByTenContaining(String ten);

	Page<KhachSan> findByThanhPhoContaining(String thanhPho, Pageable pageable);

	Page<KhachSan> findByDanhGiaContaining(String danhGia, Pageable pageable);

	Page<KhachSan> findByLoaiKhachSanContaining(String loaiKhachSan, Pageable pageable);

	List<KhachSan> findByLoaiKhachSan(String loaiKhachSan);

	Page<KhachSan> findByLoaiKhachSan(String loaiKhachSan, Pageable pageable);

	Page<KhachSan> findByThanhPho(String thanhPho, Pageable pageable);

	Page<KhachSan> findByDanhGia(Integer danhGia, Pageable pageable);
	
	



}
