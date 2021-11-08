package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.UserGroup;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Long> {

}
