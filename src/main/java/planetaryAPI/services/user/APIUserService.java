package planetaryAPI.services.user;

import planetaryAPI.dtos.user.APIUserDTO;
import planetaryAPI.dtos.user.UserCreateDTO;

public interface APIUserService {
    APIUserDTO createUser(UserCreateDTO user);
    APIUserDTO findUserByName(String name);
}
