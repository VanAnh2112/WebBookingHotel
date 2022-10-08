package com.example.datphong.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachSanModel implements Serializable {

	private Long khachSanId;
	@NotEmpty
	@Length(min = 5)
	private String ten;
	@NotEmpty
	private String DiaChi;
	@Pattern(regexp = "\\d{10}")
	private String SoDienThoai;
	private int CachTrungTam;
	@NotBlank
	private String MoTa;
	private String AnNinh;
	private int danhGia;
	private String BuaAn;
	private String UrlHinhAnh;
	private Long IdThanhPho;
	private String ThanhPho;
	private Long IdLoaiKhachSan;
	private String loaiKhachSan;
	private Boolean isEdit = false;
	
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
	public Long getIdThanhPho() {
		return IdThanhPho;
	}
	public void setIdThanhPho(Long idThanhPho) {
		IdThanhPho = idThanhPho;
	}
	public String getThanhPho() {
		return ThanhPho;
	}
	public void setThanhPho(String thanhPho) {
		ThanhPho = thanhPho;
	}
	public Long getIdLoaiKhachSan() {
		return IdLoaiKhachSan;
	}
	public void setIdLoaiKhachSan(Long idLoaiKhachSan) {
		IdLoaiKhachSan = idLoaiKhachSan;
	}
	public String getLoaiKhachSan() {
		return loaiKhachSan;
	}
	public void setLoaiKhachSan(String loaiKhachSan) {
		this.loaiKhachSan = loaiKhachSan;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	

}
