package main.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("ps_user")
public class User {

    @Id
    private UUID id;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

}
