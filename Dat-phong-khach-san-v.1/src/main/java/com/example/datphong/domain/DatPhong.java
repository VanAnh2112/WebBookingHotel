package com.example.datphong.domain;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DatPhong")
public class DatPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "TaiKhoan", columnDefinition = "nvarchar(50) not null")
	private String TaiKhoan;
	@Column(name = "sdt", columnDefinition = "nvarchar(50) not null")
	private int sdt;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phongId")
	private Phong phong;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date NgayDat;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Column(name = "ngayden", nullable = false)
	private LocalDate NgayDen;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Column(name = "ngaytra", nullable = false)
	private LocalDate NgayTra;
	@Column(name = "GhiChu", columnDefinition = "nvarchar(200) not null")
	private String GhiChu;
	@Column(nullable = false)
	private int ThanhTien;
	@Column(nullable = false)
	private boolean DaHuy;
	@Column(nullable = false)
	private boolean ThanhToan;
	@NotNull
	public String CheckIn;
	

	
	

	public DatPhong(int id, String taiKhoan, int sdt, Phong phong, Date ngayDat, @NotNull LocalDate ngayDen,
			@NotNull LocalDate ngayTra, String ghiChu, int thanhTien, boolean daHuy, boolean thanhToan,
			String checkIn) {
		super();
		Id = id;
		TaiKhoan = taiKhoan;
		this.sdt = sdt;
		this.phong = phong;
		NgayDat = ngayDat;
		NgayDen = ngayDen;
		NgayTra = ngayTra;
		GhiChu = ghiChu;
		ThanhTien = thanhTien;
		DaHuy = daHuy;
		ThanhToan = thanhToan;
		CheckIn = checkIn;
	}
	

	public String getCheckIn() {
		return CheckIn;
	}


	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}


	public DatPhong() {
		super();
	}
	
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public boolean isThanhToan() {
		return ThanhToan;
	}
	public void setThanhToan(boolean thanhToan) {
		ThanhToan = thanhToan;
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
	
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		
		this.phong = phong;
	}
	public Date getNgayDat() {
		return NgayDat;
	}
	public void setNgayDat(Date ngayDat) {
		NgayDat = ngayDat;
	}
	public LocalDate getNgayDen() {
		return NgayDen;
	}
	public void setNgayDen(LocalDate ngayDen) {
		NgayDen = ngayDen;
	}
	public LocalDate getNgayTra() {
		return NgayTra;
	}
	public void setNgayTra(LocalDate ngayTra) {
		NgayTra = ngayTra;
	}
	
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public int getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(int thanhTien) {
		//if(voucher == null){}
		//else{ thanh tien = voucher.giatri* thanh tien 
		ThanhTien = thanhTien;
	}
	public boolean isDaHuy() {
		return DaHuy;
	}
	public void setDaHuy(boolean daHuy) {
		DaHuy = daHuy;
	}

	@Override
	public String toString() {
		return "DatPhong [Id=" + Id + ", TaiKhoan=" + TaiKhoan + ", sdt=" + sdt + ", phong=" + phong + ", NgayDat="
				+ NgayDat + ", NgayDen=" + NgayDen + ", NgayTra=" + NgayTra + ", GhiChu=" + GhiChu + ", ThanhTien="
				+ ThanhTien + ", DaHuy=" + DaHuy + ", ThanhToan=" + ThanhToan + "]";
	}
	
//	@ManyToOne
//	@JoinColumn(name = "IdPhong")
//	private Phong phong;
//	
//	@ManyToOne
//	@JoinColumn(name = "IdTaiKhoan")
//	private TaiKhoan tai_khoan;
	

}
