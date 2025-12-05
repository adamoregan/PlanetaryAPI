package planetaryAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import planetaryAPI.entities.Planet;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    List<Planet> findAllByTypeIgnoreCase(String type);
    @Transactional
    @Modifying
    @Query("DELETE FROM Planet p WHERE p.planet_id = :id")
    int deleteById(int id);
}
