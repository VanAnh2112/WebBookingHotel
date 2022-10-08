package com.example.datphong.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiKhachSanModel implements Serializable{
	
	private Long Id;
	@NotEmpty
	@Length(min = 5)
	private String ten;
	@NotBlank
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
