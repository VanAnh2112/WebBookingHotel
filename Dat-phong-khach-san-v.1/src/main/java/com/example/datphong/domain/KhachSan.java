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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KhachSan")
public class KhachSan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long khachSanId;
	@Column(name = "Ten", columnDefinition = "nvarchar(100) not null")
	private String ten;
	@Column(name = "DiaChi", columnDefinition = "nvarchar(100) not null")
	private String DiaChi;
	@Column(name = "SoDienThoai", columnDefinition = "nvarchar(15) not null")
	private String SoDienThoai;
	@Column(nullable = false)
	private int CachTrungTam;
	@Column(name = "MoTa", columnDefinition = "nvarchar(1000) not null")
	private String MoTa;
	@Column(name = "AnNinh", columnDefinition = "nvarchar(15) not null")
	private String AnNinh;
	@Column(nullable = false)
	private int danhGia;
	@Column(name = "BuaAn", columnDefinition = "nvarchar(15) not null")
	private String BuaAn;
	@Column(name="UrlHinhAnh" ,columnDefinition = "nvarchar(1000) not null")
	private String UrlHinhAnh;
	@Column(name="ThanhPho", columnDefinition = "nvarchar(100) not null")
	private String thanhPho;
	@Column(name ="LoaiKhachSan", columnDefinition = "nvarchar(100) not null")
	private String loaiKhachSan;
	public Long getKhachSanId() {
		return khachSanId;
	}
	public void setKhachSanId(Long khachSanId) {
		this.khachSanId = khachSanId;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public int getCachTrungTam() {
		return CachTrungTam;
	}
	public void setCachTrungTam(int cachTrungTam) {
		CachTrungTam = cachTrungTam;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getAnNinh() {
		return AnNinh;
	}
	public void setAnNinh(String anNinh) {
		AnNinh = anNinh;
	}
	public int getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}
	public String getBuaAn() {
		return BuaAn;
	}
	public void setBuaAn(String buaAn) {
		BuaAn = buaAn;
	}
	public String getUrlHinhAnh() {
		return UrlHinhAnh;
	}
	public void setUrlHinhAnh(String urlHinhAnh) {
		UrlHinhAnh = urlHinhAnh;
	}
	public String getThanhPho() {
		return thanhPho;
	}
	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
	public String getLoaiKhachSan() {
		return loaiKhachSan;
	}
	public void setLoaiKhachSan(String loaiKhachSan) {
		this.loaiKhachSan = loaiKhachSan;
	}
	
//	@ManyToOne
//	@JoinColumn(name="IdLoaiKhachSan")
//	private LoaiKhachSan loai_khach_san;
//	
//	@ManyToOne
//	@JoinColumn(name="IdThanhPho")
//	private ThanhPho thanh_pho;
//	
//	@OneToMany(mappedBy = "khach_san",cascade = CascadeType.ALL)
//	private Set<Phong> dsPhong;

}
