import { SidebarInset, SidebarProvider } from "@/components/ui/sidebar";
import { AppSidebar } from "@/components/AppSidebar";
import { SiteHeader } from "./components/SideHeader";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Dashboard } from "./pages/Dashboard";
import { Projects } from "@/pages/Projects";
import { ProjectDetail } from "./components/Projects/ProjectDetail";
import { Info } from "./components/Projects/Info";
import { Task } from "./components/Projects/Task";
import { Staff } from "./components/Projects/Staff";  
import { ProjectLayout } from "./components/Projects/ProjectLayout";

function App() {
  return (
    <SidebarProvider>
    <Router>
      <AppSidebar />
      <SidebarInset>
        <SiteHeader />
        <main className="p-4">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/projects" element={<Projects />} />
            <Route path="/projects/:id" element={<ProjectLayout />}>
              <Route index element={<ProjectDetail />} />
              <Route path="task" element={<Task />} />
              <Route path="staff" element={<Staff />} />
              <Route path="info" element={<Info />} />
            </Route>
          </Routes>
        </main>
      </SidebarInset>
    </Router>
  </SidebarProvider>
  );
}

export default App;
