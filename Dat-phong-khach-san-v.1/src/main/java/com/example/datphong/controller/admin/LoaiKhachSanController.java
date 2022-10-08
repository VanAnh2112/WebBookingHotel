package com.example.datphong.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.datphong.domain.LoaiKhachSan;
import com.example.datphong.model.LoaiKhachSanModel;
import com.example.datphong.service.LoaiKhachSanService;
import com.example.datphong.utils.FileUploadUtil;

@Controller
@RequestMapping("admin/LoaiKhachSan")

public class LoaiKhachSanController {

	@Autowired
	LoaiKhachSanService loaiKhachSanService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("loaiKhachSan", new LoaiKhachSanModel());
		return "admin/LoaiKhachSan/add";
	}

	@GetMapping("edit/{Id}")
	public ModelAndView edit(ModelMap model, @PathVariable("Id") Long Id) {

		Optional<LoaiKhachSan> opt = loaiKhachSanService.findById(Id);
		LoaiKhachSanModel dto = new LoaiKhachSanModel();
		if (opt.isPresent()) {
			LoaiKhachSan entity = opt.get();
			dto.setIsEdit(true);
			BeanUtils.copyProperties(entity, dto);

			model.addAttribute("loaiKhachSan", dto);

			return new ModelAndView("admin/LoaiKhachSan/add", model);
		}
		model.addAttribute("message", "Loại khách sạn không tồn tại");

		return new ModelAndView("forward:/admin/LoaiKhachSan", model);

	}

	@GetMapping("delete/{Id}")
	public ModelAndView delete(ModelMap model, @PathVariable("Id") Long Id) {

		loaiKhachSanService.deleteById(Id);

		model.addAttribute("message", "Xóa loại khách sạn thành công");

		return new ModelAndView("forward:/admin/LoaiKhachSan", model);
	}

	@GetMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("loaiKhachSan") LoaiKhachSanModel dto,
			BindingResult result) {
		System.out.println(dto);

		if (result.hasErrors()) {
			return new ModelAndView("admin/LoaiKhachSan/add");
		}

		LoaiKhachSan entity = new LoaiKhachSan();
		BeanUtils.copyProperties(dto, entity);

		loaiKhachSanService.save(entity);

		model.addAttribute("message", "Loại khách sạn đã lưu !");

		return new ModelAndView("forward:/admin/LoaiKhachSan", model);
	}

	@RequestMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<LoaiKhachSan> resultPage = null;
		
		resultPage = loaiKhachSanService.findAll(pageable);


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

		model.addAttribute("loaiKhachSanPage", resultPage);

		return "admin/LoaiKhachSan/list";
	
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten) {
		List<LoaiKhachSan> list = null;

		if (StringUtils.hasText(ten)) {
			list = loaiKhachSanService.findByTenContaining(ten);
		} else {
			list = loaiKhachSanService.findAll();

		}

		model.addAttribute("LoaiKhachSan", list);

		return "admin/LoaiKhachSan/search";
	}

	@GetMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<LoaiKhachSan> resultPage = null;

		if (StringUtils.hasText(ten)) {
			resultPage = loaiKhachSanService.findByTenContaining(ten, pageable);
			model.addAttribute("ten", ten);
		} else {
			resultPage = loaiKhachSanService.findAll(pageable);

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

		model.addAttribute("loaiKhachSanPage", resultPage);

		return "admin/LoaiKhachSan/searchpaginated";
	}
}
