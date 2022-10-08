package com.example.datphong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datphong.domain.DatPhong;
@Repository
public interface DatPhongRepository extends JpaRepository<DatPhong, Integer>{

}
