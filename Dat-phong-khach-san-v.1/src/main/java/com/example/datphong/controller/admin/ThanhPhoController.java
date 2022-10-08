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
import com.example.datphong.domain.ThanhPho;
import com.example.datphong.model.ThanhPhoModel;
import com.example.datphong.service.ThanhPhoService;

@Controller
@RequestMapping("admin/ThanhPho")
public class ThanhPhoController {
	@Autowired
	ThanhPhoService thanhPhoService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("thanhPho", new ThanhPhoModel());
		return "admin/ThanhPho/add";
	}

	@RequestMapping("")
	public String list(ModelMap model,@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<ThanhPho> resultPage = null;
		
		resultPage = thanhPhoService.findAll(pageable);
		
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

		model.addAttribute("thanhPhoPage", resultPage);

		return "admin/ThanhPho/list";
	}

	@GetMapping("edit/{Id}")
	public ModelAndView edit(ModelMap model, @PathVariable("Id") Long Id) {

		Optional<ThanhPho> opt = thanhPhoService.findById(Id);
		ThanhPhoModel dto = new ThanhPhoModel();
		if (opt.isPresent()) {
			ThanhPho entity = opt.get();
			dto.setIsEdit(true);
			BeanUtils.copyProperties(entity, dto);

			model.addAttribute("thanhPho", dto);

			return new ModelAndView("admin/ThanhPho/add", model);
		}
		model.addAttribute("message", "Thành phố không tồn tại");

		return new ModelAndView("forward:/admin/ThanhPho", model);

	}

	@GetMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("thanhPho") ThanhPhoModel dto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("admin/ThanhPho/add");
		}

		ThanhPho entity = new ThanhPho();
		BeanUtils.copyProperties(dto, entity);

		thanhPhoService.save(entity);

		model.addAttribute("message", "Thành phố đã lưu !");

		return new ModelAndView("forward:/admin/ThanhPho", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten) {
		List<ThanhPho> list = null;

		if (StringUtils.hasText(ten)) {
			list = thanhPhoService.findByTenContaining(ten);
		} else {
			list = thanhPhoService.findAll();

		}

		model.addAttribute("ThanhPho", list);

		return "admin/ThanhPho/search";
	}

	@GetMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "ten", required = false) String ten,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("ten"));
		Page<ThanhPho> resultPage = null;

		if (StringUtils.hasText(ten)) {
			resultPage = thanhPhoService.findByTenContaining(ten, pageable);
			model.addAttribute("ten", ten);
		} else {
			resultPage = thanhPhoService.findAll(pageable);

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

		model.addAttribute("thanhPhoPage", resultPage);

		return "admin/ThanhPho/searchpaginated";
	}

	@GetMapping("delete/{Id}")
	public ModelAndView delete(ModelMap model, @PathVariable("Id") Long Id) {

		thanhPhoService.deleteById(Id);

		model.addAttribute("message", "Xóa thành phố thành công");

		return new ModelAndView("forward:/admin/ThanhPho", model);
	}

}
