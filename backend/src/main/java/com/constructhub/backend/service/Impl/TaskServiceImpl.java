package com.constructhub.backend.service.Impl;

import com.constructhub.backend.dto.TaskDTO;
import com.constructhub.backend.entity.Task;
import com.constructhub.backend.repository.TaskRepository;
import com.constructhub.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Map<String, Integer> getTaskCountsByStatus() {
        // Use LinkedHashMap to preserve insertion order
        Map<String, Integer> counts = new LinkedHashMap<>();

        int chuaBatDau = taskRepository.countByTrangThai("chua bat dau");
        int dangTienHanh = taskRepository.countByTrangThai("dang tien hanh");
        int kiemTra = taskRepository.countByTrangThai("kiem tra");
        int hoanThanh = taskRepository.countByTrangThai("hoan thanh");
        int choXuLy = taskRepository.countByTrangThai("cho xu ly");

        // Calculate total first if you want it to appear first
        int total = chuaBatDau + dangTienHanh + kiemTra + hoanThanh + choXuLy;
        counts.put("total", total);

        // Then add other counts in desired order
        counts.put("chuaBatDau", chuaBatDau);
        counts.put("dangTienHanh", dangTienHanh);
        counts.put("kiemTra", kiemTra);
        counts.put("hoanThanh", hoanThanh);
        counts.put("choXuLy", choXuLy);

        return counts;
    }

    @Override
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }


}
