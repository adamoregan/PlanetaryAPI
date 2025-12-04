package planetaryAPI.dtos;

public record PlanetDTO(
        int planetId,
        String name,
        String type,
        int radiusKm,
        int massKg,
        int orbitalPeriodDays
) {}
