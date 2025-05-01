package com.constructhub.backend.repository;

import com.constructhub.backend.model.CongTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CongTrinhRepository extends JpaRepository<CongTrinh, Long>, JpaSpecificationExecutor<CongTrinh> {
    @Query(value="SELECT COUNT(id) FROM cong_trinh WHERE tinh_trang='hoạt động'", nativeQuery = true)
    int getActiveConstructionCount();
}
