package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.Disposer;

@Repository
public interface DisposerRepo extends JpaRepository<Disposer, Long> {

}
