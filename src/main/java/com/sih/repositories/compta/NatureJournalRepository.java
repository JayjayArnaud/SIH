package com.sih.repositories.compta;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sih.entities.compta.NatureJournal;

public interface NatureJournalRepository extends JpaRepository<NatureJournal, Long> {
}
