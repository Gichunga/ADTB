package com.gwazasoftwares.ADTB.dbs;


import com.gwazasoftwares.ADTB.models.HealthFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthFacilityRepository extends JpaRepository<HealthFacility, String> {
}
