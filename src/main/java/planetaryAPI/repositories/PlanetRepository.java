package planetaryAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import planetaryAPI.entities.Planet;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    List<Planet> findAllByTypeIgnoreCase(String type);
}
