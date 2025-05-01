package com.constructhub.backend.repository;

import com.constructhub.backend.model.VatTu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VatTuRepository extends JpaRepository<VatTu, Long>, JpaSpecificationExecutor<VatTu> {

    @Query("SELECT v FROM VatTu v WHERE v.soLuong <= v.soLuongMucThap")
    Page<VatTu> findVatTuWithLowStock(Pageable pageable);
}
