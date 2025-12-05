package planetaryAPI.services.planet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import planetaryAPI.dtos.Mappers;
import planetaryAPI.dtos.PlanetDTO;
import planetaryAPI.repositories.PlanetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanetServiceImpl implements PlanetService {
    private PlanetRepository planetRepository;

    @Override
    public List<PlanetDTO> findAllPlanets() {
        return planetRepository.findAll().stream()
                .map(Mappers::mapPlanetToPlanetDTO)
                .toList();
    }

    @Override
    public List<PlanetDTO> findAllPlanetsByType(String type) {
        return planetRepository.findAllByTypeIgnoreCase(type).stream()
                .map(Mappers::mapPlanetToPlanetDTO)
                .toList();
    }
}
