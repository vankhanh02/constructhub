import { SidebarInset, SidebarProvider } from "@/components/ui/sidebar";
import { AppSidebar } from "@/components/AppSidebar";
import { SiteHeader } from "./components/SideHeader";
import { Navbar } from "./components/Navbar";
function App() {
  return (
    <SidebarProvider>
      <AppSidebar />
      <SidebarInset>
        <SiteHeader />
        <Navbar />
        <main></main>
      </SidebarInset>
    </SidebarProvider>
  );
}

export default App;
