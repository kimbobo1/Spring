package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "buser")
public class Buser {

    @Id
    @Column(name = "buser_no")
    private int no;

    @Column(name = "buser_name")
    private String name;
    
}
