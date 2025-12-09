package planetaryAPI.services.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import planetaryAPI.dtos.Mappers;
import planetaryAPI.dtos.user.APIUserDTO;
import planetaryAPI.dtos.user.UserCreateDTO;
import planetaryAPI.entities.user.APIUser;
import planetaryAPI.exceptions.AlreadyExists;
import planetaryAPI.exceptions.NotFoundException;
import planetaryAPI.repositories.APIUserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class APIUserServiceImpl implements APIUserService {
    private APIUserRepository APIUserRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public APIUserDTO createUser(UserCreateDTO user) {
        Optional<APIUser> existingUser = APIUserRepository.findById(user.name());
        if (existingUser.isPresent()) throw new AlreadyExists("User with name " + user.name() + " already exists");
        APIUser newUser = Mappers.mapUserCreateDTOToUser(user);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser = APIUserRepository.save(newUser);
        return Mappers.mapUserToUserDTO(newUser);
    }

    @Override
    public APIUserDTO findUserByName(String name) {
        Optional<APIUser> user = APIUserRepository.findById(name);
        if (user.isPresent()) return Mappers.mapUserToUserDTO(user.get());
        throw new NotFoundException("User with name " + name + " not found");
    }
}
