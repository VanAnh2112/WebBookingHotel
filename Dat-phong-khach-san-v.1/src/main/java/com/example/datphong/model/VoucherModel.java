package com.example.datphong.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherModel {
	
	private Long Id;
	@NotEmpty
	private String maVoucher;
	@NotEmpty
	private double gtri;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getMaVoucher() {
		return maVoucher;
	}
	public void setMaVoucher(String maVoucher) {
		this.maVoucher = maVoucher;
	}
	public double getGtri() {
		return gtri;
	}
	public void setGtri(double gtri) {
		this.gtri = gtri;
	}
	

}
