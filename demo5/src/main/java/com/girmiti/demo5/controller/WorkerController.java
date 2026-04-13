package com.girmiti.demo5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.girmiti.demo5.entity.Task;
import com.girmiti.demo5.entity.Worker;
import com.girmiti.demo5.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    /**
     * POST /api/workers/{id}/tasks
     * Endpoint to assign a new task to a specific worker.
     */
    @PostMapping("/{workerId}/tasks")
    public ResponseEntity<?> assignTask(@PathVariable Long workerId, @RequestBody Task taskDetails) {
        try {
            Worker updatedWorker = workerService.assignTaskToWorker(workerId, taskDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedWorker);
        } catch (IllegalStateException e) {
            // 400 Bad Request if the worker is busy
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            // 404 Not Found if the worker doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * GET /api/workers/search?department=IT&status=AVAILABLE
     * Endpoint to search for workers based on query parameters.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Worker>> searchWorkers(
            @RequestParam String department, 
            @RequestParam String status) {
        
        List<Worker> workers = workerService.getWorkersByDepartmentAndStatus(department, status);
        return ResponseEntity.ok(workers);
    }

    /**
     * PUT /api/workers/department/{department}/off-duty
     * Endpoint to trigger a bulk update for a whole department.
     */
    @PutMapping("/department/{department}/off-duty")
    public ResponseEntity<String> setDepartmentOffDuty(@PathVariable String department) {
        int updatedCount = workerService.markDepartmentOffDuty(department);
        return ResponseEntity.ok("Successfully updated " + updatedCount + " workers to OFF_DUTY.");
    }
}
