package com.JPA.JPATest.service.impl;

import com.JPA.JPATest.dto.UserDTO;
import com.JPA.JPATest.entity.User;
import com.JPA.JPATest.entity.UserDetails;
import com.JPA.JPATest.repository.UserRepository;
import com.JPA.JPATest.service.UserService;
import com.JPA.JPATest.service.UserSpecification;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        return toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        existing.setName(userDTO.getName());
        existing.setEmail(userDTO.getEmail());
        existing.setPhone(userDTO.getPhone());
        return toDTO(userRepository.save(existing));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }

    private User toEntity(UserDTO dto) {
        return new User(null, dto.getName(), dto.getEmail(), dto.getPhone(),null);
    }

    EntityManager entityManager;


    void searchUser(String name){
        CriteriaBuilder cb =  entityManager.getCriteriaBuilder();
        // what columns should be there
        CriteriaQuery<UserDetails> crQuery = cb.createQuery(UserDetails.class);
        // from table
        Root<UserDetails> user =  crQuery.from(UserDetails.class);
        // select * from user
        crQuery.select(user);

        Predicate predicate =  cb.equal(user.get("name"), name);
        crQuery.where(predicate);
        TypedQuery<UserDetails> typedQuery =  entityManager.createQuery(crQuery);
        List<UserDetails> output =  typedQuery.getResultList();

    }

    void searchUserUsingSpecification(){
        Specification<UserDetails> result = Specification
        .where(UserSpecification.equalsPhone("null"))
        .and(null);
    }
}
