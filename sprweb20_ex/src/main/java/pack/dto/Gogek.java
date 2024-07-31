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

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gogek")
public class Gogek {
	@Id
	@Column(name="gogek_no")
	private String gono;
	@Column(name="gogek_name")
	private String goname;
	@Column(name="gogek_tel")
	private Integer gotel;
}
