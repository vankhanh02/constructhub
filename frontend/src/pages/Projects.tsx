import { Link } from "react-router-dom";
import { projectList } from "@/components/Projects/ProjectList"; // Assuming you have a data file for project list

export const Projects = () => {
  const getStatusColor = (status: string) => {
    switch (status) {
      case "Hoàn thành":
        return "bg-green-500";
      case "Tạm dừng":
        return "bg-orange-500";
      case "Đang thi công":
        return "bg-blue-500";
      default:
        return "bg-gray-400";
    }
  };

  return (
    <div className="bg-slate-50 min-h-screen space-y-4">
      <div className="px-1 pt-0 pb-1 bg-white border-b border-gray-200">
        <h1 className="text-xl font-semibold text-gray-800">Công trình</h1>
      </div>
      <div className="overflow-x-auto">
        <table className="min-w-full bg-white border rounded-lg">
          <thead>
            <tr className="bg-gray-100 text-left text-sm text-gray-600">
              <th className="p-2">Mã công trình</th>
              <th className="p-3">Tên công trình</th>
              <th className="p-3">Địa điểm</th>
              <th className="p-4">Trạng thái</th>
              <th className="p-3">Ngày bắt đầu</th>
              <th className="p-3">Ngày kết thúc</th>
              <th className="p-3">Chủ đầu tư</th>
              <th className="p-3">Tiến độ</th>
            </tr>
          </thead>
          <tbody>
            {projectList.map((project) => (
              <tr key={project.id} className="border-t text-sm">
                <td className="p-2">{project.id}</td>
                <td className="p-3 text-blue-600 font-medium hover:underline">
                  <Link to={`/projects/${project.id}`}>{project.name}</Link>
                </td>
                <td className="p-3">{project.address}</td>
                <td className="p-3">
                  <span className={`text-white px-2 py-1 rounded ${getStatusColor(project.status)}`}>
                    {project.status}
                  </span>
                </td>
                <td className="p-3">{project.startDate}</td>
                <td className="p-3">{project.endDate}</td>
                <td className="p-3">{project.investor}</td>
                <td className="p-3">
                  <div className="w-full bg-gray-200 h-2 rounded">
                    <div
                      className="bg-green-500 h-2 rounded"
                      style={{ width: `${project.progress}%` }}
                    ></div>
                  </div>
                  <div className="text-xs text-gray-600 mt-1">{project.progress}%</div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};