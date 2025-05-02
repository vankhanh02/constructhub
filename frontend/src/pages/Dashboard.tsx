import { LowStockMaterials } from "@/components/LowStockMaterials";
import { SubcontractorTeam } from "@/components/SubcontractorTeam";
import { MaterialStatistics } from "@/components/MaterialStatistics";
import { ProjectSummary } from "@/components/ProjectSummary";
import { TeamSummary } from "@/components/TeamSummary";
import { JobSummary } from "@/components/JobSummary";
import { TodayTaskTable } from "@/components/TodayTaskTable";
import { TaskCompletionPieChart } from "@/components/TaskCompletionPieChart";
import { MachineActive } from "@/components/MachineActive";
import { MaintenanceMachine } from "@/components/MaintenanceMachine";

export const Dashboard = () => {
  return (
    <div className="bg-slate-50 min-h-screen space-y-4">
      <div className="px-1 pt-0 pb-1 bg-white border-b border-gray-200">
        <h1 className="text-xl font-semibold text-gray-800">Dashboard</h1>
      </div>
      {/* Hàng 1: Các khối tóm tắt */}
      <div className="grid grid-cols-2 sm:grid-cols-6 xl:grid-cols-6 gap-4 w-fit mx-auto">
        <ProjectSummary />
        <TeamSummary />
        <div className="col-span-2">
          <JobSummary />
        </div>
        <MachineActive />
        <MaintenanceMachine />
      </div>

      {/* Hàng 2: Công việc hôm nay + biểu đồ tiến độ */}
      <div className="grid grid-cols-3 sm:grid-cols-5 xl:grid-cols-5 gap-4">
        
        <div className="col-span-3">
          <TodayTaskTable />
        </div>
        <div className="col-span-2"> 
        <TaskCompletionPieChart />
        </div>

      </div>

      {/* Hàng 3: Vật tư + đội thầu khoán */}
      <div className="grid grid-cols-1 sm:grid-cols-2 xl:grid-cols-2 gap-4">
        <LowStockMaterials />
        <SubcontractorTeam />
      </div>

      {/* Hàng 4: Thống kê vật tư */}
      <div>
        <MaterialStatistics />
      </div>
    </div>
  );
};
