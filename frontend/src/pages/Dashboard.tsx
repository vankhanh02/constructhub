import DashboardCard from "@/components/DashboardCard";
import { Building2, Users, Drill, Wrench } from "lucide-react";

export const Dashboard = () => {
  return (
    <div className="p-6">
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-5 gap-4">
        {/* Card 1: Đang thi công */}
        <DashboardCard
          title="Đang thi công"
          count={3}
          subtitle="công trình"
          icon={<Building2 className="w-6 h-6 text-iconcolor" />}
        />

        {/* Card 2: Đang giám sát */}
        <DashboardCard
          title="Đang giám sát"
          count={5}
          subtitle="đội thầu khoán"
          icon={<Users className="w-6 h-6 text-gray-600" />}
        />

        {/* Card 3: Công việc with Progress bars */}
        <div className="bg-white p-5 rounded-lg shadow-sm">
          <h3 className="text-lg font-medium mb-1">Công việc</h3>
          <div className="flex items-baseline gap-2">
            <span className="text-3xl font-bold">25</span>
            <span className="text-sm text-gray-500">tasks</span>
          </div>
          <div className="mt-4 text-right text-xs text-gray-500">
            Tháng 03/2025
          </div>
        </div>

        {/* Card 4: Máy móc đang hoạt động */}
        <DashboardCard
          title="Máy móc đang hoạt động"
          count={30}
          icon={<Drill className="w-6 h-6 text-gray-600" />}
        />

        {/* Card 5: Máy móc cần bảo trì, sửa chữa */}
        <DashboardCard
          title="Máy móc cần bảo trì, sửa chữa"
          count={25}
          icon={<Wrench className="w-6 h-6 text-gray-600" />}
        />
      </div>
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white p-5 rounded-lg shadow-sm">
          <div className="flex justify-between items-center mb-4">
            <h3 className="text-lg font-medium">Công việc ngày hôm nay</h3>
            <span className="text-sm text-red-500">Today: 01/01/2025</span>
          </div>
        </div>
        <div className="bg-white p-5 rounded-lg shadow-sm">
          <h3 className="text-lg font-medium mb-4">
            Tổng quan công việc đã hoàn thành
          </h3>
        </div>
      </div>
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white p-5 rounded-lg shadow-sm">
          <div className="flex justify-between items-center mb-4">
            <h3 className="text-lg font-medium">Công việc ngày hôm nay</h3>
            <span className="text-sm text-red-500">Today: 01/01/2025</span>
          </div>
        </div>
        <div className="bg-white p-5 rounded-lg shadow-sm">
          <h3 className="text-lg font-medium mb-4">
            Tổng quan công việc đã hoàn thành
          </h3>
        </div>
      </div>
      <div className="bg-white p-5 rounded-lg shadow-sm mb-6">
        <div className="flex justify-between items-center mb-4">
          <h3 className="text-lg font-medium">Thống kê vật tư</h3>
        </div>
      </div>
    </div>
  );
};
