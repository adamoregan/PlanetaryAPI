package planetaryAPI.dtos;

public record MoonDTO(
        int moonId,
        String name,
        int diameterKm,
        int orbitalPeriodDays,
        PlanetDTO planet
) {}