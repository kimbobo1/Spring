package pack.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Buser {

    @Id
    @Column(name="buser_no")
    private int bno;

    @Column(name="buser_name")
    private String bname;

    @Column(name="buser_tel")
    private String btel;

    @OneToMany(mappedBy = "buser")  // 하나의 부서는 여러개의 직원을 가질수있다
    private List<Jikwon> jikwonList;
}
