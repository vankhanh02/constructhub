import { useState } from "react";
import {
  PlusCircle,
  PenLine,
  Trash2,
  ChevronDown,
  ChevronRight,
  X,
} from "lucide-react";

const taskGroups = [
  { title: "Cần làm", color: "bg-blue-600", count: 3 },
  { title: "Đang thực hiện", color: "bg-blue-400", count: 3 },
  { title: "Kiểm Tra", color: "bg-orange-400", count: 3 },
  { title: "Hoàn thành", color: "bg-green-600", count: 3 },
  { title: "Chờ xử lý", color: "bg-blue-300", count: 3 },
];

const dummyTasks = [
  {
    id: 1,
    name: "Lắp đặt cốt thép",
    assignedBy: "Nguyễn Văn A",
    assignedTo: "Đội thi công B",
    startDate: "2025-01-01",
    deadline: "2025-01-01",
    createdAt: "2025-01-01 10:00:00",
  },
  {
    id: 2,
    name: "Đổ bê tông sàn tầng 1",
    assignedBy: "Nguyễn Văn A",
    assignedTo: "Đội thi công B",
    startDate: "2025-01-01",
    deadline: "2025-01-01",
    createdAt: "2025-01-01 10:30:00",
  },
];

export const Task = () => {
  const [expandedGroups, setExpandedGroups] = useState(
    new Set(["Cần làm", "Đang thực hiện"])
  );
  const [editingTask, setEditingTask] = useState<any | null>(null);

  const toggleGroup = (title: string) => {
    setExpandedGroups((prev) => {
      const newSet = new Set(prev);
      newSet.has(title) ? newSet.delete(title) : newSet.add(title);
      return newSet;
    });
  };

  return (
    <div className="p-4 bg-white rounded shadow w-full space-y-4">
      <div className="flex flex-wrap items-center justify-between mb-4 gap-2">
        <button className="flex items-center gap-2 px-3 py-2 text-white bg-blue-600 rounded hover:bg-blue-700">
          <PlusCircle size={18} /> Thêm task
        </button>
        <div className="flex items-center gap-2">
          <label htmlFor="task-view">Task View:</label>
          <select id="task-view" className="border px-2 py-1 rounded">
            <option>Chọn thời gian</option>
          </select>
        </div>
      </div>

      <div className="flex items-center mb-4">
        <input
          title="Thời gian tạo"
          placeholder="Tìm kiếm task"
          type="text"
          className="w-1/3 p-2 border rounded"
        />
      </div>

      {taskGroups.map((group) => (
        <div
          key={group.title}
          className="border rounded bg-gray-50 overflow-hidden"
        >
          <div
            className="flex items-center justify-between px-4 py-2 cursor-pointer"
            onClick={() => toggleGroup(group.title)}
          >
            <div className="flex items-center gap-2 font-semibold">
              <div className={`w-2 h-2 rounded-full ${group.color}`} />
              {group.title}
            </div>
            <div className="flex items-center gap-2">
              <span className="text-xs bg-gray-200 px-2 rounded">
                {group.count}
              </span>
              {expandedGroups.has(group.title) ? (
                <ChevronDown size={16} />
              ) : (
                <ChevronRight size={16} />
              )}
            </div>
          </div>

          {expandedGroups.has(group.title) && (
            <div className="overflow-x-auto">
              <table className="min-w-full text-sm border-t">
                <thead className="bg-white border-b">
                  <tr>
                    <th className="p-2 text-left">#</th>
                    <th className="p-2 text-left">Tên task</th>
                    <th className="p-2 text-left">Người phân công</th>
                    <th className="p-2 text-left">Người thực hiện</th>
                    <th className="p-2 text-left">Ngày bắt đầu</th>
                    <th className="p-2 text-left">Thời hạn</th>
                    <th className="p-2 text-left">Thời gian tạo</th>
                    <th className="p-2 text-left">Hành động</th>
                  </tr>
                </thead>
                <tbody>
                  {dummyTasks.map((task, i) => (
                    <tr key={task.id} className="border-t">
                      <td className="p-2">{i + 1}</td>
                      <td className="p-2">{task.name}</td>
                      <td className="p-2">{task.assignedBy}</td>
                      <td className="p-2">{task.assignedTo}</td>
                      <td className="p-2">{task.startDate}</td>
                      <td className="p-2">{task.deadline}</td>
                      <td className="p-2">{task.createdAt}</td>
                      <td className="p-2 space-x-2">
                        <button onClick={() => setEditingTask(task)}>
                          <PenLine className="text-green-600" size={18} />
                        </button>
                        <button>
                          <Trash2 className="text-red-500" size={18} />
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </div>
      ))}

      {editingTask && (
        <div className="fixed inset-0 backdrop-blur-sm bg-gray-100/50 flex items-center justify-center z-50">
          <div className="bg-white rounded shadow-lg w-[400px] p-4 relative">
            <div className="flex justify-between items-center mb-4">
              <h2 className="text-lg font-semibold">Chỉnh sửa task</h2>
              <button onClick={() => setEditingTask(null)}>
                <X size={20} />
              </button>
            </div>
            <form className="space-y-3">
              <div>
                <label className="block text-sm font-medium">Tên công việc:</label>
                <input className="w-full border rounded p-1" defaultValue={editingTask.name} placeholder="Nhập tên công việc" />
              </div>
              <div>
                <label className="block text-sm font-medium">Mô tả:</label>
                <textarea className="w-full border rounded p-1 h-20" placeholder="Nhập mô tả công việc" />
              </div>
              <div>
                <label className="block text-sm font-medium">Trạng thái:</label>
                <label htmlFor="task-status" className="block text-sm font-medium">Trạng thái:</label>
                <select id="task-status" className="w-full border rounded p-1">
                  <option>Đang thực hiện</option>
                  <option>Hoàn thành</option>
                  <option>Chờ xử lý</option>
                </select>
              </div>
              {editingTask?.assignedBy && (
              <div>
                <label className="block text-sm font-medium">Người phân công:</label>
                <input
                  className="w-full border rounded p-1"
                  defaultValue={editingTask.assignedBy || ""}
                  disabled
                />
              </div>
            )}
              <div>
                <label className="block text-sm font-medium">Người thực hiện:</label>
                <label htmlFor="assigned-to" className="block text-sm font-medium">Người thực hiện:</label>
                <select id="assigned-to" className="w-full border rounded p-1" defaultValue={editingTask.assignedTo}>
                  <option>Đội thi công A</option>
                  <option>Đội thi công B</option>
                </select>
              </div>
              <div className="flex gap-2">
                <div className="flex-1">
                  <label className="block text-sm font-medium">Ngày bắt đầu:</label>
                  <input
                    type="date"
                    className="w-full border rounded p-1"
                    defaultValue={editingTask.startDate}
                    title="Ngày bắt đầu"
                    placeholder="Chọn ngày bắt đầu"
                  />
                </div>
                <div className="flex-1">
                  <label className="block text-sm font-medium">Thời hạn:</label>
                  <input type="date" className="w-full border rounded p-1" defaultValue={editingTask.deadline} placeholder="Chọn thời hạn" />
                </div>
              </div>
              <div>
                <label className="block text-sm font-medium">Thời gian tạo:</label>
                <input
                  className="w-full border rounded p-1"
                  defaultValue={editingTask.createdAt}
                  disabled
                  title="Thời gian tạo"
                  placeholder="Thời gian tạo"
                />
              </div>
              <div className="text-right">
                <button
                  type="submit"
                  className="bg-blue-600 text-white px-4 py-1 rounded hover:bg-blue-700"
                >
                  Lưu
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};
