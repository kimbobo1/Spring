package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jikwon")
public class Jikwon {

    @Id
    @Column(name = "jikwon_no")
    private int no;

    @Column(name = "jikwon_name")
    private String name;

    @Column(name = "jikwon_jik")
    private String jikwonJik;

    @ManyToOne
    @JoinColumn(name = "buser_num") // `jikwon` 테이블의 외래 키 컬럼
    private Buser buser;

    @Column(name = "jikwon_pay")
    private int pay;
}
