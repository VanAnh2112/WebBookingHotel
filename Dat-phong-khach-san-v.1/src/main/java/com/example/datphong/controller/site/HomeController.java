package com.example.datphong.controller.site;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.datphong.domain.KhachSan;
import com.example.datphong.domain.LoaiKhachSan;
import com.example.datphong.domain.ThanhPho;
import com.example.datphong.model.KhachSanModel;
import com.example.datphong.model.LoaiKhachSanModel;
import com.example.datphong.model.ThanhPhoModel;
import com.example.datphong.service.KhachSanService;
import com.example.datphong.service.LoaiKhachSanService;
import com.example.datphong.service.ThanhPhoService;


@Controller
@RequestMapping(value= {"","site/","/"})
public class HomeController {
	
	@Autowired
	KhachSanService khachSanService;

	@Autowired
	LoaiKhachSanService loaiKhachSanService;
	
	@Autowired
	ThanhPhoService thanhPhoService;

	
	@GetMapping("")
	public String home(Model model) {
		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);
		
		List<LoaiKhachSan> listLoai = loaiKhachSanService.findAll();
		model.addAttribute("LoaiKhachSan", listLoai);
		
		return "site/index";
	}
	
	@GetMapping("/{khachSanId}")
	public ModelAndView hotel(ModelMap model,@PathVariable("khachSanId") Long Id) {
		
		khachSanService.findById(Id);
//		model.addAttribute("message", "Xóa khách sạn thành công");
		
		return new ModelAndView("site/single", model);
	}
	@GetMapping("/formDat")
	public String formDat() {
		return "site/formdat";
	}

	
	@GetMapping("search")
	public String search(ModelMap model,
			@RequestParam(name="ThanhPho",required = false) String ThanhPho,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		List<KhachSan> list = khachSanService.findAll();
		model.addAttribute("KhachSan", list);

		List<ThanhPho> listThanhPho = thanhPhoService.findAll();
		model.addAttribute("ThanhPho", listThanhPho);
		
		List<LoaiKhachSan> listLoai = loaiKhachSanService.findAll();
		model.addAttribute("LoaiKhachSan", listLoai);
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(6);
		
		Pageable pageable = PageRequest.of(currentPage -1 , pageSize,Sort.by("ten"));
		Page<KhachSan> resultPage = null;	

		if(StringUtils.hasText(ThanhPho)) {
			resultPage=khachSanService.findByThanhPhoContaining(ThanhPho,pageable);
			model.addAttribute("ThanhPho",ThanhPho);
		}
		else {
			resultPage = khachSanService.findAll(pageable);
					
		}
		
		int totalPage = resultPage.getTotalPages();
		if(totalPage >0) {
			int start = Math.max(1,currentPage-2);
			int end = Math.min(currentPage+2, totalPage);
			
			if(totalPage>6) {
				if(end==totalPage) start =end -6;
				else if(start==1) end = start +6;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			
			model.addAttribute("pageNumbers", pageNumbers);
			
		}
	
		model.addAttribute("khachSanPage",resultPage);
		
		return  "site/listKS";
	}
	
	
	

}
