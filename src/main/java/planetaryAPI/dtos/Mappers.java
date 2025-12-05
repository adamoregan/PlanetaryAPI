package planetaryAPI.dtos;

import planetaryAPI.dtos.planet.PlanetChangeDTO;
import planetaryAPI.dtos.planet.PlanetCreateDTO;
import planetaryAPI.dtos.planet.PlanetDTO;
import planetaryAPI.entities.Moon;
import planetaryAPI.entities.Planet;

public class Mappers {
    public static MoonDTO mapMoonToMoonDTO(Moon m) {
        return new MoonDTO(
                m.getMoon_id(),
                m.getName(),
                m.getDiameter_km(),
                m.getOrbital_period_days(),
                m.getPlanet() != null ? mapPlanetToPlanetDTO(m.getPlanet()) : null
        );
    }

    public static PlanetDTO mapPlanetToPlanetDTO(Planet p) {
        return new PlanetDTO(
                p.getPlanet_id(),
                p.getName(),
                p.getType(),
                p.getRadius_km(),
                p.getMass_kg(),
                p.getOrbital_period_days()
        );
    }

    public static Planet mapPlanetDTOToPlanet(PlanetDTO p) {
        Planet planet = new Planet();
        planet.setPlanet_id(p.planetId());
        planet.setName(p.name());
        planet.setType(p.type());
        planet.setMass_kg(p.massKg());
        planet.setRadius_km(p.radiusKm());
        planet.setOrbital_period_days(p.orbitalPeriodDays());
        return planet;
    }

    public static Planet mapPlanetCreateDTOToPlanet(PlanetCreateDTO p) {
        Planet planet = new Planet();
        planet.setName(p.name());
        planet.setType(p.type());
        planet.setMass_kg(p.massKg());
        planet.setRadius_km(p.radiusKm());
        planet.setOrbital_period_days(p.orbitalPeriodDays());
        return planet;
    }

    public static Planet mapPlanetChangeDTOToPlanet(PlanetChangeDTO p) {
        Planet planet = new Planet();
        planet.setPlanet_id(p.planetId());
        planet.setName(p.name());
        planet.setType(p.type());
        planet.setMass_kg(p.massKg());
        planet.setRadius_km(p.radiusKm());
        planet.setOrbital_period_days(p.orbitalPeriodDays());
        return planet;
    }
}
