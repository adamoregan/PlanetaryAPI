package planetaryAPI.services.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import planetaryAPI.dtos.Mappers;
import planetaryAPI.dtos.user.APIUserDTO;
import planetaryAPI.entities.user.APIUser;
import planetaryAPI.exceptions.NotFoundException;
import planetaryAPI.repositories.APIUserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class APIUserServiceImpl implements APIUserService {
    private APIUserRepository APIUserRepository;

    @Override
    public APIUserDTO findUserByName(String name) {
        Optional<APIUser> user = APIUserRepository.findById(name);
        if (user.isPresent()) return Mappers.mapUserToUserDTO(user.get());
        throw new NotFoundException("User with name " + name + " not found");
    }
}
