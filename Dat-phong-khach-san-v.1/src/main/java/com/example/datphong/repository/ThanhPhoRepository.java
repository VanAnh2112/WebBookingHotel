package com.example.datphong.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datphong.domain.ThanhPho;
@Repository
public interface ThanhPhoRepository extends JpaRepository<ThanhPho, Long> {
	List<ThanhPho> findByTenContaining(String ten);

	Page<ThanhPho> findByTenContaining(String ten, Pageable pageable);

}
