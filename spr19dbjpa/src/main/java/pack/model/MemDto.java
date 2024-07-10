package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity  // DB의 특정 테이블과 매핑
@Table(name="mem")
public class MemDto {
	//카멜 표기법으로 쓰면 MemDto >>Mem_Dto 으로 자동으로 바뀐다
	// 카멜 케이스로 작성하면 자동으로 언더스코어 네이밍 컨벤션을 따름
	
	@Id //pk칼럼에 붙인다
	@Column(name="num") // DB랑 이름이 다를경우 <<이걸 쓴다
	private int num;
	@Column(name="name", nullable = true) //null을 허용   false 을하면 not null
	private String name;
	
	private String addr;
	
	
	
}
