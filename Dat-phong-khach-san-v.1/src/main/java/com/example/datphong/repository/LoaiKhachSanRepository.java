package com.example.datphong.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datphong.domain.LoaiKhachSan;

@Repository
public interface LoaiKhachSanRepository extends JpaRepository<LoaiKhachSan,Long> {

	List<LoaiKhachSan> findByTenContaining(String ten);
	
	Page<LoaiKhachSan> findByTenContaining(String ten,Pageable pageable);
	
}
