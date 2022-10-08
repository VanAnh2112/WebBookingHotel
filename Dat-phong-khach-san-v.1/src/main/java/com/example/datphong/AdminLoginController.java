package com.example.datphong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.datphong.domain.TaiKhoan;
import com.example.datphong.model.AdminLoginModel;
import com.example.datphong.service.TaiKhoanService;

@Controller
public class AdminLoginController {
	
	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@Autowired 
	private HttpSession session;
	
	@GetMapping("alogin")
	public String login(ModelMap model) {
		model.addAttribute("taiKhoan",new AdminLoginModel());
		return "/admin/TaiKhoan/login";
	}
	@PostMapping("alogin")
	public ModelAndView login(ModelMap model, @Valid @ModelAttribute("taiKhoan") AdminLoginModel dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/admin/TaiKhoan/login",model);
		}
		TaiKhoan taiKhoan = taiKhoanService.login(dto.getTen(), dto.getMatKhau());
		
		if(taiKhoan == null) {
			model.addAttribute("message","Tài khoản hoặc mật khẩu không đúng");
			return new ModelAndView("/admin/TaiKhoan/login",model);  
		}
		session.setAttribute("ten",taiKhoan.getTen());

		
		Object ruri = session.getAttribute("redirect-uri");
		
		if(ruri!=null) {
			session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:" + ruri);
		}
		return new ModelAndView("forward:/admin/KhachSan", model);
		
	}
	
	@RequestMapping("logout")
    public String logout(HttpServletRequest request,ModelMap model ) {
        System.out.println("logout()");
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        model.addAttribute("taiKhoan",new AdminLoginModel());
        return "/admin/TaiKhoan/login";
	}
	
	
}
