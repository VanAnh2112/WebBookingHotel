package com.example.datphong.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhongModel {

	private Long Id;
	@NotEmpty
	@Length(min = 5)
	private String ten;
	@Min(value = 1)
	private int DienTich;
	@Min(value = 1)
	private int GiaThue;
	private String TienNghi;
	@NotEmpty
	private String MoTa;
	private int LoaiGiuong;
	private int idKhachSan;
	@NotEmpty
	private String KhachSan;
	
	private Boolean isEdit = false;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getDienTich() {
		return DienTich;
	}

	public void setDienTich(int dienTich) {
		DienTich = dienTich;
	}

	public int getGiaThue() {
		return GiaThue;
	}

	public void setGiaThue(int giaThue) {
		GiaThue = giaThue;
	}

	public String getTienNghi() {
		return TienNghi;
	}

	public void setTienNghi(String tienNghi) {
		TienNghi = tienNghi;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public int getLoaiGiuong() {
		return LoaiGiuong;
	}

	public void setLoaiGiuong(int loaiGiuong) {
		LoaiGiuong = loaiGiuong;
	}

	public int getIdKhachSan() {
		return idKhachSan;
	}

	public void setIdKhachSan(int idKhachSan) {
		this.idKhachSan = idKhachSan;
	}

	public String getKhachSan() {
		return KhachSan;
	}

	public void setKhachSan(String khachSan) {
		KhachSan = khachSan;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	@Override
	public String toString() {
		return "PhongModel [Id=" + Id + ", ten=" + ten + ", DienTich=" + DienTich + ", GiaThue=" + GiaThue
				+ ", TienNghi=" + TienNghi + ", MoTa=" + MoTa + ", LoaiGiuong=" + LoaiGiuong + ", idKhachSan="
				+ idKhachSan + ", KhachSan=" + KhachSan + ", isEdit=" + isEdit + "]";
	}
	
	
}
