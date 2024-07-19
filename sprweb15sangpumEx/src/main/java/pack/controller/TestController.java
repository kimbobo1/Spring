package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;

import pack.model.Jikwon;

@Controller
public class TestController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/")
	public String main() {
		
		return "main";
	}
	
	@GetMapping("testjpa")
	public String list(Model model) {
		ArrayList<Jikwon> slist = (ArrayList<Jikwon>)dataDao.getDataAll();
		model.addAttribute("datas", slist);
		return "list";
	}
	@GetMapping("jik")
	public String getJikList(@RequestParam("jikwon") String jik,Model model) {
		ArrayList<Jikwon> list = (ArrayList<Jikwon>)dataDao.getDataSearch(jik);
		model.addAttribute("list",list);
		return "list";
	}
//	
//	@GetMapping("search")
//	public String searchList(FormBean bean, Model model) {
//		ArrayList<JIkwon> slist = (ArrayList<JIkwon>)dataDao.getDataSearch(bean.getSearchValue());
//		model.addAttribute("datas", slist);
//		return "list";
//	}
}
