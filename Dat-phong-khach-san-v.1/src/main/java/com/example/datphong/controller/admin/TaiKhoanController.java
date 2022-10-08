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

import com.example.datphong.domain.LoaiKhachSan;
import com.example.datphong.domain.Phong;
import com.example.datphong.domain.TaiKhoan;
import com.example.datphong.model.LoaiKhachSanModel;
import com.example.datphong.model.TaiKhoanModel;
import com.example.datphong.service.TaiKhoanService;

@Controller
@RequestMapping("admin/TaiKhoan")
public class TaiKhoanController {
	@Autowired
	TaiKhoanService taiKhoanService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("taiKhoan", new TaiKhoanModel());
		return "admin/TaiKhoan/add";
	}

	@RequestMapping("")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<TaiKhoan> resultPage = null;
		
		resultPage = taiKhoanService.findAll(pageable);
		
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

		model.addAttribute("taiKhoanPage", resultPage);


		return "admin/TaiKhoan/list";
	}

	@GetMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("taiKhoan") TaiKhoanModel dto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("admin/TaiKhoan/add");
		}

		TaiKhoan entity = new TaiKhoan();
		BeanUtils.copyProperties(dto, entity);

		taiKhoanService.save(entity);

		model.addAttribute("message", "Tài khoản đã lưu !");

		return new ModelAndView("forward:/admin/TaiKhoan", model);
	}

	@GetMapping("edit/{Id}")
	public ModelAndView edit(ModelMap model, @PathVariable("Id") Long Id) {

		Optional<TaiKhoan> opt = taiKhoanService.findById(Id);
		TaiKhoanModel dto = new TaiKhoanModel();
		if (opt.isPresent()) {
			TaiKhoan entity = opt.get();
			dto.setIsEdit(true);
			dto.setMatKhau("");
			BeanUtils.copyProperties(entity, dto);

			model.addAttribute("taiKhoan", dto);

			return new ModelAndView("admin/TaiKhoan/add", model);
		}
		model.addAttribute("message", "Tài khoản không tồn tại");

		return new ModelAndView("forward:/admin/TaiKhoan", model);

	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten) {
		List<TaiKhoan> list = null;

		if (StringUtils.hasText(ten)) {
			list = taiKhoanService.findByTenContaining(ten);
		} else {
			list = taiKhoanService.findAll();

		}

		model.addAttribute("TaiKhoan", list);

		return "admin/TaiKhoan/search";
	}

	@GetMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<TaiKhoan> resultPage = null;

		if (StringUtils.hasText(ten)) {
			resultPage = taiKhoanService.findByTenContaining(ten, pageable);
			model.addAttribute("ten", ten);
		} else {
			resultPage = taiKhoanService.findAll(pageable);

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

		model.addAttribute("taiKhoanPage", resultPage);

		return "admin/TaiKhoan/searchpaginated";
	}

	@GetMapping("delete/{Id}")
	public ModelAndView delete(ModelMap model, @PathVariable("Id") Long Id) {
		
		taiKhoanService.deleteById(Id);

		model.addAttribute("message", "Xóa tài khoản thành công");
		return new ModelAndView("forward:/admin/TaiKhoan", model);
	}
}
