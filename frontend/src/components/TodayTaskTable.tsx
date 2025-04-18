export const TodayTaskTable = () => {
    const tasks: any[] = []; // giả lập
  
    return (
      <div className="p-4 bg-white rounded-xl shadow-md min-h-[320px]">
        <div className="flex justify-between">
          <h3 className="text-base font-semibold">Công việc ngày hôm nay</h3>
          <span className="text-red-500">Today: 01/01/2025</span>
        </div>
        <div className="overflow-x-auto mt-2">
          <table className="w-full text-sm border">
            <thead>
              <tr className="bg-gray-100 text-left">
                <th className="p-2 border">Công việc</th>
                <th className="p-2 border">Công trình</th>
                <th className="p-2 border">Người thực hiện</th>
                <th className="p-2 border">Trạng thái</th>
                <th className="p-2 border">Thời hạn</th>
              </tr>
            </thead>
            <tbody>
              {tasks.length === 0 ? (
                <tr>
                  <td colSpan={5} className="text-center p-4 text-gray-500">Không có công việc hôm nay</td>
                </tr>
              ) : (
                tasks.map((task, index) => (
                  <tr key={index}>
                    <td className="p-2 border">{task.name}</td>
                    <td className="p-2 border">{task.project}</td>
                    <td className="p-2 border">{task.assignee}</td>
                    <td className="p-2 border">{task.status}</td>
                    <td className="p-2 border">{task.dueDate}</td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
      </div>
    );
  };
  