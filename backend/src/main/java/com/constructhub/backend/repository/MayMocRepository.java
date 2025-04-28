package com.constructhub.backend.repository;

import com.constructhub.backend.entity.MayMoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MayMocRepository extends JpaRepository<MayMoc, Long>, JpaSpecificationExecutor<MayMoc> {
    @Query(value="SELECT COUNT(ma_may_moc) FROM may_moc WHERE trang_thai='hoat dong'", nativeQuery = true)
    int getActiveMayMoc();


    @Query(value="SELECT COUNT(ma_may_moc) FROM may_moc WHERE trang_thai='hu hong'", nativeQuery = true)
    int getDamagedMayMoc();



}
