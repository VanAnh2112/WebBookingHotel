package com.example.datphong.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datphong.domain.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
	List<TaiKhoan> findByTenContaining(String ten);

	Page<TaiKhoan> findByTenContaining(String ten, Pageable pageable);

	Optional<TaiKhoan> getByTen(String ten);
}
