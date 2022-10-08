package com.example.datphong.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThanhPhoModel {
	private Long Id;
	@NotEmpty
	private String ten;
	@NotEmpty
	private String MoTa;
	private String UrlHinhAnh;
	
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

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	

}
