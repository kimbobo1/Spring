package pack.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.JikwonEntity;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jikwon")
public class Jikwon {
	@Id
	@Column(name= "jikwon_no")
	private String jikno;
	
	@Column(name= "jikwon_name")
	private String irum;
	@Column(name="jikwon_jik")
	private String jik;
	
	public static Jikwon toDto(JikwonEntity entity) {
		return Jikwon.builder()
				.jikno(entity.getJikno())
				.irum(entity.getIrum())
				.jik(entity.getJik())
				.build();
	}
}
