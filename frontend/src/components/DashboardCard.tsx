import React from "react";
import { Building2 } from "lucide-react";
import { cn } from "@/lib/utils";

interface DashboardCardProps {
  title: string;
  count: number;
  subtitle?: string;
  icon?: React.ReactNode;
  className?: string;
  iconClassName?: string;
  bgColor?: string;
}

const DashboardCard: React.FC<DashboardCardProps> = ({
  title,
  count,
  subtitle,
  icon = <Building2 className="w-6 h-6 text-blue-500" />,
  className = "",
  iconClassName = "bg-icon-color",
  bgColor = "bg-white",
}) => {
  return (
    <div
      className={cn(
        `${bgColor} rounded-lg p-4 shadow-sm hover:shadow-md transition-shadow duration-200 min-w-[150px] w-auto items-center justify-center`,
        className
      )}
    >
      <div className="flex flex-col items-start gap-3">
        <div className={cn("p-2 rounded-full", iconClassName)}>{icon}</div>
        <div>
          <h3 className="text-sm font-medium text-blue-900">{title}</h3>
          <p className="text-2xl font-bold mt-1">{count}</p>
          {subtitle && <p className="text-xs text-gray-500 mt-1">{subtitle}</p>}
        </div>
      </div>
    </div>
  );
};

export default DashboardCard;
