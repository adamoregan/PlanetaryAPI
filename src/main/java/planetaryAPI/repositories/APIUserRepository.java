package planetaryAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import planetaryAPI.entities.user.APIUser;

public interface APIUserRepository extends JpaRepository<APIUser, String> {
}
