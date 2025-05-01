package com.constructhub.backend.repository;


import com.constructhub.backend.model.MayMoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MayMocRepository extends JpaRepository<MayMoc, Long>, JpaSpecificationExecutor<MayMoc> {
    // Define any custom query methods here if needed
}
