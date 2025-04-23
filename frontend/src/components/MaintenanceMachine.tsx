import { Wrench } from "lucide-react";

export const MaintenanceMachine = () => {
  return (
    <div className="bg-white p-2 rounded-xl shadow-md w-full h-[205px]">
      <div className="flex flex-col items-center">
        <Wrench className="w-10 h-10 text-gray-700 mb-2" />
        <h3 className="text-base font-semibold text-blue-900 text-center">
          Máy móc cần bảo trì, <br /> sửa chữa
        </h3>
        <p className="text-3xl font-bold mt-2">25</p>
      </div>
    </div>
  );
};