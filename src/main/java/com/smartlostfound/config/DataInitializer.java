package com.smartlostfound.config;

import com.smartlostfound.entity.auth.Role;
import com.smartlostfound.repository.auth.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

        if (roleRepository.findByRoleName("ADMIN").isEmpty()) {
            Role admin = new Role();
            admin.setRoleName("ADMIN");
            roleRepository.save(admin);
        }

        if (roleRepository.findByRoleName("USER").isEmpty()) {
            Role user = new Role();
            user.setRoleName("USER");
            roleRepository.save(user);
        }

        if (roleRepository.findByRoleName("STAFF").isEmpty()) {
            Role staff = new Role();
            staff.setRoleName("STAFF");
            roleRepository.save(staff);
        }

        System.out.println("Default Roles Inserted Successfully");
    }
}