package com.constructhub.backend.controller;

import com.constructhub.backend.dto.request.TaskRequestDTO;
import com.constructhub.backend.dto.response.ResponseData;
import com.constructhub.backend.dto.response.TaskResponseDTO;
import com.constructhub.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseData<Long> addTask(@RequestBody TaskRequestDTO request) {
        Long taskId = taskService.addTask(request);
        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Thêm task thành công",
                taskId
        );
    }

    @GetMapping("/count-by-status")
    public ResponseData<Map<String, Integer>> getTaskCountsByStatus() {
        Map<String, Integer> statusCounts = taskService.getTaskStatusCounts();
        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy số lượng task theo trạng thái thành công",
                statusCounts
        );
    }
    @GetMapping("/getAll")
    public ResponseData<Page<TaskResponseDTO>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<TaskResponseDTO> taskPage = taskService.getAllTasks(pageable);

        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách task thành công",
                taskPage
        );
    }
}