package com.example.datphong.controller.site;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.datphong.domain.KhachSan;
import com.example.datphong.domain.LoaiKhachSan;
import com.example.datphong.domain.Phong;
import com.example.datphong.domain.ThanhPho;
import com.example.datphong.domain.Voucher;
import com.example.datphong.model.DatPhongModel;
import com.example.datphong.model.KhachSanModel;
import com.example.datphong.model.PhongModel;
import com.example.datphong.service.DatPhongService;
import com.example.datphong.service.KhachSanService;
import com.example.datphong.service.LoaiKhachSanService;
import com.example.datphong.service.PhongService;
import com.example.datphong.service.ThanhPhoService;
import com.example.datphong.service.VoucherService;


@Controller
@RequestMapping("listKS")
public class SiteKhachSanController {

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
	

	@GetMapping("{khachSanId}")
	public ModelAndView hotel(ModelMap model, @PathVariable("khachSanId") Long Id) {

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);
		
		List<Phong> listPhong = phongService.findAll();
		model.addAttribute("Phong", listPhong);
		System.out.println(listPhong);
		
		Optional<KhachSan> opt = khachSanService.findById(Id);
		KhachSanModel dto = new KhachSanModel();
		if (opt.isPresent()) {
			KhachSan entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			model.addAttribute("khachSan", dto);
			return new ModelAndView("site/single", model);
		}
		model.addAttribute("message", "Khách sạn không tồn tại !");

		return new ModelAndView("site/single", model);
	}

	@RequestMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);

		List<LoaiKhachSan> listLoai = loaiKhachSanService.findAll();
		model.addAttribute("LoaiKhachSan", listLoai);

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(6);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));

		Page<KhachSan> resultPage = null;

		resultPage = khachSanService.findAll(pageable);
		int totalPage = resultPage.getTotalPages();
		if (totalPage > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPage);

			if (totalPage > 6) {
				if (end == totalPage)
					start = end - 6;
				else if (start == 1)
					end = start + 6;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

			model.addAttribute("pageNumbers", pageNumbers);

		}

		model.addAttribute("khachSanPage", resultPage);

		return "site/listKS";

	}

	@GetMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);

		List<LoaiKhachSan> listLoai = loaiKhachSanService.findAll();
		model.addAttribute("LoaiKhachSan", listLoai);

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<KhachSan> resultPage = null;

		if (StringUtils.hasText(ten)) {
			resultPage = khachSanService.findByTenContaining(ten, pageable);
			model.addAttribute("ten", ten);
		} else {
			resultPage = khachSanService.findAll(pageable);

		}

		int totalPage = resultPage.getTotalPages();
		if (totalPage > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPage);

			if (totalPage > 5) {
				if (end == totalPage)
					start = end - 5;
				else if (start == 1)
					end = start + 5;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

			model.addAttribute("pageNumbers", pageNumbers);

		}

		model.addAttribute("khachSanPage", resultPage);

		return "site/listKS";
	}


	@GetMapping("searchLoaiKhachSan/{loaiKhachSan}")
	public String searchLoaiKhachSan(ModelMap model, @PathVariable("loaiKhachSan") String loaiKhachSan,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);

		List<LoaiKhachSan> listLoai = loaiKhachSanService.findAll();
		model.addAttribute("LoaiKhachSan", listLoai);

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<KhachSan> resultPage = null;

		if (StringUtils.hasText(loaiKhachSan)) {
			resultPage = khachSanService.findByLoaiKhachSan(loaiKhachSan, pageable);
			model.addAttribute("loaiKhachSan", loaiKhachSan);
		} else {
			resultPage = khachSanService.findAll(pageable);

		}

		int totalPage = resultPage.getTotalPages();
		if (totalPage > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPage);

			if (totalPage > 5) {
				if (end == totalPage)
					start = end - 5;
				else if (start == 1)
					end = start + 5;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

			model.addAttribute("pageNumbers", pageNumbers);

		}

		model.addAttribute("khachSanPage", resultPage);

		return "site/listKS";
	}
	
	@GetMapping("searchThanhPho/{thanhPho}")
	public String searchThanhPho(ModelMap model, @PathVariable("thanhPho") String thanhPho,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);

		List<LoaiKhachSan> listLoai = loaiKhachSanService.findAll();
		model.addAttribute("LoaiKhachSan", listLoai);

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<KhachSan> resultPage = null;

		if (StringUtils.hasText(thanhPho)) {
			resultPage = khachSanService.findByThanhPho(thanhPho, pageable);
			model.addAttribute("thanhPho", thanhPho);
		} else {
			resultPage = khachSanService.findAll(pageable);

		}

		int totalPage = resultPage.getTotalPages();
		if (totalPage > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPage);

			if (totalPage > 5) {
				if (end == totalPage)
					start = end - 5;
				else if (start == 1)
					end = start + 5;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

			model.addAttribute("pageNumbers", pageNumbers);

		}

		model.addAttribute("khachSanPage", resultPage);

		return "site/listKS";
	}

	@ModelAttribute(name = "loaiKhachSan")
	public List<LoaiKhachSan> getAllLoaiKhachSan() {
		return loaiKhachSanService.findAll();
	}

	@ModelAttribute(name = "thanhPho")
	public List<ThanhPho> getAllThanhPho() {
		return thanhPhoService.findAll();
	}

	@GetMapping("searchDanhGia/{danhGia}")
	public String searchDanhGia(ModelMap model, @PathVariable("danhGia") int danhGia,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);

		List<LoaiKhachSan> listLoai = loaiKhachSanService.findAll();
		model.addAttribute("LoaiKhachSan", listLoai);

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<KhachSan> resultPage = null;

//		if (Integer.hashCode(danhGia)) {
			resultPage = khachSanService.findByDanhGia(danhGia, pageable);
			model.addAttribute("danhGia", danhGia);
//		} else {
//			resultPage = khachSanService.findAll(pageable);
//
//		}

		int totalPage = resultPage.getTotalPages();
		if (totalPage > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPage);

			if (totalPage > 5) {
				if (end == totalPage)
					start = end - 5;
				else if (start == 1)
					end = start + 5;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

			model.addAttribute("pageNumbers", pageNumbers);
			

		}

		model.addAttribute("khachSanPage", resultPage);

		return "site/listKS";
	}
	

	
	
	
		
}
