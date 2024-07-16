package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.MemberDao;

@Controller
public class InsertController {
	@Autowired
	private MemberDao memberDao;
	

	@GetMapping("insert")
	public String form() {
		
		return "insform";
	}
	
	@PostMapping("insert")
	public String submit(MemberBean bean) {
		memberDao.insData(bean);
		return "redirect:/list";// 바로 list를 부르고 옛날 내용이 보임 redirect:를 해줘야 추가후 목록보기가 됨
	}
	
}
