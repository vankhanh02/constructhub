import { Separator } from "@/components/ui/separator";
import { SidebarTrigger } from "@/components/ui/sidebar";
import { Bell } from "lucide-react";
import profileImage from "@/assets/images/profile.png";
export function SiteHeader() {
  return (
    <header className="w-full flex h-12 shrink-0 items-center gap-2 border-b transition-[width,height] ease-linear">
      <div className="flex w-full items-center justify-between">
        <div className="flex w-full items-center gap-1 px-4 lg:gap-2 lg:px-6">
          <SidebarTrigger className="-ml-1" />
          <Separator
            orientation="vertical"
            className="mx-2 data-[orientation=vertical]:h-4"
          />
        </div>
        <div className="flex items-center gap-3 pr-4 lg:gap-4 lg:pr-6 mr-4">
          <Bell className="h-5 w-5 text-muted-foreground mr-1" />
          <div className="flex items-center gap-3">
            <div className="flex flex-col w-auto">
              <p className="text-sm font-medium whitespace-nowrap">
                Anima Agrawal
              </p>
              <p className="text-xs text-muted-foreground whitespace-nowrap">
                U.P, India
              </p>
            </div>
            <img
              src={profileImage}
              className="h-9 w-9 rounded-full"
              alt="Profile"
            />
          </div>
        </div>
      </div>
    </header>
  );
}
