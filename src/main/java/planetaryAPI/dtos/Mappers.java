package planetaryAPI.dtos;

import planetaryAPI.dtos.moon.MoonCreateDTO;
import planetaryAPI.dtos.moon.MoonDTO;
import planetaryAPI.dtos.planet.PlanetChangeDTO;
import planetaryAPI.dtos.planet.PlanetCreateDTO;
import planetaryAPI.dtos.planet.PlanetDTO;
import planetaryAPI.dtos.user.UserCreateDTO;
import planetaryAPI.entities.Moon;
import planetaryAPI.entities.Planet;
import planetaryAPI.dtos.user.APIUserDTO;
import planetaryAPI.entities.user.APIUser;

import java.sql.Timestamp;


public class Mappers {
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

    public static MoonDTO mapMoonToMoonDTO(Moon m) {
        return new MoonDTO(
                m.getMoon_id(),
                m.getName(),
                m.getDiameter_km(),
                m.getOrbital_period_days(),
                m.getPlanet() != null ? mapPlanetToPlanetDTO(m.getPlanet()) : null
        );
    }

    public static Moon mapMoonCreateDTOToMoon(MoonCreateDTO m) {
        Moon moon = new Moon();
        moon.setName(m.name());
        moon.setDiameter_km(m.diameterKm());
        moon.setOrbital_period_days(m.orbitalPeriodDays());
        return moon;
    }

    public static APIUserDTO mapUserToUserDTO(APIUser u) {
        return new APIUserDTO(
                u.getName(),
                u.getPassword(),
                u.getRole(),
                u.isEnabled(),
                u.getCreated_at(),
                u.getUpdated_at()
        );
    }

    public static APIUser mapUserCreateDTOToUser(UserCreateDTO u) {
        APIUser user = new APIUser();
        user.setName(u.name());
        user.setPassword(u.password());
        user.setRole(u.type());
        user.setEnabled(u.enabled());
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));
        user.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        return user;
    }
}
