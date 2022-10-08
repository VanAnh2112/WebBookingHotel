package com.example.datphong.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatPhongModel {
	int Id;
	String TaiKhoan;
	int sdt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date ngayDat;
	String ngayDen;
	String ngayTra;
	Long phongId ;
	String ghichu;
	boolean DaHuy;
	boolean thanhtoan;
	String maVoucher;
	String checkIn;
	
	public DatPhongModel() {
		super();
	}

	public DatPhongModel(int id, String taiKhoan, int sdt, Date ngayDat, String ngayDen, String ngayTra, Long phongId,
			String ghichu, boolean daHuy, boolean thanhtoan, String maVoucher, String checkIn) {
		super();
		Id = id;
		TaiKhoan = taiKhoan;
		this.sdt = sdt;
		this.ngayDat = ngayDat;
		this.ngayDen = ngayDen;
		this.ngayTra = ngayTra;
		this.phongId = phongId;
		this.ghichu = ghichu;
		DaHuy = daHuy;
		this.thanhtoan = thanhtoan;
		this.maVoucher = maVoucher;
		this.checkIn = checkIn;
	}

	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getMaVoucher() {
		return maVoucher;
	}
	public void setMaVoucher(String maVoucher) {
		this.maVoucher = maVoucher;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	public Long getPhongId() {
		return phongId;
	}
	public void setPhongId(Long phongId) {
		this.phongId = phongId;
	}
	public boolean isThanhtoan() {
		return thanhtoan;
	}
	public void setThanhtoan(boolean thanhtoan) {
		this.thanhtoan = thanhtoan;
	}
	public boolean isDaHuy() {
		return DaHuy;
	}
	public void setDaHuy(boolean daHuy) {
		DaHuy = daHuy;
	}
	public String getTenNguoiDat() {
		return TaiKhoan;
	}
	public void setTenNguoiDat(String TaiKhoan) {
		this.TaiKhoan = TaiKhoan;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(String ngayDen) {
		this.ngayDen = ngayDen;
	}
	public String getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}
	public Long getPhongdat() {
		return phongId;
	}
	public void setPhongdat(Long phongId) {
		this.phongId = phongId;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "DatPhongModel [TaiKhoan=" + TaiKhoan + ", sdt=" + sdt + ", ngayDat=" + ngayDat + ", ngayDen=" + ngayDen
				+ ", ngayTra=" + ngayTra + ", phongdat=" + phongId + ", ghichu=" + ghichu +", voucher=" + maVoucher + ", DaHuy=" + DaHuy + "]";
	}
	
	
	
	

}
