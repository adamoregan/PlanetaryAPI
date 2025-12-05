package planetaryAPI.dtos.planet;
import jakarta.validation.constraints.Positive;

public record PlanetChangeDTO(
        int planetId,
        String name,
        String type,
        @Positive
        int radiusKm,
        @Positive
        int massKg,
        @Positive
        int orbitalPeriodDays
) {}
