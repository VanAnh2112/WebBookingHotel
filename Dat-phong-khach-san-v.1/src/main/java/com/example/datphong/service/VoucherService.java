package com.example.datphong.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.datphong.domain.Voucher;

public interface VoucherService {

	<S extends Voucher> List<S> findAll(Example<S> example, Sort sort);

	<S extends Voucher> List<S> findAll(Example<S> example);

	Voucher getReferenceById(Long id);

	Voucher getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Voucher> entities);

	Voucher getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Voucher, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Voucher entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Voucher> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Voucher> entities);

	<S extends Voucher> long count(Example<S> example);

	void deleteInBatch(Iterable<Voucher> entities);

	<S extends Voucher> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Voucher> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Voucher> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Voucher> List<S> saveAll(Iterable<S> entities);

	Optional<Voucher> findById(Long id);

	List<Voucher> findAllById(Iterable<Long> ids);

	List<Voucher> findAll(Sort sort);

	Page<Voucher> findAll(Pageable pageable);

	List<Voucher> findAll();

	<S extends Voucher> Optional<S> findOne(Example<S> example);

	Voucher findByMaVoucher(String maVoucher);

	<S extends Voucher> S save(S entity);

}
