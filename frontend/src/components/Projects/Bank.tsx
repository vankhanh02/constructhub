import { PieChart, Pie, Cell, Legend, Tooltip } from "recharts";

const data = [
  { name: "Vật tư", value: 975 },
  { name: "Thiết bị", value: 643 },
  { name: "Nhân công", value: 825 },
  { name: "Khác", value: 405 },
];

const COLORS = ["#AB47BC", "#FF9800", "#00BCD4", "#64B5F6"];

const CustomLegend = () => (
  <div className="grid grid-cols-2 gap-x-8 gap-y-2 mt-4 text-sm text-left">
    {data.map((entry, index) => (
      <div key={index} className="flex items-center space-x-2">
        <span
          className="w-3 h-3 rounded-full inline-block"
          style={{ backgroundColor: COLORS[index] }}
        ></span>
        <span>{entry.name}</span>
      </div>
    ))}
  </div>
);

export const Bank = () => {
  return (
    <div className="bg-white p-4 rounded-xl shadow-md h-[360px] flex flex-col">
      <h3 className="text-lg font-semibold text-blue-800 mb-4">Phân bổ ngân sách</h3>
      <div className="self-center">
        <PieChart width={200} height={200}>
          <Pie
            data={data}
            cx="50%"
            cy="50%"
            outerRadius={80}
            dataKey="value"
          >
            {data.map((entry, index) => (
              <Cell key={`cell-${index}`} fill={COLORS[index]} stroke="#fff" />
            ))}
            </Pie>
            <Tooltip />
            </PieChart>
        <CustomLegend />
        </div>
      </div>
  );
};