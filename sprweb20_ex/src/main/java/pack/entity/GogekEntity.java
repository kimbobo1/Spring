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
public class GogekEntity {
	@Id
	@Column(name="gogek_no")
	private String gono;
	@Column(name="gogek_name")
	private String goname;
	@Column(name="gogek_tel")
	private Integer gotel;
}
