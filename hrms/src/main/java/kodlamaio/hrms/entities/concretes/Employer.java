package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
public class Employer extends User {

    @Column(name = "company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "website")
    @NotNull
    @NotBlank
    private String website;

    @Column(name = "phone_number")
    @NotNull
    @NotBlank
    private String phoneNumber;
}
