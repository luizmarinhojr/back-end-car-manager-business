package com.carmotorg.back_end_api.repository;

import com.carmotorg.back_end_api.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
