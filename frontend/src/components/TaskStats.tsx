"use client";

import {
  Bar,
  BarChart,
  CartesianGrid,
  LabelList,
  XAxis,
  YAxis,
} from "recharts";

import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import {
  type ChartConfig,
  ChartContainer,
  ChartTooltip,
  ChartTooltipContent,
} from "@/components/ui/chart";

// Updated data with blue color for all bars
const chartData = [
  { month: "Cần làm", desktop: 186, mobile: 80, color: "#D9D9D9" },
  { month: "Đang tiến hành", desktop: 305, mobile: 200, color: "#2081C3" },
  { month: "Kiểm tra", desktop: 237, mobile: 120, color: "#FB8C01" },
  { month: "Hoàn thành", desktop: 73, mobile: 190, color: "#67AC5B" },
  { month: "Chờ xử lý", desktop: 209, mobile: 130, color: "#07B6D3" },
];

const chartConfig = {
  desktop: {
    label: "Desktop",
    color: "#2196F3", // Changed to blue
  },
  mobile: {
    label: "Mobile",
    color: "#2196F3", // Changed to blue
  },
  label: {
    color: "#FFFFFF",
  },
  // Remaining config unchanged but all colors set to blue
  january: { label: "Cần làm", color: "#D9D9D9" },
  february: { label: "Đang tiến hành", color: "#2081C3" },
  march: { label: "Kiểm tra", color: "#FB8C01" },
  april: { label: "Hoàn thành", color: "#67AC5B" },
  may: { label: "Chờ xử lý", color: "#07B6D3" },
} satisfies ChartConfig;

export function TaskStats() {
  return (
    <Card>
      <CardHeader className="flex flex-row justify-between gap-2">
        <CardTitle>Công việc</CardTitle>
        <CardDescription>01/01/2025</CardDescription>
      </CardHeader>
      <CardContent>
        <ChartContainer config={chartConfig}>
          <BarChart
            accessibilityLayer
            data={chartData}
            layout="vertical"
            margin={{
              right: 16,
            }}
          >
            <CartesianGrid horizontal={false} />
            <YAxis
              dataKey="month"
              type="category"
              tickLine={false}
              tickMargin={10}
              axisLine={false}
              tickFormatter={(value) => value.slice(0, 3)}
              hide
            />
            <XAxis dataKey="desktop" type="number" hide />
            <ChartTooltip
              cursor={false}
              content={<ChartTooltipContent indicator="line" />}
            />
            <Bar
              dataKey="desktop"
              layout="vertical"
              radius={4}
              fill="#2196F3" // Set default fill to blue
              isAnimationActive={true}
            >
              <LabelList
                dataKey="month"
                position="insideLeft"
                offset={8}
                className="task-progress"
                fontSize={12}
                fill="#FFFFFF"
              />
              <LabelList
                dataKey="desktop"
                position="right"
                offset={8}
                className="task-progressd"
                fontSize={12}
              />
              {/* You can remove the Cell mapping if all bars should be the same color */}
            </Bar>
          </BarChart>
        </ChartContainer>
      </CardContent>
    </Card>
  );
}
