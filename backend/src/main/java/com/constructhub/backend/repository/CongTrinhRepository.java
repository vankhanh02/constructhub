package com.constructhub.backend.repository;

import com.constructhub.backend.entity.CongTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CongTrinhRepository extends JpaRepository<CongTrinh, Long>, JpaSpecificationExecutor<CongTrinh> {


    @Query(value="SELECT COUNT(ma_cong_trinh) FROM cong_trinh WHERE tinh_trang='hoat dong'", nativeQuery = true)
    int getActiveConstructionCount();


}
