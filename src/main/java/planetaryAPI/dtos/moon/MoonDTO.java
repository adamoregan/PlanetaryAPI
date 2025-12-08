package planetaryAPI.dtos.moon;

import planetaryAPI.dtos.planet.PlanetDTO;

public record MoonDTO(
        int moonId,
        String name,
        int diameterKm,
        int orbitalPeriodDays,
        PlanetDTO planet
) {}