package com.constructhub.backend.service;

import com.constructhub.backend.dto.TaskDTO;
import com.constructhub.backend.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TaskService {
    Map<String, Integer> getTaskCountsByStatus();

    Page<Task> getAllTasks(Pageable pageable);

}
