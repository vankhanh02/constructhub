import { useParams, NavLink, Outlet } from "react-router-dom";
import { useEffect, useState } from "react";
import { CalendarDays, MapPin, Wallet, Wrench } from "lucide-react";

const mockProject = {
  id: 1,
  name: "Trung tâm thương mại Plaza",
  type: "Dân dụng",
  address: "126 Đ. Hồng Bàng, Phường 12, Quận 5, Hồ Chí Minh",
  status: "Đang thi công",
  startDate: "01/01/2025",
  endDate: "31/12/2027",
  budget: "$200,000,000"
};

export const ProjectDetail = () => {
  const { id } = useParams();
  const [project, setProject] = useState(mockProject);

  useEffect(() => {
    setProject(mockProject);
  }, [id]);

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
    <div className="p-6 space-y-6">
      <div className="text-sm text-gray-500">
        <span className="font-medium text-gray-800">Công trình</span> &gt; {project.name}
      </div>

      <div className="flex space-x-6 border-b pb-2">
        <NavLink to="" end className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Tổng quan</NavLink>
        <NavLink to="task" className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Task</NavLink>
        <NavLink to="staff" className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Nhân sự</NavLink>
        <NavLink to="info" className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Thông tin</NavLink>
      </div>

      <div className="space-y-4">
        <div className="flex items-center justify-between">
          <h2 className="text-xl font-semibold">{project.name}</h2>
          <span className={`text-white px-3 py-1 text-sm rounded ${getStatusColor(project.status)}`}>{project.status}</span>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-4 gap-4 bg-gray-50 p-4 rounded-lg">
          <div className="flex items-start space-x-2">
            <Wrench className="text-blue-600" />
            <div>
              <div className="text-sm text-gray-500">Loại công trình:</div>
              <div className="font-medium text-sm">{project.type}</div>
            </div>
          </div>
          <div className="flex items-start space-x-2">
            <MapPin className="text-blue-600" />
            <div>
              <div className="text-sm text-gray-500">Địa điểm:</div>
              <div className="font-medium text-sm">{project.address}</div>
            </div>
          </div>
          <div className="flex items-start space-x-2">
            <CalendarDays className="text-blue-600" />
            <div>
              <div className="text-sm text-gray-500">Thời gian:</div>
              <div className="font-medium text-sm">{project.startDate} - {project.endDate}</div>
            </div>
          </div>
          <div className="flex items-start space-x-2">
            <Wallet className="text-blue-600" />
            <div>
              <div className="text-sm text-gray-500">Ngân sách:</div>
              <div className="font-medium text-sm">{project.budget}</div>
            </div>
          </div>
        </div>
      </div>

      <Outlet />
    </div>
  );
}