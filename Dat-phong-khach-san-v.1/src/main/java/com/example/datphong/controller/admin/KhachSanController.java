package com.example.datphong.controller.admin;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
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
import com.example.datphong.model.KhachSanModel;
import com.example.datphong.model.LoaiKhachSanModel;
import com.example.datphong.service.KhachSanService;
import com.example.datphong.service.LoaiKhachSanService;
import com.example.datphong.service.ThanhPhoService;

@Controller
@RequestMapping("admin/KhachSan")

public class KhachSanController {

	@Autowired
	KhachSanService khachSanService;
	@Autowired
	LoaiKhachSanService loaiKhachSanService;
	
	@Autowired
	ThanhPhoService thanhPhoService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("khachSan", new KhachSanModel());
		return "admin/KhachSan/addOrEdit";
	}
	
	@GetMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("khachSan") KhachSanModel dto,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return new ModelAndView("admin/KhachSan/addOrEdit");
		}
		
		KhachSan entity = new KhachSan();
		BeanUtils.copyProperties(dto, entity);
		
		khachSanService.save(entity);

		model.addAttribute("message", "Khách sạn đã lưu !");

		return new ModelAndView("forward:/admin/KhachSan/", model);
	}


	@RequestMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));

		Page<KhachSan> resultPage = null;

		resultPage = khachSanService.findAll(pageable);
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

		return "admin/KhachSan/list";
	}

	@GetMapping("edit/{khachSanId}")
	public ModelAndView edit(ModelMap model, @PathVariable("khachSanId") Long Id) {

		Optional<KhachSan> opt = khachSanService.findById(Id);
		KhachSanModel dto = new KhachSanModel();
		if (opt.isPresent()) {
			KhachSan entity = opt.get();

			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);

			model.addAttribute("khachSan", dto);

			return new ModelAndView("admin/KhachSan/addOrEdit", model);
		}
		model.addAttribute("message", "Khách sạn không tồn tại !");

		return new ModelAndView("forward:/admin/LoaiKhachSan", model);

	}

	@GetMapping("delete/{khachSanId}")
	public ModelAndView delete(ModelMap model, @PathVariable("khachSanId") Long Id) {

		khachSanService.deleteById(Id);

		model.addAttribute("message", "Xóa khách sạn thành công");

		return new ModelAndView("forward:/admin/KhachSan", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten) {
		List<KhachSan> list = null;

		if (StringUtils.hasText(ten)) {
			list = khachSanService.findByTenContaining(ten);
		} else {
			list = khachSanService.findAll();

		}

		model.addAttribute("KhachSan", list);

		return "admin/KhachSan/search";
	}

	@GetMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

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

		return "admin/KhachSan/searchpaginated";
	}

	@ModelAttribute(name = "loaiKhachSan")
	public List<LoaiKhachSan> getAllLoaiKhachSan() {
		return loaiKhachSanService.findAll();
	}
	
	@ModelAttribute(name = "thanhPho")
	public List<ThanhPho> getAllThanhPho() {
		return thanhPhoService.findAll();
	}
}