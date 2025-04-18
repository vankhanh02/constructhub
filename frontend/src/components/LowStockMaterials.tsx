import { Table, Select } from "antd";

const columns = [
  { title: "Mã vật tư", dataIndex: "code", key: "code" },
  { title: "Tên vật tư", dataIndex: "name", key: "name" },
  { title: "Công trình", dataIndex: "project", key: "project" },
  { title: "Đơn vị", dataIndex: "unit", key: "unit" },
  { title: "Số lượng", dataIndex: "quantity", key: "quantity" },
];

const data = [
  { key: 1, code: "VT001", name: "Xi măng", project: "Dự án A", unit: "bao", quantity: 10 },
];

export const LowStockMaterials = () => {
  return (
    <div className="p-4 bg-white rounded-xl shadow-md min-h-[320px]">
      <div className="flex justify-between mb-2">
        <h3 className="text-base font-semibold">Vật tư đang ở mức thấp</h3>
        <Select defaultValue="Công trình" options={[{ value: "Công trình", label: "Công trình" }]} />
      </div>
      <Table columns={columns} dataSource={data} pagination={false} />
    </div>
  );
};