import { useOutletContext } from "react-router-dom";
import { CalendarDays, MapPin, Wallet } from "lucide-react";
import { BuildOutlined } from "@ant-design/icons";
import { Process } from "./Process";
import { Progress } from "./Progress";
import { Bank } from "./Bank";

type ProjectType = {
  id: number;
  name: string;
  type: string;
  address: string;
  status: string;
  startDate: string;
  endDate: string;
  budget: string;
};

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

export const ProjectDetail = () => {
  const { project } = useOutletContext<{ project: ProjectType }>();

  return (
    <div className="bg-white p-4 rounded-xl shadow-md w-full space-y-4">
      {/* Tên công trình và trạng thái */}
      <div className="flex items-center gap-3">
        <h2 className="text-xl font-semibold text-gray-800">{project.name}</h2>
        <span
          className={`px-3 py-0.5 h-7 rounded-full text-sm text-white flex items-center ${getStatusColor(project.status)}`}
        >
          {project.status}
        </span>
      </div>

      {/* Thông tin chi tiết ngang */}
      <div className="flex flex-wrap md:flex-nowrap gap-4 bg-gray-100 p-4 rounded-xl">
        <div className="flex items-start gap-2 w-full md:w-1/4">
          <BuildOutlined style={{ fontSize: 28, color: "#595959" }} />
          <div>
            <div className="text-sm text-gray-500">Loại công trình:</div>
            <div className="font-medium text-sm">{project.type}</div>
          </div>
        </div>
        <div className="flex items-start gap-2 w-full md:w-1/4">
          <MapPin className="w-6 h-6 text-gray-600" />
          <div>
            <div className="text-sm text-gray-500">Địa điểm:</div>
            <div className="font-medium text-sm">{project.address}</div>
          </div>
        </div>
        <div className="flex items-start gap-2 w-full md:w-1/4">
          <CalendarDays className="w-6 h-6 text-gray-600" />
          <div>
            <div className="text-sm text-gray-500">Thời gian:</div>
            <div className="font-medium text-sm">
              {project.startDate} – {project.endDate}
            </div>
          </div>
        </div>
        <div className="flex items-start gap-2 w-full md:w-1/4">
          <Wallet className="w-6 h-6 text-gray-600" />
          <div>
            <div className="text-sm text-gray-500">Ngân sách:</div>
            <div className="font-medium text-sm">{project.budget}</div>
          </div>
        </div>
      </div>

      {/* Biểu đồ tổng hợp */}
      <div className="grid grid-cols-2 sm:grid-cols-4 xl:grid-cols-4 gap-4">
        <div className="col-span-1">
          <Progress Progress = {75}/>
        </div>
        <div className="col-span-1">
          <Bank />
        </div>
        <div className="col-span-2">
          <Process />
        </div>
      </div>
    </div>
  );
};
