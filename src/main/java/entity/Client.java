package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Client")
@Data

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 200)
    private String name;
}
