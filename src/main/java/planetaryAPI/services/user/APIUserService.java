package planetaryAPI.services.user;

import planetaryAPI.dtos.user.APIUserDTO;

public interface APIUserService {
    APIUserDTO findUserByName(String name);
}
