package pack;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class ProductVo {  //PRODUCT_VO  Table을 안만들면 
	@Id //pk라서 id 
	private Integer code;
	private String sang;
	private Integer su;
	private Integer dan;
}
