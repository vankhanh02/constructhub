export const TeamSummary = () => {
  return (
    <div className="bg-white p-2 rounded-xl shadow-md w-full h-[205px]">
      <div className="flex flex-col items-center">
        <div className="text-4xl mb-2">👷‍♂️</div>
        <h3 className="text-base font-semibold text-blue-900">Đang giám sát</h3>
      </div>
      <div className="flex items-end space-x-1 flex justify-center">
        <span className="text-3xl font-bold">5</span>
        <span className="text-sm text-gray-500">đội thầu khoán</span>
      </div>
    </div>
  );
};
