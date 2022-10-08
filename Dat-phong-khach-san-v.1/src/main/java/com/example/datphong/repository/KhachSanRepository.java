package com.example.datphong.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.datphong.domain.KhachSan;

@Repository
public interface KhachSanRepository extends JpaRepository<KhachSan, Long> {
	
	List<KhachSan> findByTenContaining(String ten);
	
	Page<KhachSan> findByTenContaining(String ten,Pageable pageable);
	
	Page<KhachSan> findByThanhPhoContaining(String thanhPho,Pageable pageable);
	
	Page<KhachSan> findByDanhGiaContaining(String danhGia,Pageable pageable);
	
	Page<KhachSan> findByLoaiKhachSanContaining(String loaiKhachSan,Pageable pageable);
	
	List<KhachSan> findByLoaiKhachSan(String loaiKhachSan);	
	
	Page<KhachSan> findByLoaiKhachSan(String loaiKhachSan,Pageable pageable);
	
	Page<KhachSan> findByThanhPho(String thanhPho,Pageable pageable);
	
	Page<KhachSan> findByDanhGia(Integer danhGia,Pageable pageable);
	
}
