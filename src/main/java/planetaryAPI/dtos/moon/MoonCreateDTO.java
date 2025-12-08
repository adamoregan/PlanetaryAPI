package planetaryAPI.dtos.moon;

import jakarta.validation.constraints.Positive;

public record MoonCreateDTO(
        String name,
        @Positive
        int diameterKm,
        @Positive
        int orbitalPeriodDays,
        int planetId
) {
}
