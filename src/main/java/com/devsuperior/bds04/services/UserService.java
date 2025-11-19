package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.RoleDTO;
import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.repositories.RoleRepository;
import com.devsuperior.bds04.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(x -> new UserDTO(x));
    }

//    @Transactional(readOnly = true)
//    public UserDTO findById(Long id) {
//        Optional<User> obj = repository.findById(id);
//        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
//        return new UserDTO(entity);
//    }
//
//    @Transactional
//    public UserDTO insert(UserInsertDTO dto) {
//        User entity = new User();
//        copyDtoToEntity(dto, entity);
//        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
//        entity = repository.save(entity);
//        return new UserDTO(entity);
//    }
//
//    @Transactional
//    public UserDTO update(Long id, UserUpdateDTO dto) {
//        try {
//            User entity = repository.getReferenceById(id);
//            copyDtoToEntity(dto, entity);
//            entity = repository.save(entity);
//            return new UserDTO(entity);
//        } catch (EntityNotFoundException e) {
//            throw new ResourceNotFoundException("Id not found " + id);
//        }
//    }
//
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void delete(Long id) {
//        if (!repository.existsById(id)) {
//            throw new ResourceNotFoundException("Recurso não encontrado");
//        }
//        try {
//            repository.deleteById(id);
//        }
//        catch (DataIntegrityViolationException e) {
//            throw new DatabaseException("Falha de integridade referencial");
//        }
//    }
//
//    private void copyDtoToEntity(UserDTO dto, User entity) {
//        entity.setFirstName(dto.getFirstName());
//        entity.setLastName(dto.getLastName());
//        entity.setEmail(dto.getEmail());
//
//        entity.getRoles().clear();
//        for (RoleDTO roleDto : dto.getRoles()) {
//            Role role = roleRepository.getReferenceById(roleDto.getId());
//            entity.getRoles().add(role);
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
