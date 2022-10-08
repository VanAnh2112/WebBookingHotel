package com.example.datphong.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Phong")
public class Phong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "Ten", columnDefinition = "nvarchar(100) not null")
	private String ten;
	@Column(name = "KhachSan", columnDefinition = "nvarchar(100) not null")
	private String KhachSan;
	@Column(nullable = false)
	private int DienTich;
	@Column(nullable = false)
	private int GiaThue;
	@Column(name = "TienNghi", columnDefinition = "nvarchar(200) not null")
	private String TienNghi;
	@Column(name = "MoTa", columnDefinition = "nvarchar(1000) not null")
	private String MoTa;
	@Column(nullable = false)
	private int LoaiGiuong;
	@Column(nullable = false)
	private int IdKhachSan;
	
	public Phong(Long id, String ten) {
		super();
		Id = id;
		this.ten = ten;
	}
	public Phong() {
		// TODO Auto-generated constructor stub
	}
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
	public String getKhachSan() {
		return KhachSan;
	}
	public void setKhachSan(String khachSan) {
		KhachSan = khachSan;
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
		return IdKhachSan;
	}
	public void setIdKhachSan(int idKhachSan) {
		IdKhachSan = idKhachSan;
	}
	@Override
	public String toString() {
		return "Phong [Id=" + Id + ", ten=" + ten + ", KhachSan=" + KhachSan + ", DienTich=" + DienTich + ", GiaThue="
				+ GiaThue + ", TienNghi=" + TienNghi + ", MoTa=" + MoTa + ", LoaiGiuong=" + LoaiGiuong + ", IdKhachSan="
				+ IdKhachSan + "]";
	}
	
	
	
//	@ManyToOne
//	@JoinColumn(name = "IdKhachSan")
//	private KhachSan khach_san;
//	
//	@OneToMany(mappedBy = "phong",cascade = CascadeType.ALL)
//	private Set<DatPhong> dsDatPhong;

}
