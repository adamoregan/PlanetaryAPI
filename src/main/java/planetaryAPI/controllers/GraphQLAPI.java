package planetaryAPI.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import planetaryAPI.dtos.planet.PlanetDTO;
import planetaryAPI.dtos.user.APIUserDTO;
import planetaryAPI.dtos.user.UserCreateDTO;
import planetaryAPI.services.planet.PlanetService;
import planetaryAPI.services.user.APIUserService;
import org.springframework.security.access.prepost.PreAuthorize;


@Controller
@AllArgsConstructor
public class GraphQLAPI {
    private APIUserService APIUserService;
    private PlanetService planetService;

    @PreAuthorize("hasRole(T(planetaryAPI.entities.user.APIUserRole).ADMIN)")
    @QueryMapping
    public APIUserDTO findUserByName(@Argument String name) {
        return APIUserService.findUserByName(name);
    }

    @PreAuthorize("hasRole(T(planetaryAPI.entities.user.APIUserRole).ADMIN)")
    @MutationMapping
    public APIUserDTO createUser(@Valid @Argument("user") UserCreateDTO userCreateDTO) {
        return APIUserService.createUser(userCreateDTO);
    }

    @PreAuthorize("hasAnyRole("
            + "T(planetaryAPI.entities.user.APIUserRole).ADMIN,"
            + "T(planetaryAPI.entities.user.APIUserRole).STAFF,"
            + "T(planetaryAPI.entities.user.APIUserRole).STUDENT)"
    )
    @QueryMapping
    public PlanetDTO findPlanetById(@Argument int id) {
        return planetService.findPlanetById(id);
    }
}

