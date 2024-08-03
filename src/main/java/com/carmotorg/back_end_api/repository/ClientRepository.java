package com.carmotorg.back_end_api.repository;

import com.carmotorg.back_end_api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
