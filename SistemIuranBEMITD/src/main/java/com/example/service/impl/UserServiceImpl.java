package com.example.service.impl;

import com.example.model.*;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    private EntityManagerFactory emf;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Autowired
    void injectDependency(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
//        Role userRole = roleRepository.findByRole("BEM");
        Role userRole = roleRepository.findByRole("KELAS");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        userRepository.save(user);


    }

    @Override
    public void updateStatus(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Integer id) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();

    }
}
