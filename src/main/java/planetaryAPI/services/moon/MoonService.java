package planetaryAPI.services.moon;

import planetaryAPI.dtos.moon.MoonDTO;
import planetaryAPI.dtos.moon.MoonCreateDTO;

import java.util.List;

public interface MoonService {
    List<MoonDTO> findAllMoons();
    MoonDTO findMoonById(int id);
    void deleteMoonById(int id);
    List<MoonDTO> findAllMoonsByPlanetName(String planetName);
    int countAllMoonByPlanetName(String planetName);
    MoonDTO createMoon(MoonCreateDTO moonCreateDTO);
}
