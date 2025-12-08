package planetaryAPI.dtos.user;

import planetaryAPI.entities.user.APIUserRole;

import java.sql.Timestamp;

public record APIUserDTO(
        String name,
        String password,
        APIUserRole type,
        boolean enabled,
        Timestamp createdAt,
        Timestamp updatedAt
) {}
