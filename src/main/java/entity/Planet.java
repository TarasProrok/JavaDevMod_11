package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.intellij.lang.annotations.Pattern;

@Entity
@Table(name = "Planet")
@Data
public class Planet {
    @Id
    @Column(name = "id", length = 10)
    @Pattern("^[A-Z0-9]+$")
    private String id;
    @Column(name = "name", length = 500)
    private String name;

}
