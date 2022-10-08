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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ThanhPho")
public class ThanhPho implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "Ten", columnDefinition = "nvarchar(100) not null")
	private String ten;
	@Column(name = "MoTa", columnDefinition = "nvarchar(200) not null")
	private String MoTa;
	@Column(name = "UrlHinhAnh", columnDefinition = "nvarchar(200) not null")
	private String UrlHinhAnh;
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
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getUrlHinhAnh() {
		return UrlHinhAnh;
	}
	public void setUrlHinhAnh(String urlHinhAnh) {
		UrlHinhAnh = urlHinhAnh;
	}
	
//	@OneToMany(mappedBy = "thanh_pho",cascade = CascadeType.ALL)
//	private Set<KhachSan> dsKhachSan;
	


}
