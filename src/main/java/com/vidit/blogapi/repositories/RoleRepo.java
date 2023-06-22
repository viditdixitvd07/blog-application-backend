package com.vidit.blogapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidit.blogapi.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
