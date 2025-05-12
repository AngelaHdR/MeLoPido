package com.fpmislata.MeLoPido.domain.service.user;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.UserQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.user.command.DeleteUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.InsertUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.UpdateUser;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;

import java.util.List;

public class UserCommandService implements DeleteUser, UpdateUser, InsertUser {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final String currentUser = "2";
    private final List<String> currentGroup = List.of("1");

    public UserCommandService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }
    @Override
    public void delete(String idUser) {
        verifyCurrentUser(idUser);
        userRepository.delete(idUser);
    }

    @Override
    public void removeFromGroup(String idUser, String idGroup) {
        verifyCurrentUser(idUser);
        User user = userRepository.findById(idUser).orElseThrow(() -> new RessourceNotFoundException("User not found"));
        Group group = groupRepository.findById(idGroup).orElseThrow(() -> new RessourceNotFoundException("Group not found"));
        if (!user.getGroups().contains(group)) {
            throw new RuntimeException("User doesn't belong to this group");
        }
        user.getGroups().remove(group);
        user.setGroups(user.getGroups());
        userRepository.save(user);
    }

    @Override
    public void insert(UserCommand user) {
        userRepository.save(UserQueryMapper.toUser(user));
    }

    @Override
    public void update(String idUser, UserCommand user) {
        verifyCurrentUser(idUser);
        User userExisting = userRepository.findById(idUser).orElseThrow(() -> new RessourceNotFoundException("User not found"));
        if(user.password() != null) {
            verifyPassword(user.password());
            userExisting.setPassword(user.password());
        }
        if(user.username() != null) {
            verifyUsername(user.username());
            userExisting.setUsername(user.username());
        }
        if(user.birthDate() != null) {
            userExisting.setBirthDate(user.birthDate());
        }
        if(user.email() != null) {
            userExisting.setEmail(user.email());
        }
        if(user.name() != null) {
            userExisting.setName(user.name());
        }
        if(user.surname1() != null) {
            userExisting.setSurname1(user.surname1());
        }
        if(user.surname2() != null) {
            userExisting.setSurname2(user.surname2());
        }
    }

    public boolean verifyUsername(String username) {
        userRepository.findByUsername(username);
        return true;
    }

    public boolean verifyPassword(String password) {
        if(password.length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters long");
        }
        if(!password.matches(".*[A-Z].*")) {
            throw new RuntimeException("Password must contain at least one uppercase letter");
        }
        if(!password.matches(".*[a-z].*")) {
            throw new RuntimeException("Password must contain at least one lowercase letter");
        }
        if(!password.matches(".*[0-9].*")) {
            throw new RuntimeException("Password must contain at least one number");
        }
        return true;
    }

    @Override
    public void addToGroup(String idUser, String idGroup) {
        verifyCurrentUser(idUser);
        User user = userRepository.findById(idUser).orElseThrow(() -> new RessourceNotFoundException("User not found"));
        Group group = groupRepository.findById(idGroup).orElseThrow(() -> new RessourceNotFoundException("Group not found"));
        if (user.getGroups().contains(group)) {
            throw new RuntimeException("User already belongs to this group");
        }
        user.getGroups().add(group);
        user.setGroups(user.getGroups());
        userRepository.save(user);
    }

    private void verifyCurrentUser(String idUser) {
        System.out.println("user:" + idUser);
        if (!idUser.equals(currentUser)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyCurrentUserOrGroup(String idUser, String idGroup) {
        System.out.println("user:" + idUser + "group:" + idGroup);
        if (!idUser.equals(currentUser) && !currentGroup.contains(idGroup)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }
}
