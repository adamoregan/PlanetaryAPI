package planetaryAPI.services.planet;

import planetaryAPI.dtos.PlanetDTO;

import java.util.List;

public interface PlanetService {
    List<PlanetDTO> findAllPlanets();
    List<PlanetDTO> findAllPlanetsByType(String type);
}
