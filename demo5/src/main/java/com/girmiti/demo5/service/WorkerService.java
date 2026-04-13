package com.girmiti.demo5.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.girmiti.demo5.entity.Task;
import com.girmiti.demo5.entity.Worker;
import com.girmiti.demo5.repository.WorkerRepository;

import java.util.List;


@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    // Constructor-based Dependency Injection (Recommended over @Autowired)
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    /**
     * Assigns a new task to a worker if they are available.
     * The @Transactional annotation ensures that if anything fails, the entire database operation rolls back.
     */
    @Transactional
    public Worker assignTaskToWorker(Long workerId, Task task) {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new RuntimeException("Worker with ID " + workerId + " not found."));

        if (!"AVAILABLE".equalsIgnoreCase(worker.getAvailabilityStatus())) {
            throw new IllegalStateException("Cannot assign task. Worker is currently " + worker.getAvailabilityStatus());
        }

        // Establish the bidirectional relationship
        task.setWorker(worker);
        task.setStatus("PENDING");
        worker.getTasks().add(task);

        // Because of CascadeType.ALL on the entity, saving the worker also saves the new task
        return workerRepository.save(worker);
    }

    /**
     * Retrieves workers by department and status.
     * ReadOnly is set to true to optimize performance since no data is being modified.
     */
    @Transactional(readOnly = true)
    public List<Worker> getWorkersByDepartmentAndStatus(String department, String status) {
        return workerRepository.findByDepartmentAndAvailabilityStatus(department, status);
    }

    /**
     * Executes the bulk update query.
     */
    @Transactional
    public int markDepartmentOffDuty(String department) {
        return workerRepository.updateStatusToOffDutyByDepartment(department);
    }
}
