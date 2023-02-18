package com.attornatus.managePeople.repository;

import com.attornatus.managePeople.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    public Address findByPersonIdAndIsMainAddress(Long personId, boolean isMainAddress);

}
