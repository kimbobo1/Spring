package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import pack.dto.Jikwon;
import pack.entity.JikwonEntity;
import pack.repository.JikwonRepository;

public class Impl implements JikwonService{
	@Autowired
	private JikwonRepository jikRepository;
	
	@Override
	public void getList(Model model) {
		List<JikwonEntity> entityList = jikRepository.findAll();
		List<Jikwon> list = new ArrayList<Jikwon>();
		
		for(JikwonEntity temp:entityList) {
			Jikwon dto = new Jikwon();
			dto.setJikno(temp.getJikno());
			dto.setIrum(temp.getIrum());
			dto.setJik(temp.getJik());
			list.add(dto);
		}
	}
}
