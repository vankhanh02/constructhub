import { AreaChart, Area, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, Legend } from "recharts";

const data = [
  { name: "23/02-1/3", percent: 100 },
  { name: "2/3-8/3", percent: 90 },
  { name: "9/3-15/3", percent: 95 },
  { name: "16/3-22/3", percent: 85 },
  { name: "23/3-29/3", percent: 90 },
];

export const Process = () => {
  return (
    <div className="bg-white p-4 rounded-xl shadow-md w-full max-w-2xl">
      <h3 className="text-blue-800 font-semibold mb-2">Tiến trình dự án</h3>
      <ResponsiveContainer width="100%" height={300}>
        <AreaChart data={data} margin={{ top: 10, right: 30, left: 0, bottom: 0 }}>
          <defs>
            <linearGradient id="colorPercent" x1="0" y1="0" x2="0" y2="1">
              <stop offset="5%" stopColor="#64B5F6" stopOpacity={0.8} />
              <stop offset="95%" stopColor="#64B5F6" stopOpacity={0.2} />
            </linearGradient>
          </defs>
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="name" />
          <YAxis domain={[75, 100]} tickFormatter={(value) => `${value}%`} />
          <Tooltip formatter={(value) => `${value}%`} />
          <Legend />
          <Area
            type="monotone"
            dataKey="percent"
            stroke="#64B5F6"
            fillOpacity={1}
            fill="url(#colorPercent)"
            name="Tỷ lệ task hoàn thành đúng hạn"
          />
        </AreaChart>
      </ResponsiveContainer>
    </div>
  );
};
