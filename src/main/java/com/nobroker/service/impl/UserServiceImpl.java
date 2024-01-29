package com.nobroker.service.impl;

import com.nobroker.entity.User;
import com.nobroker.payload.UserDto;
import com.nobroker.repository.UserRepository;
import com.nobroker.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Override
    public long createUser(UserDto userDto) {
        User user=mapToEntity(userDto);
        User save = userRepository.save(user);
        return save.getId();
    }

   private User mapToEntity(UserDto userDto){
        return modelMapper.map(userDto,User.class);
    }
    private UserDto mapToDto(User user){
        return modelMapper.map(user,UserDto.class);
    }
}
