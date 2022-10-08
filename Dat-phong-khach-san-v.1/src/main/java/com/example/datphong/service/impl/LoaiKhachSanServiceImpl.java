package com.example.datphong.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.datphong.domain.LoaiKhachSan;
import com.example.datphong.repository.LoaiKhachSanRepository;
import com.example.datphong.service.LoaiKhachSanService;
@Service
public class LoaiKhachSanServiceImpl implements LoaiKhachSanService{
	LoaiKhachSanRepository loaiKhachSanRepository;

	public LoaiKhachSanServiceImpl(LoaiKhachSanRepository loaiKhachSanRepository) {
		this.loaiKhachSanRepository = loaiKhachSanRepository;
	}
	
	
	
	@Override
	public List<LoaiKhachSan> findByTenContaining(String ten) {
		return loaiKhachSanRepository.findByTenContaining(ten);
	}

	@Override
	public void delete(LoaiKhachSan entity) {
		loaiKhachSanRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		loaiKhachSanRepository.deleteAll();
	}

	@Override
	public boolean existsById(Long id) {
		return loaiKhachSanRepository.existsById(id);
	}

	@Override
	public List<LoaiKhachSan> findAll() {
		return loaiKhachSanRepository.findAll();
	}

	@Override
	public void deleteById(Long Id) {
		loaiKhachSanRepository.deleteById(Id);
	}



	@Override
	public List<LoaiKhachSan> findAll(Sort sort) {
		return loaiKhachSanRepository.findAll(sort);
	}

	@Override
	public Optional<LoaiKhachSan> findById(Long id) {
		return loaiKhachSanRepository.findById(id);
	}

	@Override
	public <S extends LoaiKhachSan> S save(S entity) {
		return loaiKhachSanRepository.save(entity);
	}

	@Override
	public <S extends LoaiKhachSan> List<S> saveAll(Iterable<S> entities) {
		return loaiKhachSanRepository.saveAll(entities);
	}

	@Override
	public <S extends LoaiKhachSan> S saveAndFlush(S entity) {
		return loaiKhachSanRepository.saveAndFlush(entity);
	}



	@Override
	public Page<LoaiKhachSan> findByTenContaining(String ten, Pageable pageable) {
		return loaiKhachSanRepository.findByTenContaining(ten, pageable);
	}



	@Override
	public Page<LoaiKhachSan> findAll(Pageable pageable) {
		return loaiKhachSanRepository.findAll(pageable);
	}
	
	
	
	
	
	
}
