package com.constructhub.backend.repository;

import com.constructhub.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    @Query("SELECT COUNT(t) FROM Task t WHERE t.trangThai = :trangThai")
    int countByTrangThai(@Param("trangThai") String trangThai);
}
