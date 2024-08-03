package com.carmotorg.back_end_api.repository;

import com.carmotorg.back_end_api.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
