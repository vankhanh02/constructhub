import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { Button } from "./ui/button";
const TodayTask = () => {
  return (
    <div className="bg-white p-5 rounded-lg shadow-sm">
      <div className="flex justify-between items-center mb-4">
        <h3 className="text-lg font-medium">Công việc ngày hôm nay</h3>
        <span className="text-sm text-red-500">Hôm nay: 01/01/2025</span>
      </div>
      <Table>
        <TableHeader>
          <TableRow>
            <TableHead className="w-[100px] bg-icon-color">Task</TableHead>
            <TableHead className="bg-icon-color">Công trình</TableHead>
            <TableHead className="bg-icon-color">Người thực hiện</TableHead>
            <TableHead className="bg-icon-color">Trạng thái</TableHead>
            <TableHead className="bg-icon-color">Thời hạn</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          <TableRow>
            <TableCell className="font-medium">Lắp đặt cốt thép</TableCell>
            <TableCell>Trung tâm thương mại Plaza</TableCell>
            <TableCell>Nguyễn Văn A</TableCell>
            <TableCell>
              <Button className="task-progress">Đang thực hiện</Button>
            </TableCell>
            <TableCell>01/01/2025</TableCell>
          </TableRow>
          <TableRow>
            <TableCell className="font-medium">Lắp đặt cốt thép</TableCell>
            <TableCell>Trung tâm thương mại Plaza</TableCell>
            <TableCell>Nguyễn Văn A</TableCell>
            <TableCell>
              <Button className="task-progress">Đang thực hiện</Button>
            </TableCell>
            <TableCell>01/01/2025</TableCell>
          </TableRow>
          <TableRow>
            <TableCell className="font-medium">Lắp đặt cốt thép</TableCell>
            <TableCell>Trung tâm thương mại Plaza</TableCell>
            <TableCell>Nguyễn Văn A</TableCell>
            <TableCell>
              <Button className="task-progress">Đang thực hiện</Button>
            </TableCell>
            <TableCell>01/01/2025</TableCell>
          </TableRow>
          <TableRow>
            <TableCell className="font-medium">Lắp đặt cốt thép</TableCell>
            <TableCell>Trung tâm thương mại Plaza</TableCell>
            <TableCell>Nguyễn Văn A</TableCell>
            <TableCell>
              <Button className="task-progress">Đang thực hiện</Button>
            </TableCell>
            <TableCell>01/01/2025</TableCell>
          </TableRow>
          <TableRow>
            <TableCell className="font-medium">Lắp đặt cốt thép</TableCell>
            <TableCell>Trung tâm thương mại Plaza</TableCell>
            <TableCell>Nguyễn Văn A</TableCell>
            <TableCell>
              <Button className="task-progress">Đang thực hiện</Button>
            </TableCell>
            <TableCell>01/01/2025</TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </div>
  );
};

export default TodayTask;
