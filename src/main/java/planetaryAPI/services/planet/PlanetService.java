package planetaryAPI.services.planet;

import planetaryAPI.dtos.planet.PlanetCreateDTO;
import planetaryAPI.dtos.planet.PlanetDTO;

import java.util.List;

public interface PlanetService {
    List<PlanetDTO> findAllPlanets();
    List<PlanetDTO> findAllPlanetsByType(String type);
    PlanetDTO findPlanetById(int id);
    void deletePlanetById(int id);
    PlanetDTO createPlanet(PlanetCreateDTO planetCreateDTO);

}
