package belajar.spring.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import belajar.spring.mvc.entity.DaftarBuku;
import belajar.spring.mvc.entity.DaftarBukuResult;
import belajar.spring.mvc.service.DaftarBukuService;

@Controller
public class DaftarBukuController {

	@Autowired
	private DaftarBukuService daftarBukuService;
	
	@RequestMapping("form")
	public ModelAndView getForm(@ModelAttribute DaftarBuku daftarBuku) {
		return new ModelAndView("form");
	}
	
	@RequestMapping("register")
	public String registerUser(@ModelAttribute @Valid DaftarBuku daftarBuku,
			BindingResult errors, SessionStatus status) {
		
		if(errors.hasErrors()){
			return "/form";
		}
		
		daftarBukuService.saveOrUpdate(daftarBuku);
		status.setComplete();
		return "redirect:list";
	}
	
	@RequestMapping("editlink")
	public ModelAndView editUser(@RequestParam long id,@ModelAttribute DaftarBuku daftarBuku) {
		DaftarBuku daftarBukuObjectFound = daftarBukuService.getRowByID(id);
		return new ModelAndView("edit","daftarBukuObject",daftarBukuObjectFound);
	}
	
	@RequestMapping("list")
	public ModelAndView getList() {
		List<DaftarBuku> daftarBukuList = daftarBukuService.getAll();
		//return new ModelAndView("list","daftarBukuList",daftarBukuList);
		
		DaftarBukuResult resultSearch = new DaftarBukuResult();
		resultSearch.setDaftarBukuList(daftarBukuList);
		resultSearch.setSearchKey(null);
		
		return new ModelAndView("list","resultSearch",resultSearch);
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteUser(@ModelAttribute DaftarBuku daftarBuku){
		daftarBukuService.delete(daftarBuku);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("update")
	public ModelAndView updateUser(@ModelAttribute DaftarBuku daftarBuku) {	
		daftarBukuService.saveOrUpdate(daftarBuku);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("searching")
	public ModelAndView getSearchingByBookTitle(@ModelAttribute DaftarBukuResult resultSearch) {
		
		System.out.print(" >>> Search key : "+resultSearch.getSearchKey());
		List<DaftarBuku> daftarBukuList = daftarBukuService.getListBookSearch(resultSearch.getSearchKey());
		
		DaftarBukuResult resultSearchFound = new DaftarBukuResult();
		resultSearchFound.setDaftarBukuList(daftarBukuList);
		//resultSearchFound.setSearchKey(resultSearch.getSearchKey());
		
		return new ModelAndView("list","resultSearch",resultSearchFound);

	}
	
	
	@RequestMapping("/")
	public ModelAndView home() {		
		
		return new ModelAndView("redirect:list");
	}
}
