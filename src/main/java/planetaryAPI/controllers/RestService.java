package planetaryAPI.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import planetaryAPI.dtos.planet.PlanetChangeDTO;
import planetaryAPI.dtos.planet.PlanetCreateDTO;
import planetaryAPI.dtos.planet.PlanetDTO;
import planetaryAPI.services.planet.PlanetService;

import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestService {
    private PlanetService planetService;

    @Operation(summary = "Find all planets", description = "Retrieve a list of all planets.")
    @GetMapping("/planets")
    List<PlanetDTO> findAllPlanets() { return planetService.findAllPlanets(); }

    @Operation(summary = "Find all planets of a certain type", description = "Retrieve a list of all planets with the provided type.")
    @GetMapping("/planets/type/{type}")
    List<PlanetDTO> findAllPlanetsByType(@PathVariable String type) { return planetService.findAllPlanetsByType(type); }

    @Operation(summary = "Find a planet by id", description = "Retrieve the planet with the provided id.")
    @GetMapping("/planets/{id}")
    PlanetDTO findPlanetById(@PathVariable int id) {
        return planetService.findPlanetById(id);
    }

    @Operation(summary = "Delete a planet by id", description = "Delete the planet with the provided id.")
    @DeleteMapping("/planets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable int id) { planetService.deletePlanetById(id); }

    @Operation(summary = "Create a planet", description = "Create a planet. Retrieve the created planet.")
    @PostMapping("/planets")
    @ResponseStatus(HttpStatus.CREATED)
    PlanetDTO createPlanet(@Valid @RequestBody PlanetCreateDTO planetCreateDTO) {
        return planetService.createPlanet(planetCreateDTO);
    }

    @Operation(summary = "Update a planet", description = "Update a planet. Retrieve the updated planet.")
    @PatchMapping("/planets")
    PlanetDTO changePlanet(@Valid @RequestBody PlanetChangeDTO planetChangeDTO) {
        return planetService.changePlanet(planetChangeDTO);
    }
}
