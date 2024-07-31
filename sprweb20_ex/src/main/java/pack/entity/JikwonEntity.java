package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JikwonEntity {
	@Id
	@Column(name= "jikwon_no")
	private String jikno;
	
	@Column(name= "jikwon_name")
	private String irum;
	@Column(name="jikwon_jik")
	private String jik;

}
