package com.example.datphong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datphong.domain.Voucher;
@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long>{
	Voucher findByMaVoucher(String maVoucher);

}
