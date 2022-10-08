package com.example.datphong.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.datphong.domain.ThanhPho;
import com.example.datphong.repository.ThanhPhoRepository;
import com.example.datphong.service.ThanhPhoService;
@Service
public class ThanhPhoServiceImpl implements ThanhPhoService {

	@Autowired
	ThanhPhoRepository thanhPhoRepository ;

	@Override
	public <S extends ThanhPho> S save(S entity) {
		return thanhPhoRepository.save(entity);
	}

	@Override
	public <S extends ThanhPho> Optional<S> findOne(Example<S> example) {
		return thanhPhoRepository.findOne(example);
	}

	@Override
	public List<ThanhPho> findAll() {
		return thanhPhoRepository.findAll();
	}

	@Override
	public Page<ThanhPho> findAll(Pageable pageable) {
		return thanhPhoRepository.findAll(pageable);
	}

	@Override
	public List<ThanhPho> findAll(Sort sort) {
		return thanhPhoRepository.findAll(sort);
	}

	@Override
	public List<ThanhPho> findAllById(Iterable<Long> ids) {
		return thanhPhoRepository.findAllById(ids);
	}

	@Override
	public Optional<ThanhPho> findById(Long id) {
		return thanhPhoRepository.findById(id);
	}

	@Override
	public <S extends ThanhPho> List<S> saveAll(Iterable<S> entities) {
		return thanhPhoRepository.saveAll(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return thanhPhoRepository.existsById(id);
	}

	@Override
	public long count() {
		return thanhPhoRepository.count();
	}

	@Override
	public <S extends ThanhPho> boolean exists(Example<S> example) {
		return thanhPhoRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		thanhPhoRepository.deleteById(id);
	}

	@Override
	public void delete(ThanhPho entity) {
		thanhPhoRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		thanhPhoRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll() {
		thanhPhoRepository.deleteAll();
	}

	@Override
	public ThanhPho getById(Long id) {
		return thanhPhoRepository.getById(id);
	}

	@Override
	public List<ThanhPho> findByTenContaining(String ten) {
		return thanhPhoRepository.findByTenContaining(ten);
	}

	@Override
	public Page<ThanhPho> findByTenContaining(String ten, Pageable pageable) {
		return thanhPhoRepository.findByTenContaining(ten, pageable);
	}
}
