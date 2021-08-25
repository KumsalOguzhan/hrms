package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
public class JobSeeker extends User {

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name = "tc_no", unique = true)
    @NotNull
    @NotBlank
    private String tcNo;

    @Column(name = "birth_of_date")
    @NotNull
    @NotBlank
    private Date birthOfDate;
}
