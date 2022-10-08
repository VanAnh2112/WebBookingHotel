package com.example.datphong.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.datphong.domain.DatPhong;

public interface DatPhongService {

	<S extends DatPhong> List<S> findAll(Example<S> example, Sort sort);

	<S extends DatPhong> List<S> findAll(Example<S> example);

	DatPhong getReferenceById(Integer id);

	DatPhong getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends DatPhong> entities);

	DatPhong getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	<S extends DatPhong, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(DatPhong entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	<S extends DatPhong> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<DatPhong> entities);

	<S extends DatPhong> long count(Example<S> example);

	void deleteInBatch(Iterable<DatPhong> entities);

	<S extends DatPhong> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends DatPhong> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends DatPhong> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void flush();

	<S extends DatPhong> List<S> saveAll(Iterable<S> entities);

	Optional<DatPhong> findById(Integer id);

	List<DatPhong> findAllById(Iterable<Integer> ids);

	List<DatPhong> findAll(Sort sort);

	Page<DatPhong> findAll(Pageable pageable);

	List<DatPhong> findAll();

	<S extends DatPhong> Optional<S> findOne(Example<S> example);

	<S extends DatPhong> S save(S entity);

}
