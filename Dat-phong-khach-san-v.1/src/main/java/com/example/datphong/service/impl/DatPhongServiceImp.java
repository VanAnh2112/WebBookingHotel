package com.example.datphong.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.datphong.domain.DatPhong;
import com.example.datphong.repository.DatPhongRepository;
import com.example.datphong.service.DatPhongService;
@Service
public class DatPhongServiceImp implements 	DatPhongService{
	@Autowired
	DatPhongRepository datphongrepo;

	@Override
	public <S extends DatPhong> S save(S entity) {
		return datphongrepo.save(entity);
	}

	@Override
	public <S extends DatPhong> Optional<S> findOne(Example<S> example) {
		return datphongrepo.findOne(example);
	}

	@Override
	public List<DatPhong> findAll() {
		return datphongrepo.findAll();
	}

	@Override
	public Page<DatPhong> findAll(Pageable pageable) {
		return datphongrepo.findAll(pageable);
	}

	@Override
	public List<DatPhong> findAll(Sort sort) {
		return datphongrepo.findAll(sort);
	}

	@Override
	public List<DatPhong> findAllById(Iterable<Integer> ids) {
		return datphongrepo.findAllById(ids);
	}

	@Override
	public Optional<DatPhong> findById(Integer id) {
		return datphongrepo.findById(id);
	}

	@Override
	public <S extends DatPhong> List<S> saveAll(Iterable<S> entities) {
		return datphongrepo.saveAll(entities);
	}

	@Override
	public void flush() {
		datphongrepo.flush();
	}

	@Override
	public boolean existsById(Integer id) {
		return datphongrepo.existsById(id);
	}

	@Override
	public <S extends DatPhong> S saveAndFlush(S entity) {
		return datphongrepo.saveAndFlush(entity);
	}

	@Override
	public <S extends DatPhong> List<S> saveAllAndFlush(Iterable<S> entities) {
		return datphongrepo.saveAllAndFlush(entities);
	}

	@Override
	public <S extends DatPhong> Page<S> findAll(Example<S> example, Pageable pageable) {
		return datphongrepo.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<DatPhong> entities) {
		datphongrepo.deleteInBatch(entities);
	}

	@Override
	public <S extends DatPhong> long count(Example<S> example) {
		return datphongrepo.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<DatPhong> entities) {
		datphongrepo.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return datphongrepo.count();
	}

	@Override
	public <S extends DatPhong> boolean exists(Example<S> example) {
		return datphongrepo.exists(example);
	}

	@Override
	public void deleteById(Integer id) {
		datphongrepo.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		datphongrepo.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(DatPhong entity) {
		datphongrepo.delete(entity);
	}

	@Override
	public <S extends DatPhong, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return datphongrepo.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		datphongrepo.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		datphongrepo.deleteAllInBatch();
	}

	@Override
	public DatPhong getOne(Integer id) {
		return datphongrepo.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends DatPhong> entities) {
		datphongrepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		datphongrepo.deleteAll();
	}

	@Override
	public DatPhong getById(Integer id) {
		return datphongrepo.getById(id);
	}

	@Override
	public DatPhong getReferenceById(Integer id) {
		return datphongrepo.getReferenceById(id);
	}

	@Override
	public <S extends DatPhong> List<S> findAll(Example<S> example) {
		return datphongrepo.findAll(example);
	}

	@Override
	public <S extends DatPhong> List<S> findAll(Example<S> example, Sort sort) {
		return datphongrepo.findAll(example, sort);
	}
	

}
