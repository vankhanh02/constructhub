import { SidebarProvider } from "@/components/ui/sidebar";
import { AppSidebar } from "@/components/AppSidebar";
import { SiteHeader } from "./components/SideHeader";
import { Dashboard } from "./components/pages/Dashboard";
function App() {
  return (
    <SidebarProvider>
      <AppSidebar />
      <SiteHeader />
      <main>
        <Dashboard />
      </main>
    </SidebarProvider>
  );
}

export default App;
