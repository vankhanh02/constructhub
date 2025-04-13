import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarHeader,
} from "@/components/ui/sidebar";
// Menu items.
import {
  LayoutDashboard,
  SquareLibrary,
  UsersRound,
  Box,
  Drill,
  DollarSign,
} from "lucide-react";
const items = [
  {
    title: "Dashboard",
    url: "#",
    icon: LayoutDashboard,
  },
  {
    title: "Công trình",
    url: "#",
    icon: SquareLibrary,
  },
  {
    title: "Nhân Sự",
    url: "#",
    icon: UsersRound,
  },
  {
    title: "Vật tư",
    url: "#",
    icon: Box,
  },
  {
    title: "Máy móc",
    url: "#",
    icon: Drill,
  },
  {
    title: "Tài chính",
    url: "#",
    icon: DollarSign,
  },
];
import ConstructIcon from "@/assets/images/colorfilter.svg";
export function AppSidebar() {
  return (
    <Sidebar>
      <SidebarHeader>
        <SidebarMenu>
          <SidebarMenuItem>
            <SidebarMenuButton
              asChild
              className="data-[slot=sidebar-menu-button]:!p-1.5"
            >
              <a href="#">
                <img
                  src={ConstructIcon}
                  className="h-9 w-9"
                  alt="Construct logo"
                />
                <span className="text-base font-semibold">ConstructHub</span>
              </a>
            </SidebarMenuButton>
          </SidebarMenuItem>
        </SidebarMenu>
      </SidebarHeader>
      <SidebarContent>
        <SidebarGroup>
          <SidebarGroupContent>
            <SidebarMenu>
              {items.map((item) => (
                <SidebarMenuItem key={item.title}>
                  <SidebarMenuButton asChild className="px-4 py-6">
                    <a href={item.url} className="flex items-center gap-3">
                      <item.icon className="h-5 w-5" />
                      <span>{item.title}</span>
                    </a>
                  </SidebarMenuButton>
                </SidebarMenuItem>
              ))}
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>
      </SidebarContent>
    </Sidebar>
  );
}
