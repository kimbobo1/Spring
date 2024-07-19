package pack.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/submit")
	public String submitForm(String name, int age, Model model) {
		String age1 = (Integer)age;
		String message = name + "님은 " + ageGroup;
		model.addAttribute("message", message);
		return "result";
	}
}
