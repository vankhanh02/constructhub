import { PieChart, Pie, Cell } from "recharts";

type ProgressProps = {
  Progress: number;
};

export const Progress = ({ Progress }: ProgressProps) => {
  const data = [
    { name: "Hoàn thành", value: Progress },
    { name: "Chưa hoàn thành", value: 100 - Progress },
  ];

  const COLORS = ["#5DA1DB", "#E0E0E0"];

  return (
    <div className="bg-white rounded-xl p-4 shadow-md h-[360px] flex flex-col">
      <h3 className="text-lg font-semibold text-blue-800 text-center mb-4">Mức độ hoàn thành dự án</h3>
      <div className="relative self-center">
        <PieChart width={150} height={150}>
          <Pie
            data={data}
            cx="50%"
            cy="50%"
            innerRadius={50}
            outerRadius={65}
            startAngle={90}
            endAngle={-270}
            dataKey="value"
          >
            {data.map((_, index) => (
              <Cell key={`cell-${index}`} fill={COLORS[index]} />
            ))}
          </Pie>
        </PieChart>
        <div className="absolute top-1/2 left-1/2 text-xl font-bold text-black transform -translate-x-1/2 -translate-y-1/2">
          {Progress}%
        </div>
      </div>
    </div>
  );
};
