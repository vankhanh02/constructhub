import { Table, Select } from "antd";

const columns = [
  { title: "Mã đội thi công", dataIndex: "teamCode", key: "teamCode" },
  { title: "Công trình", dataIndex: "project", key: "project" },
  { title: "Số lượng thành viên", dataIndex: "members", key: "members" },
  { title: "Đội trưởng", dataIndex: "leader", key: "leader" },
  { title: "Số điện thoại", dataIndex: "phone", key: "phone" },
];

const data = [
  { key: 1, teamCode: "DTK001", project: "Dự án A", members: 8, leader: "Nguyễn Văn A", phone: "0988888888" },
];

export const SubcontractorTeam = () => {
  return (
    <div className="p-4 bg-white rounded-xl shadow-md min-h-[320px]">
       <div className="flex justify-between mb-2">
        <h3 className="text-base font-semibold">Đội thầu khoán</h3>
        <Select defaultValue="Công trình" options={[{ value: "Công trình", label: "Công trình" }]} />
      </div>
      <Table columns={columns} dataSource={data} pagination={false} />
    </div>
  );
};