package org.example.authentificationservice.service;

import org.example.authentificationservice.dto.RegisterRequestDto;
import org.example.authentificationservice.entity.UserApp;
import org.example.authentificationservice.exception.UserAlreadyExistException;
import org.example.authentificationservice.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService {
    private final UserAppRepository userRepository;

    public UserAppService(UserAppRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserApp enregistrerUtilisateur(RegisterRequestDto registerRequestDto) throws UserAlreadyExistException {
        Optional<UserApp> userAppOptional = userRepository.findByEmail(registerRequestDto.getEmail());
        if(userAppOptional.isEmpty()){
            UserApp user = new UserApp(registerRequestDto.getEmail(), registerRequestDto.getName(), registerRequestDto.getPassword(),0);
            return userRepository.save(user);
        }
        throw new UserAlreadyExistException();
    }
}
