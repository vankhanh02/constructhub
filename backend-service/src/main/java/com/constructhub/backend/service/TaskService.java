package com.constructhub.backend.service;

import com.constructhub.backend.dto.request.TaskRequestDTO;
import com.constructhub.backend.dto.response.TaskResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface TaskService {
    Long addTask(TaskRequestDTO request);
    public Map<String, Integer> getTaskStatusCounts();

    public Page<TaskResponseDTO> getAllTasks(Pageable pageable);
}
