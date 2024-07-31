package pack.entity;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
	// FetchType.EAGER : 즉시로딩  DEPT 사용중 EMP는 필요할때 즉시 로딩
	// FetchType.LAGY	:  DEPT 사용중 (EMP는 필요할 때 지연 로딩)  
	// 세션이 열려있는 동안 세션관리가 필요하며 LazyInitializationException 조치가 필요함
	
	
	@OneToMany(mappedBy = "dept",fetch = FetchType.EAGER)
	@Builder.Default // EMP 엔티티가 생성될 때 list를 초기화함.
	// builder : 생성자 인자를 메서드 체인을 통해 명시적으로 대입하여 생성자를 호출할수 있게 빌더 클래스를 생성
	private List<Emp> list = new ArrayList<Emp>();
	
}
