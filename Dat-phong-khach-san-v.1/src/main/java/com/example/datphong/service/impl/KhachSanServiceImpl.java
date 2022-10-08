package com.example.datphong.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.datphong.domain.KhachSan;
import com.example.datphong.domain.LoaiKhachSan;
import com.example.datphong.repository.KhachSanRepository;
import com.example.datphong.service.KhachSanService;
@Service
public class KhachSanServiceImpl implements KhachSanService{
	@Autowired
	private KhachSanRepository khachSanRepository;

	@Override
	public <S extends KhachSan> S save(S entity) {
		return khachSanRepository.save(entity);
	}

	@Override
	public List<KhachSan> findAll() {
		return khachSanRepository.findAll();
	}

	@Override
	public Page<KhachSan> findAll(Pageable pageable) {
		return khachSanRepository.findAll(pageable);
	}

	@Override
	public List<KhachSan> findAll(Sort sort) {
		return khachSanRepository.findAll(sort);
	}

	@Override
	public List<KhachSan> findAllById(Iterable<Long> ids) {
		return khachSanRepository.findAllById(ids);
	}

	@Override
	public Optional<KhachSan> findById(Long id) {
		return khachSanRepository.findById(id);
	}

	@Override
	public <S extends KhachSan> List<S> saveAll(Iterable<S> entities) {
		return khachSanRepository.saveAll(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return khachSanRepository.existsById(id);
	}

	@Override
	public <S extends KhachSan> boolean exists(Example<S> example) {
		return khachSanRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		khachSanRepository.deleteById(id);
	}

	@Override
	public void delete(KhachSan entity) {
		khachSanRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		khachSanRepository.deleteAll();
	}

	@Override
	public KhachSan getById(Long id) {
		return khachSanRepository.getById(id);
	}

	@Override
	public KhachSan getReferenceById(Long id) {
		return khachSanRepository.getReferenceById(id);
	}
	
	@Override
	public Page<KhachSan> findByTenContaining(String ten, Pageable pageable) {
		return khachSanRepository.findByTenContaining(ten, pageable);
	}

	@Override
	public List<KhachSan> findByTenContaining(String ten) {
		return khachSanRepository.findByTenContaining(ten);
	}

	@Override
	public Page<KhachSan> findByThanhPhoContaining(String thanhPho, Pageable pageable) {
		return khachSanRepository.findByThanhPhoContaining(thanhPho, pageable);
	}

	@Override
	public Page<KhachSan> findByDanhGiaContaining(String danhGia, Pageable pageable) {
		return khachSanRepository.findByDanhGiaContaining(danhGia, pageable);
	}

	@Override
	public Page<KhachSan> findByLoaiKhachSanContaining(String loaiKhachSan, Pageable pageable) {
		return khachSanRepository.findByLoaiKhachSanContaining(loaiKhachSan, pageable);
	}

	@Override
	public List<KhachSan> findByLoaiKhachSan(String loaiKhachSan) {
		return khachSanRepository.findByLoaiKhachSan(loaiKhachSan);
	}

	@Override
	public Page<KhachSan> findByLoaiKhachSan(String loaiKhachSan, Pageable pageable) {
		return khachSanRepository.findByLoaiKhachSan(loaiKhachSan, pageable);
	}

	@Override
	public Page<KhachSan> findByThanhPho(String thanhPho, Pageable pageable) {
		return khachSanRepository.findByThanhPho(thanhPho, pageable);
	}

	@Override
	public Page<KhachSan> findByDanhGia(Integer danhGia, Pageable pageable) {
		return khachSanRepository.findByDanhGia(danhGia, pageable);
	}
	
	
	
	
	
	
	
	
}
