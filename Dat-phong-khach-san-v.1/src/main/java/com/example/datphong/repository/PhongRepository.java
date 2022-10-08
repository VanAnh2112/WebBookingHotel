package com.example.datphong.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.datphong.domain.Phong;


@Repository
public interface PhongRepository extends JpaRepository<Phong, Long> {
	List<Phong> findByTenContaining(String ten);

	Page<Phong> findByTenContaining(String ten, Pageable pageable);
//@Query( "SELECT t FROM Truyen t WHERE t.tentruyen LIKE %:keyword% ")
//	public List<Truyen> search(@Param("keyword") String keyword);
	@Query("SELECT p FROM Phong p WHERE p.Id = phongId")
	Phong findById1(@Param("phongId")Long phongId);
	
}
