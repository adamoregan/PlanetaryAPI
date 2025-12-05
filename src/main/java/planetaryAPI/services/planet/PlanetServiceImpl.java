package planetaryAPI.services.planet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import planetaryAPI.dtos.Mappers;
import planetaryAPI.dtos.planet.PlanetDTO;
import planetaryAPI.entities.Planet;
import planetaryAPI.repositories.PlanetRepository;
import planetaryAPI.exceptions.NotFoundException;
import planetaryAPI.dtos.planet.PlanetCreateDTO;

import java.util.List;
import java.util.Optional;

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

    @Override
    public PlanetDTO findPlanetById(int id) throws NotFoundException {
        Optional<Planet> planet = planetRepository.findById(id);
        if (planet.isPresent()) return Mappers.mapPlanetToPlanetDTO(planet.get());
        throw new NotFoundException("Planet with id " + id + " not found");
    }


    @Override
    public void deletePlanetById(int id) throws NotFoundException {
        int rowsDeleted = planetRepository.deleteById(id);
        if (rowsDeleted == 0) throw new NotFoundException("Planet with id " + id + " not found");
    }

    @Override
    public PlanetDTO createPlanet(PlanetCreateDTO planetCreateDTO) {
        Planet newPlanet = Mappers.mapPlanetCreateDTOToPlanet(planetCreateDTO);
        newPlanet = planetRepository.save(newPlanet);
        return Mappers.mapPlanetToPlanetDTO(newPlanet);
    }
}
