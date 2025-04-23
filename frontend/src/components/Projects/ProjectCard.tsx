// src/components/ProjectCard.tsx
interface ProjectCardProps {
    id: number;
    name: string;
    address: string;
    status: string;
    startDate: string;
    endDate: string;
    investor: string;
    progress: number;
  }
  
  export const ProjectCard = ({
    name,
    address,
    status,
    startDate,
    endDate,
    investor,
    progress,
  }: ProjectCardProps) => {
    return (
      <div className="border rounded-xl p-4 shadow-sm bg-white">
        <div className="flex justify-between items-center">
          <h3 className="text-lg font-bold">{name}</h3>
          <span className={`px-2 py-1 rounded text-white text-sm ${
            status === "Đang triển khai" ? "bg-yellow-500" : "bg-blue-600"
          }`}>
            {status}
          </span>
        </div>
        <p className="text-sm text-gray-600 mt-1">{address}</p>
        <div className="mt-2 text-sm">
          <p><strong>Thời gian:</strong> {startDate} - {endDate}</p>
          <p><strong>Chủ đầu tư:</strong> {investor}</p>
          <div className="mt-2">
            <strong>Tiến độ:</strong>
            <div className="w-full bg-gray-200 h-2 rounded mt-1">
              <div className="bg-green-500 h-2 rounded" style={{ width: `${progress}%` }}></div>
            </div>
          </div>
        </div>
      </div>
    );
  };
  