package planetaryAPI.dtos.planet;

public record PlanetChangeDTO(
        int planetId,
        String name,
        String type,
        int radiusKm,
        int massKg,
        int orbitalPeriodDays
) {}
