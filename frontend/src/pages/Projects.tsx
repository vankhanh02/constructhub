import { Link } from "react-router-dom";

const projectList = [
  {
    id: 1,
    name: "Trung tâm thương mại Plaza",
    address: "126 Đ. Hồng Bàng, Phường 12, Quận 5, Hồ Chí Minh",
    status: "Hoàn thành",
    startDate: "01/01/2025",
    endDate: "01/10/2025",
    investor: "Công ty TNHH Xây dựng ABC",
    progress: 65,
  },
  {
    id: 2,
    name: "Trung tâm thương mại Plaza",
    address: "126 Đ. Hồng Bàng, Phường 12, Quận 5, Hồ Chí Minh",
    status: "Tạm dừng",
    startDate: "01/01/2025",
    endDate: "01/10/2025",
    investor: "Công ty TNHH Xây dựng ABC",
    progress: 65,
  },
  {
    id: 3,
    name: "Trung tâm thương mại Plaza",
    address: "126 Đ. Hồng Bàng, Phường 12, Quận 5, Hồ Chí Minh",
    status: "Đang thi công",
    startDate: "01/01/2025",
    endDate: "01/10/2025",
    investor: "Công ty TNHH Xây dựng ABC",
    progress: 65,
  },
  {
    id: 4,
    name: "Trung tâm thương mại Plaza",
    address: "126 Đ. Hồng Bàng, Phường 12, Quận 5, Hồ Chí Minh",
    status: "Đang thi công",
    startDate: "01/01/2025",
    endDate: "01/10/2025",
    investor: "Công ty TNHH Xây dựng ABC",
    progress: 65,
  },
];

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
    <div className="p-4 space-y-4">
      <h2 className="text-2xl font-semibold mb-4">Công trình</h2>
      <div className="overflow-x-auto">
        <table className="min-w-full bg-white border rounded-lg">
          <thead>
            <tr className="bg-gray-100 text-left text-sm text-gray-600">
              <th className="p-3">Mã công trình</th>
              <th className="p-3">Tên công trình</th>
              <th className="p-3">Địa điểm</th>
              <th className="p-3">Trạng thái</th>
              <th className="p-3">Ngày bắt đầu</th>
              <th className="p-3">Ngày kết thúc</th>
              <th className="p-3">Chủ đầu tư</th>
              <th className="p-3">Tiến độ</th>
            </tr>
          </thead>
          <tbody>
            {projectList.map((project) => (
              <tr key={project.id} className="border-t text-sm">
                <td className="p-3">{project.id}</td>
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
