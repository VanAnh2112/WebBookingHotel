package com.example.datphong.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.datphong.domain.TaiKhoan;
import com.example.datphong.repository.TaiKhoanRepository;
import com.example.datphong.service.TaiKhoanService;



@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public TaiKhoan login(String ten,String MatKhau) {
		Optional<TaiKhoan> optExist = findByTen(ten);
		
		if(optExist.isPresent()&& bCryptPasswordEncoder.matches(MatKhau,optExist.get().getMatKhau())) {
			optExist.get().setMatKhau("");
			return optExist.get();
		}
		return null;
	}

	@Override
	public Optional<TaiKhoan> findByTen(String ten) {
		
		return taiKhoanRepository.getByTen(ten);
	}


	@Override
	public List<TaiKhoan> findByTenContaining(String ten) {
		return taiKhoanRepository.findByTenContaining(ten);
	}

	@Override
	public Page<TaiKhoan> findByTenContaining(String ten, Pageable pageable) {
		return taiKhoanRepository.findByTenContaining(ten, pageable);
	}

	@Override
	public <S extends TaiKhoan> S save(S entity) {
		Optional<TaiKhoan> optExist = findByTen(entity.getTen());
		
		if(optExist.isPresent()) {
			if(StringUtils.isEmpty(entity.getMatKhau())) {
				entity.setMatKhau(optExist.get().getMatKhau());
			}
			else {
				entity.setMatKhau(bCryptPasswordEncoder.encode(entity.getMatKhau()));
			}
		}
		else {
			
			entity.setMatKhau(bCryptPasswordEncoder.encode(entity.getMatKhau()));
		}
		
		return taiKhoanRepository.save(entity);
	}

	@Override
	public List<TaiKhoan> findAll() {
		return taiKhoanRepository.findAll();
	}

	@Override
	public List<TaiKhoan> findAllById(Iterable<Long> ids) {
		return taiKhoanRepository.findAllById(ids);
	}

	@Override
	public Optional<TaiKhoan> findById(Long id) {
		return taiKhoanRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return taiKhoanRepository.existsById(id);
	}

	@Override
	public long count() {
		return taiKhoanRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		taiKhoanRepository.deleteById(id);
	}

	@Override
	public void delete(TaiKhoan entity) {
		taiKhoanRepository.delete(entity);
	}

	@Override
	public TaiKhoan getOne(Long id) {
		return taiKhoanRepository.getOne(id);
	}

	@Override
	public void deleteAll() {
		taiKhoanRepository.deleteAll();
	}

	@Override
	public TaiKhoan getById(Long id) {
		return taiKhoanRepository.getById(id);
	}

	@Override
	public Page<TaiKhoan> findAll(Pageable pageable) {
		return taiKhoanRepository.findAll(pageable);
	}

	@Override
	public List<TaiKhoan> findAll(Sort sort) {
		return taiKhoanRepository.findAll(sort);
	}
	
	
	
}
