package com.example.datphong.controller.site;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.datphong.domain.Phong;
import com.example.datphong.domain.Voucher;
import com.example.datphong.model.DatPhongModel;
import com.example.datphong.service.DatPhongService;
import com.example.datphong.service.KhachSanService;
import com.example.datphong.service.LoaiKhachSanService;
import com.example.datphong.service.PhongService;
import com.example.datphong.service.ThanhPhoService;
import com.example.datphong.service.VoucherService;

@Controller
public class DatPhongController {
	@Autowired
	KhachSanService khachSanService;

	@Autowired
	LoaiKhachSanService loaiKhachSanService;

	@Autowired
	ThanhPhoService thanhPhoService;
	
	@Autowired
	PhongService phongService;
	@Autowired
	DatPhongService datPhongService;
	@Autowired
	VoucherService voucherService;
	@GetMapping("datphong/{id}")
	public String DatPhong(Model model, @PathVariable Long id ) {
		System.out.println(id);
		Phong phongdat = phongService.getById(id);		
		System.out.println(phongdat);		
		model.addAttribute("phongdat", phongdat);
		DatPhongModel datPhong = new DatPhongModel();
		datPhong.setPhongId(id);
		model.addAttribute("thongtin", datPhong);		
		return "site/formdat";
		
		
	}
	@GetMapping("formdatPhong")
	public String formdat() {
		return "site/formdat";
	}
	
	@PostMapping("datphongKS")
	public String add(ModelMap model,@ModelAttribute("thongtin")DatPhongModel datphong ) throws ParseException {
		System.out.println(datphong);
		com.example.datphong.domain.DatPhong datphong1 = null;
		long millis=System.currentTimeMillis();   
		java.sql.Date ngaydat=new java.sql.Date(millis);  		
		Phong phongdat = phongService.getById(datphong.getPhongId());
		SimpleDateFormat dateform = new SimpleDateFormat("YYYY-MM-dd");
		
		LocalDate ngayden = LocalDate.parse(datphong.getNgayDen(), DateTimeFormatter.ISO_DATE);
		LocalDate ngaydi = LocalDate.parse(datphong.getNgayTra(), DateTimeFormatter.ISO_DATE);
		int ngayden1 = ngayden.getDayOfMonth();
		int ngaydi1 = ngaydi.getDayOfMonth();
		int songay = ngaydi1-ngayden1;
		System.out.println(songay);
		int thanhtien = phongdat.getGiaThue() * (ngaydi1 - ngayden1);
		model.addAttribute("phongdat", phongdat);		
		System.out.println(datphong.getMaVoucher());
		model.addAttribute("tongtien", thanhtien );
		LocalDate ngaydat1 = LocalDate.now();
		
		if(datphong.getMaVoucher().isEmpty()) {
			datphong1 = new com.example.datphong.domain.DatPhong(datphong.getId(), datphong.getTaiKhoan(), datphong.getSdt(), new Phong(datphong.getPhongId(),""),
					ngaydat, ngayden, ngaydi, datphong.getGhichu(),thanhtien, false, false, datphong.getCheckIn());
			System.out.println(datphong1);
			datPhongService.save(datphong1);						
			model.addAttribute("songay", songay);
			model.addAttribute("datphong1",datphong1 );
			int voucher2 = 0;
			model.addAttribute("voucher",voucher2 );
			return "site/formthanhtoan";
		}
		Voucher voucher = voucherService.findByMaVoucher(datphong.getMaVoucher());
		if(voucher != null) {
			int TongTien = thanhtien - voucher.getGtri();
			datphong1 = new com.example.datphong.domain.DatPhong(datphong.getId(), datphong.getTaiKhoan(), datphong.getSdt(), new Phong(datphong.getPhongId(),""),
					ngaydat, ngayden, ngaydi, datphong.getGhichu(),TongTien, false, false, datphong.getCheckIn());
			System.out.println(datphong1);
			System.out.println(songay);
			model.addAttribute("songay", songay);
			model.addAttribute("datphong1",datphong1 );
			int voucher1 = voucher.getGtri();
			model.addAttribute("voucher", voucher1);
			datPhongService.save(datphong1);
			return "site/formthanhtoan";
		}
		else {
			model.addAttribute("error"," Mã Voucher sai hoặc không còn hiệu lực" );
			return "site/formdat";
			}
			
	}
	
	

}
