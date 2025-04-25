import { Link } from "react-router-dom";

export const Navbar = () => {
  return (
    <nav className="w-full h-12 flex items-center px-4 border-b bg-white shadow-sm justify-between">
      <h1 className="text-base font-medium">Dashboard</h1>
      <div className="space-x-4">
        <Link to="/" className="text-sm text-gray-600 hover:text-black">Dashboard</Link>
        <Link to="/projects" className="text-sm text-gray-600 hover:text-black">Công trình</Link>
      </div>
    </nav>
  );
};
