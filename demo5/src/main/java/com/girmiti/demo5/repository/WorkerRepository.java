package com.girmiti.demo5.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.girmiti.demo5.entity.Worker;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    // 1. Derived Query: Spring parses the method name to generate the SQL
    List<Worker> findByDepartmentAndAvailabilityStatus(String department, String status);

    // 2. Derived Query: Prefix search ignoring case
    List<Worker> findByNameStartingWithIgnoreCase(String prefix);

    // 3. Custom JPQL Query: Find workers with more than N pending tasks
    @Query("SELECT w FROM Worker w JOIN w.tasks t WHERE t.status = 'PENDING' GROUP BY w.id HAVING COUNT(t) > :taskCount")
    List<Worker> findWorkersOverloadedWithPendingTasks(@Param("taskCount") long taskCount);

    // 4. Update Query: Bulk update status by department
    @Modifying
    @Query("UPDATE Worker w SET w.availabilityStatus = 'OFF_DUTY' WHERE w.department = :department")
    int updateStatusToOffDutyByDepartment(@Param("department") String department);
}
