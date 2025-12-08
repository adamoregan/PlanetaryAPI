package planetaryAPI.repositories;

import planetaryAPI.entities.Moon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MoonRepository extends JpaRepository<Moon, Integer> {
    List<Moon> findAllMoonByPlanetNameIgnoreCase(String planetName);
    int countAllMoonByPlanetNameIgnoreCase(String planetName);
    @Transactional
    @Modifying
    @Query("DELETE FROM Moon m WHERE m.moon_id = :id")
    int deleteById(int id);
}
