package planetaryAPI.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class APIUser {
    @Id
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private planetaryAPI.entities.user.APIUserRole role;
    private boolean enabled;
    private Timestamp created_at;
    private Timestamp updated_at;
}
