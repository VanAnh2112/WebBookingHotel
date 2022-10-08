package com.example.datphong.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "TenTaiKhoan", length = 50)
	private String ten;
	@Column(name = "MatKhau", columnDefinition = "nvarchar(255) not null")
	private String MatKhau;
	@Column(name = "HoTen", length = 50, columnDefinition = "nvarchar(50) not null")
	private String HoTen;
	@Column(name = "GioiTinh",columnDefinition = "nvarchar(50) not null")
	private String GioiTinh;
	@Column(name = "SoDienThoai", length = 15, columnDefinition = "nvarchar(15) not null")
	private String SoDienThoai;
	@Column(name = "Email", length = 50, columnDefinition = "nvarchar(50) not null")
	private String Email;
	@Column(name = "IsAdmin", nullable = false)
	private boolean IsAdmin;
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
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public boolean isIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		IsAdmin = isAdmin;
	}
	
	
	
//	@OneToMany(mappedBy = "tai_khoan",cascade = CascadeType.ALL)
//	private Set<DatPhong> dsDatPhong;

}
