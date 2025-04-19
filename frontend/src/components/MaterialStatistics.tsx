import {
    BarChart,
    Bar,
    XAxis,
    YAxis,
    CartesianGrid,
    Tooltip,
    Legend,
    ResponsiveContainer,
  } from "recharts";
  import { Select } from "antd";
  
  const data = [
    { name: "Xi măng", used: 32.25, remaining: 67.75 },
    { name: "Sắt", used: 25.5, remaining: 74.5 },
    { name: "Thép", used: 33.33, remaining: 66.67 },
    { name: "Cát", used: 40, remaining: 60 },
    { name: "Đá", used: 35, remaining: 65 },
    { name: "Gạch", used: 11.22, remaining: 88.78 },
    { name: "Vữa", used: 45, remaining: 55 },
    { name: "Bê tông", used: 60, remaining: 40 },
    { name: "Phụ gia xây dựng", used: 20, remaining: 80 },
    { name: "Vật tư tường", used: 30, remaining: 70 },
    { name: "Vật tư trần", used: 25, remaining: 75 },
    { name: "Vật tư sàn", used: 40, remaining: 60 },
    { name: "Nội thất", used: 35, remaining: 65 },
    { name: "Ngoại thất", used: 30, remaining: 70 },
    { name: "Khác", used: 45, remaining: 55 },
  ];
  
  export const MaterialStatistics = () => {
    return (
      <div className="bg-white p-4 rounded-xl shadow-md my-4 w-full h-[500px]">
        <div className="flex justify-between items-center mb-2">
          <h3 className="text-lg font-semibold text-[#003366]">Thống kê vật tư</h3>
          <Select
            defaultValue="Tháng 03/2025"
            options={[{ value: "Tháng 03/2025", label: "Tháng 04/2025" }]}
            style={{ width: 150 }}
          />
        </div>
  
        <ResponsiveContainer width="100%" height={400}>
          <BarChart data={data}
                    barCategoryGap="40%" 
                    barGap={20}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="name" angle={-30} textAnchor="end" height={70} />
            <YAxis unit="%" domain={[0, 100]} />
            <Tooltip />
            <Legend
            content={() => (
                <div style={{ textAlign: 'center', marginTop: 30, lineHeight: '1.5' }}>
                <div>
                    <span
                    style={{
                        display: 'inline-block',
                        width: 10,
                        height: 10,
                        backgroundColor: '#3A7684',
                        marginRight: 8,
                        borderRadius: '50%',
                    }}
                    />
                    Vật tư còn lại trong kho
                </div>
                <div>
                    <span
                    style={{
                        display: 'inline-block',
                        width: 10,
                        height: 10,
                        backgroundColor: '#DE6868',
                        marginRight: 8,
                        borderRadius: '50%',
                    }}
                    />
                    Vật tư đang được sử dụng
                </div>
                </div>
            )}
            />

            <Bar
              dataKey="remaining"
              stackId="a"
              fill="#3A7684"
              name="Vật tư còn lại trong kho"
            />
            <Bar
              dataKey="used"
              stackId="a"
              fill="#DE6868"
              name="Vật tư đang được sử dụng"
            />
          </BarChart>
        </ResponsiveContainer>
      </div>
    );
  };
  