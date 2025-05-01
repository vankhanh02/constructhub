package com.constructhub.backend.repository;

import com.constructhub.backend.model.VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VatTuRepository extends JpaRepository<VatTu, Long>, JpaSpecificationExecutor<VatTu> {
}
