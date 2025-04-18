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
    <div className="bg-slate-50 min-h-screen py-4 space-y-4 px-4">
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
      <div className="grid grid-cols-2 sm:grid-cols-2 xl:grid-cols-2 gap-4">
        <TodayTaskTable />
        <TaskCompletionPieChart />
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
