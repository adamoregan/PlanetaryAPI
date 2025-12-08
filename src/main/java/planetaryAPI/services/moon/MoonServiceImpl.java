package planetaryAPI.services.moon;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import planetaryAPI.dtos.Mappers;
import planetaryAPI.dtos.moon.MoonCreateDTO;
import planetaryAPI.dtos.moon.MoonDTO;
import planetaryAPI.dtos.planet.PlanetDTO;
import planetaryAPI.entities.Moon;
import planetaryAPI.exceptions.NotFoundException;
import planetaryAPI.repositories.MoonRepository;
import planetaryAPI.services.planet.PlanetService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MoonServiceImpl implements MoonService {
    private MoonRepository moonRepository;
    private PlanetService planetService;

    @Override
    public List<MoonDTO> findAllMoons() {
        return moonRepository.findAll().stream()
                .map(Mappers::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public MoonDTO findMoonById(int id) throws NotFoundException {
        Optional<Moon> moon = moonRepository.findById(id);
        if (moon.isPresent()) return Mappers.mapMoonToMoonDTO(moon.get());
        throw new NotFoundException("Moon with id " + id + " not found");
    }

    @Override
    public void deleteMoonById(int id) throws NotFoundException {
        int rowsDeleted = moonRepository.deleteById(id);
        if (rowsDeleted == 0) throw new NotFoundException("Moon with id " + id + " not found");
    }

    @Override
    public List<MoonDTO> findAllMoonsByPlanetName(String planetName) {
        return moonRepository.findAllMoonByPlanetNameIgnoreCase(planetName).stream()
                .map(Mappers::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public int countAllMoonByPlanetName(String planetName) {
        return moonRepository.countAllMoonByPlanetNameIgnoreCase(planetName);
    }

    @Override
    public MoonDTO createMoon(MoonCreateDTO moonCreateDTO) {
        PlanetDTO planet = planetService.findPlanetById(moonCreateDTO.planetId());
        Moon moon = Mappers.mapMoonCreateDTOToMoon(moonCreateDTO);
        moon.setPlanet(Mappers.mapPlanetDTOToPlanet(planet));
        return Mappers.mapMoonToMoonDTO(moonRepository.save(moon));
    }
}
