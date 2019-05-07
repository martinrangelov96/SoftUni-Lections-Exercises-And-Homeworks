package jsonprocessing.service;

import jsonprocessing.domain.dtos.UserSeedDto;

public interface UserService {

    void seedUsers(UserSeedDto[] userSeedDtos);
}
