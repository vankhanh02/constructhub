import { BuildOutlined } from "@ant-design/icons";

export const MachineActive = () => {
  return (
    <div className="bg-white p-2 rounded-xl shadow-md w-full h-[205px]">
      <div className="flex flex-col items-center">
        <BuildOutlined style={{ fontSize: 40, color: "#595959", marginBottom: 8 }} />
        <h3 className="text-base font-semibold text-blue-900">Máy móc đang hoạt động</h3>
        <p className="text-3xl font-bold mt-2">30</p>
      </div>
    </div>
  );
};
