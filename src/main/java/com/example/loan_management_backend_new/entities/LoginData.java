package com.example.loan_management_backend_new.entities;
        import java.time.LocalDate;

        import jakarta.validation.constraints.*;
        import jakarta.persistence.Column;
        import jakarta.persistence.Entity;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.Id;
        import jakarta.persistence.Table;
        import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="LoginData")
@Getter
@Setter


public class LoginData {

    @NotNull
    @Id
    private int username;

  @Column(nullable =false)
    private String roles="";

    @Column(nullable =false)
    private String password;
}