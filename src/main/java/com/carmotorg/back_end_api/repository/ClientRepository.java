package com.carmotorg.back_end_api.repository;

import com.carmotorg.back_end_api.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c from Client c")
    Page<Client> findAllClients(Pageable pageable);
}
