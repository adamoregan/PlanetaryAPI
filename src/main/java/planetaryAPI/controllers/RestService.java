package planetaryAPI.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import planetaryAPI.dtos.moon.MoonCreateDTO;
import planetaryAPI.dtos.moon.MoonDTO;
import planetaryAPI.dtos.planet.PlanetChangeDTO;
import planetaryAPI.dtos.planet.PlanetCreateDTO;
import planetaryAPI.dtos.planet.PlanetDTO;
import planetaryAPI.services.moon.MoonService;
import planetaryAPI.services.planet.PlanetService;

import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestService {
    private PlanetService planetService;
    private MoonService moonService;

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

    @Operation(summary = "Find all moons", description = "Retrieve a list of all moons.")
    @GetMapping("/moons")
    List<MoonDTO> findAllMoons() { return moonService.findAllMoons(); }

    @Operation(summary = "Find a moon by id", description = "Retrieve the moon with the provided id.")
    @GetMapping("/moons/{id}")
    MoonDTO findMoonById(@PathVariable int id) { return moonService.findMoonById(id); }

    @Operation(summary = "Find all moons of a planet", description = "Retrieve a list of all moons by planet name.")
    @GetMapping("/moons/planet/{planetName}")
    List<MoonDTO> findAllMoonsByPlanetName(@PathVariable String planetName) {
        return moonService.findAllMoonsByPlanetName(planetName);
    }

    @Operation(summary = "Create a moon", description = "Create a moon. Retrieve the moon and its associated planet.")
    @PostMapping("/moons")
    @ResponseStatus(HttpStatus.CREATED)
    MoonDTO createMoon(@Valid @RequestBody MoonCreateDTO moonCreateDTO) {
        return moonService.createMoon(moonCreateDTO);
    }

    @Operation(summary = "Delete a moon by id", description = "Delete the moon with the provided id.")
    @DeleteMapping("/moons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMoonById(@PathVariable int id) { moonService.deleteMoonById(id); }
}
