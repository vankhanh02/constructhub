import {
    BarChart,
    Bar,
    XAxis,
    YAxis,
    CartesianGrid,
    ResponsiveContainer,
    LabelList,
    Cell,
  } from "recharts";
  import { Select } from "antd";
  
  const ganttData = [
    { task: "Chuẩn bị mặt bằng", start: 0, duration: 2, color: "#3B82F6" },
    { task: "Thiết kế & xin giấy phép", start: 0, duration: 4, color: "#60A5FA" },
    { task: "Thi công móng", start: 2, duration: 3, color: "#D6A355" },
    { task: "Xây thô (khung, tường)", start: 5, duration: 4, color: "#C18C43" },
    { task: "Hệ thống điện, nước", start: 6, duration: 3, color: "#FB923C" },
    { task: "Hoàn thiện nội thất", start: 9, duration: 2, color: "#F97316" },
    { task: "Kiểm tra bàn giao", start: 11, duration: 1, color: "#22C55E" },
  ];
  
  const timeLabels = Array.from({ length: 12 }, (_, i) => ({
    value: i + 0.5,
    label: "3/3-9/3",
  }));
  
  export const ProjectGant = () => {
    return (
      <div className="bg-white p-4 rounded-xl shadow-md my-4 w-full h-[500px]">
        <div className="flex justify-between items-center mb-2">
          <h3 className="text-lg font-semibold text-[#003366]">Biểu đồ gantt</h3>
          <Select
            defaultValue="Tháng 03/2025"
            options={[{ value: "Tháng 03/2025", label: "Tháng 03/2025" }]}
            style={{ width: 150 }}
          />
        </div>
  
        <ResponsiveContainer width="100%" height={420}>
          <BarChart
            layout="vertical"
            width={1000}
            height={400}
            data={ganttData}
            margin={{ top: 20, right: 30, left: 100, bottom: 20 }}
            barCategoryGap={20}
          >
            <CartesianGrid stroke="#ccc" vertical />
            <XAxis
                type="number"
                domain={[0, 12]}
                tickLine={false}
                axisLine={{ stroke: "#2563EB" }}
                ticks={timeLabels.map((t) => t.value)}
                tick={({ x, y, payload }) => {
                    const label = timeLabels.find(t => t.value === payload.value)?.label;
                    return (
                    <text
                        x={x}
                        y={y + 10}
                        textAnchor="middle"
                        fontSize={11}
                        fill="#2563EB"
                    >
                        {label}
                    </text>
                    );
                }}
                />
            <YAxis
              type="category"
              dataKey="task"
              tick={{ fontSize: 13 }}
              width={180}
              axisLine={false}
            />
            <Bar dataKey="start" stackId="a" fill="transparent" />
            <Bar dataKey="duration" stackId="a" barSize={20} isAnimationActive={false}>
              <LabelList dataKey="duration" position="insideRight" />
              {ganttData.map((entry, index) => (
                <Cell key={`cell-${index}`} fill={entry.color} />
              ))}
            </Bar>
          </BarChart>
        </ResponsiveContainer>
      </div>
    );
  };
  