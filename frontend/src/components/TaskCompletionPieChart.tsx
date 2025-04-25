import { PieChart, Pie, Cell, Tooltip } from "recharts";

const data = [
  { name: "Quá hạn", value: 256, color: "#EF4444" },
  { name: "Đúng hạn", value: 375, color: "#3B82F6" },
];

export const TaskCompletionPieChart = () => {
  return (
    <div className="p-4 bg-white rounded-xl shadow-md min-h-[320px]">
      <h3 className="text-base font-semibold">Tổng quan công việc đã hoàn thành</h3>
      <PieChart width={300} height={200}>
        <Pie
          data={data}
          cx="50%"
          cy="50%"
          labelLine={false}
          outerRadius={70}
          fill="#8884d8"
          dataKey="value"
        >
          {data.map((entry, index) => (
            <Cell key={index} fill={entry.color} />
          ))}
        </Pie>
        <Tooltip />
      </PieChart>
      <div className="flex justify-around text-sm mt-2">
        {data.map((d, i) => (
          <div key={i} className="flex items-center gap-1">
            <span className="inline-block w-3 h-3 rounded-full" style={{ backgroundColor: d.color }}></span>
            {d.name}
          </div>
        ))}
      </div>
    </div>
  );
};
