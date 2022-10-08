package com.example.datphong.controller.admin;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.datphong.domain.KhachSan;
import com.example.datphong.domain.LoaiKhachSan;
import com.example.datphong.domain.Phong;
import com.example.datphong.domain.ThanhPho;
import com.example.datphong.model.LoaiKhachSanModel;
import com.example.datphong.model.PhongModel;
import com.example.datphong.service.KhachSanService;
import com.example.datphong.service.PhongService;

@Controller
@RequestMapping("admin/Phong")
public class PhongController {

	@Autowired
	PhongService phongService;
	
	@Autowired
	KhachSanService khachSanService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("phong", new PhongModel());
		return "admin/Phong/add";
	}

	@RequestMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<Phong> resultPage = null;

		resultPage = phongService.findAll(pageable);

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

		model.addAttribute("phongPage", resultPage);

		return "admin/Phong/list";
	}

	@GetMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("phong") PhongModel dto,
			BindingResult result) {
		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		if (result.hasErrors()) {
			return new ModelAndView("admin/Phong/add");
		}

		Phong entity = new Phong();
		BeanUtils.copyProperties(dto, entity);

		phongService.save(entity);

		model.addAttribute("message", "Phòng lưu thành công  !");

		return new ModelAndView("forward:/admin/Phong", model);
	}

	@GetMapping("edit/{Id}")
	public ModelAndView edit(ModelMap model, @PathVariable("Id") Long Id) {

		Optional<Phong> opt = phongService.findById(Id);
		PhongModel dto = new PhongModel();
		if (opt.isPresent()) {
			Phong entity = opt.get();
			dto.setIsEdit(true);
			BeanUtils.copyProperties(entity, dto);

			model.addAttribute("phong", dto);

			return new ModelAndView("admin/Phong/add", model);
		}
		model.addAttribute("message", "Phòng không tồn tại");

		return new ModelAndView("forward:/admin/Phong", model);

	}

	@GetMapping("delete/{Id}")
	public ModelAndView delete(ModelMap model, @PathVariable("Id") Long Id) {

		phongService.deleteById(Id);

		model.addAttribute("message", "Xóa phòng thành công");

		return new ModelAndView("forward:/admin/Phong", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten) {
		List<Phong> list = null;

		if (StringUtils.hasText(ten)) {
			list = phongService.findByTenContaining(ten);
		} else {
			list = phongService.findAll();

		}

		model.addAttribute("Phong", list);

		return "admin/Phong/search";
	}

	@GetMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<Phong> resultPage = null;

		if (StringUtils.hasText(ten)) {
			resultPage = phongService.findByTenContaining(ten, pageable);
			model.addAttribute("ten", ten);
		} else {
			resultPage = phongService.findAll(pageable);

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

		model.addAttribute("phongPage", resultPage);

		return "admin/Phong/searchpaginated";
	}
	
	@ModelAttribute(name = "khachSan")
	public List<KhachSan> getAllKhachSan() {
		return khachSanService.findAll();
	}
}
