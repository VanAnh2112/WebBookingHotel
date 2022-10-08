package com.example.datphong.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.datphong.domain.Phong;
import com.example.datphong.repository.PhongRepository;
import com.example.datphong.service.PhongService;

@Service
public class PhongServiceImpl implements PhongService{
	
	@Autowired
	PhongRepository phongRepository;

	@Override
	public List<Phong> findByTenContaining(String ten) {
		return phongRepository.findByTenContaining(ten);
	}

	@Override
	public Page<Phong> findByTenContaining(String ten, Pageable pageable) {
		return phongRepository.findByTenContaining(ten, pageable);
	}

	@Override
	public <S extends Phong> S save(S entity) {
		return phongRepository.save(entity);
	}

	@Override
	public List<Phong> findAll() {
		return phongRepository.findAll();
	}

	@Override
	public Page<Phong> findAll(Pageable pageable) {
		return phongRepository.findAll(pageable);
	}

	@Override
	public List<Phong> findAll(Sort sort) {
		return phongRepository.findAll(sort);
	}

	@Override
	public Optional<Phong> findById(Long id) {
		return phongRepository.findById(id);
	}

	@Override
	public <S extends Phong> List<S> saveAll(Iterable<S> entities) {
		return phongRepository.saveAll(entities);
	}

	@Override
	public long count() {
		return phongRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		phongRepository.deleteById(id);
	}

	@Override
	public void delete(Phong entity) {
		phongRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		phongRepository.deleteAll();
	}

	@Override
	public Phong getById(Long id) {
		return phongRepository.findById(id).get();
	}

	@Override
	public Phong findById1(Long id) {
		// TODO Auto-generated method stub
		return phongRepository.findById1(id);
	}
	

	
	
}
