import { Outlet, NavLink, useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { ChevronLeft } from "lucide-react";
import { projectList } from "@/components/Projects/ProjectList"; // Assuming you have a data file for project list

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

export const ProjectLayout = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  interface Project {
    id: number;
    name: string;
    address: string;
    status: string;
    startDate: string;
    endDate: string;
    investor: string;
    progress: number;
    type: string;
    budget: string;
  }
  
  const [project, setProject] = useState<Project | null>(null);

  useEffect(() => {
    const found = projectList.find((p) => p.id === Number(id));
    if (found) setProject(found);
  }, [id]);

  if (!project) return <div className="p-4 text-gray-600">Không tìm thấy công trình</div>;

  return (
    <div className="bg-slate-50 min-h-screen space-y-4">
      <div className="px-1 pt-0 pb-1 bg-white border-b border-gray-200 flex items-center gap-2">
        <button
          onClick={() => navigate("/projects")}
          className="flex items-center text-blue-600 hover:underline"
        >
          <ChevronLeft className="w-5 h-5 mr-1" />
        </button>
        <span className="text-xl font-semibold text-gray-800 ml-4">Công trình</span>
        <span className="text-gray-500"> &gt; {project.name}</span>
      </div>

      <div className="flex space-x-6 border-b pb-2">
        <NavLink to="" end className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Tổng quan</NavLink>
        <NavLink to="task" className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Task</NavLink>
        <NavLink to="staff" className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Nhân sự</NavLink>
        <NavLink to="info" className={({ isActive }: { isActive: boolean }) => isActive ? "text-blue-600 font-semibold" : "text-gray-500 hover:text-blue-600"}>Thông tin</NavLink>
      </div>

      <div className="px-2">

        <Outlet context={{ project }} />
      </div>
    </div>
  );
};