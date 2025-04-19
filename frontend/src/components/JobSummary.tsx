export const JobSummary = () => {
  const stats = [
    { label: "Chưa bắt đầu", color: "bg-gray-300", value: 5 },
    { label: "Đang tiến hành", color: "bg-blue-500", value: 7 },
    { label: "Kiểm tra", color: "bg-orange-400", value: 3 },
    { label: "Hoàn thành", color: "bg-green-500", value: 5 },
    { label: "Chờ xử lý", color: "bg-teal-400", value: 3 },
  ];

  const total = stats.reduce((sum, s) => sum + s.value, 0);

  return (
    <div className="bg-white p-4 rounded-xl shadow-md border border-gray-200 w-full max-w-[540px]">
      <div className="flex justify-between items-center mb-2">
        <h3 className="text-base font-semibold text-blue-900">Công việc</h3>
        <span className="text-sm text-gray-500">Tháng 04/2025</span>
      </div>

      <div className="flex gap-4 items-start">
        <div className="flex flex-col items-center justify-center min-w-[80px]">
          <p className="text-3xl font-bold">{total}</p>
          <span className="text-sm text-gray-500">tasks</span>
        </div>

        <div className="flex-1 space-y-2">
          {stats.map((item, i) => (
            <div key={i} className="flex items-center gap-2">
              <span className="w-28 text-sm">{item.label}</span>
              <div className="flex-1 h-2 bg-gray-100 rounded-full overflow-hidden">
                <div
                  className={`${item.color} h-full`}
                  style={{ width: `${(item.value / total) * 100}%` }}
                />
              </div>
              <span className="text-sm text-gray-700 w-4 text-right">{item.value}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
