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

import com.example.datphong.domain.Voucher;
import com.example.datphong.repository.VoucherRepository;
import com.example.datphong.service.VoucherService;
@Service
public class VoucherServiceImp implements VoucherService{
	@Autowired
	VoucherRepository voucherRepo;

	@Override
	public <S extends Voucher> S save(S entity) {
		return voucherRepo.save(entity);
	}

	@Override
	public Voucher findByMaVoucher(String maVoucher) {
		return voucherRepo.findByMaVoucher(maVoucher);
	}

	@Override
	public <S extends Voucher> Optional<S> findOne(Example<S> example) {
		return voucherRepo.findOne(example);
	}

	@Override
	public List<Voucher> findAll() {
		return voucherRepo.findAll();
	}

	@Override
	public Page<Voucher> findAll(Pageable pageable) {
		return voucherRepo.findAll(pageable);
	}

	@Override
	public List<Voucher> findAll(Sort sort) {
		return voucherRepo.findAll(sort);
	}

	@Override
	public List<Voucher> findAllById(Iterable<Long> ids) {
		return voucherRepo.findAllById(ids);
	}

	@Override
	public Optional<Voucher> findById(Long id) {
		return voucherRepo.findById(id);
	}

	@Override
	public <S extends Voucher> List<S> saveAll(Iterable<S> entities) {
		return voucherRepo.saveAll(entities);
	}

	@Override
	public void flush() {
		voucherRepo.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return voucherRepo.existsById(id);
	}

	@Override
	public <S extends Voucher> S saveAndFlush(S entity) {
		return voucherRepo.saveAndFlush(entity);
	}

	@Override
	public <S extends Voucher> List<S> saveAllAndFlush(Iterable<S> entities) {
		return voucherRepo.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Voucher> Page<S> findAll(Example<S> example, Pageable pageable) {
		return voucherRepo.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Voucher> entities) {
		voucherRepo.deleteInBatch(entities);
	}

	@Override
	public <S extends Voucher> long count(Example<S> example) {
		return voucherRepo.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Voucher> entities) {
		voucherRepo.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return voucherRepo.count();
	}

	@Override
	public <S extends Voucher> boolean exists(Example<S> example) {
		return voucherRepo.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		voucherRepo.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		voucherRepo.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Voucher entity) {
		voucherRepo.delete(entity);
	}

	@Override
	public <S extends Voucher, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return voucherRepo.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		voucherRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		voucherRepo.deleteAllInBatch();
	}

	@Override
	public Voucher getOne(Long id) {
		return voucherRepo.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Voucher> entities) {
		voucherRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		voucherRepo.deleteAll();
	}

	@Override
	public Voucher getById(Long id) {
		return voucherRepo.getById(id);
	}

	@Override
	public Voucher getReferenceById(Long id) {
		return voucherRepo.getReferenceById(id);
	}

	@Override
	public <S extends Voucher> List<S> findAll(Example<S> example) {
		return voucherRepo.findAll(example);
	}

	@Override
	public <S extends Voucher> List<S> findAll(Example<S> example, Sort sort) {
		return voucherRepo.findAll(example, sort);
	}
	

}
