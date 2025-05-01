package com.constructhub.backend.service.Impl;

import com.constructhub.backend.dto.request.TaskRequestDTO;
import com.constructhub.backend.dto.response.TaskResponseDTO;
import com.constructhub.backend.model.Task;
import com.constructhub.backend.repository.TaskRepository;
import com.constructhub.backend.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Long addTask(TaskRequestDTO request) {
        if (request == null || request.getTen() == null) {
            throw new IllegalArgumentException("Missing required information");
        }

        Task task = Task.builder()
                .ten(request.getTen())
                .maCongTrinh(request.getMaCongTrinh())
                .nguoiPhanCong(request.getNguoiPhanCong())
                .nguoiThucHien(request.getNguoiThucHien())
                .ngayBatDau(request.getNgayBatDau())
                .ngayHoanThanh(request.getNgayHoanThanh())
                .thoiHan(request.getThoiHan())
                .trangThai(request.getTrangThai())
                .moTa(request.getMoTa())
                .build();

        task = taskRepository.save(task);
        return task.getId();
    }

    @Override
    public Map<String, Integer> getTaskStatusCounts() {
        Map<String, Integer> counts = new LinkedHashMap<>();

        int chuaBatDau = taskRepository.countByTrangThai("chưa bắt đầu");
        int dangTienHanh = taskRepository.countByTrangThai("đang tiến hành");
        int kiemTra = taskRepository.countByTrangThai("kiểm tra");
        int hoanThanh = taskRepository.countByTrangThai("hoàn thành");
        int choXuLy = taskRepository.countByTrangThai("chờ xử lý");

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
    public Page<TaskResponseDTO> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable)
                .map(task -> TaskResponseDTO.builder()
                        .id(task.getId())
                        .ten(task.getTen())
                        .maCongTrinh(task.getMaCongTrinh())
                        .nguoiPhanCong(task.getNguoiPhanCong())
                        .nguoiThucHien(task.getNguoiThucHien())
                        .ngayBatDau(task.getNgayBatDau())
                        .ngayHoanThanh(task.getNgayHoanThanh())
                        .thoiHan(task.getThoiHan())
                        .trangThai(task.getTrangThai())
                        .moTa(task.getMoTa())
                        .build());
    }
}
