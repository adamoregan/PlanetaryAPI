package planetaryAPI.dtos.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import planetaryAPI.entities.user.APIUserRole;

public record UserCreateDTO(
        @NotEmpty
        @NotNull
        @Column(unique=true)
        String name,
        @NotEmpty
        @NotNull
        String password,
        @NotNull
        APIUserRole type,
        @NotNull
        boolean enabled
) {
}