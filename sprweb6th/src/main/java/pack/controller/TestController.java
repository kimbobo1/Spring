package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("thymeleaf")
	public String sijak(Model model) {
		model.addAttribute("msg", "타임리프 만세");
		model.addAttribute("msg2", "대한독립 만세");
		
		// DTO 자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("삼다수");
		sangpum.setPrice("10000");
		model.addAttribute("sangpum", sangpum);
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		sangpum = new Sangpum();
		sangpum.setCode("20");
		sangpum.setSang("볶음밥");
		sangpum.setPrice("5000");
		list.add(sangpum);
		
		model.addAttribute("list", list);
		
		return "list1"; // foward임  templates로 들어감
		
	}
}
