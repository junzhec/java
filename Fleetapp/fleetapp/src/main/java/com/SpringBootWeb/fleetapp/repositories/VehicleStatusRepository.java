package com.SpringBootWeb.fleetapp.repositories;

import com.SpringBootWeb.fleetapp.models.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {
}
