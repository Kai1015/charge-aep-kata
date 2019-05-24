package com.kaiherrera.chargeaep.service;

import java.util.Optional;

import com.kaiherrera.chargeaep.domain.User;

public interface UserService {
	Optional<User> getUser(String id) throws Exception;
}
