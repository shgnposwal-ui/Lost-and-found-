import "./App.css";
import { Routes, Route } from "react-router-dom";

import SearchFilter from "./pages/SearchFilter";
import ClaimItem from "./pages/ClaimItem";
import MyClaims from "./pages/MyClaims";
import AdminPanel from "./pages/AdminPanel";

function App() {
  return (
      <Routes>
        <Route path="/" element={<SearchFilter />} />
        <Route path="/claim" element={<ClaimItem />} />
        <Route path="/myclaims" element={<MyClaims />} />
          <Route path="/admin" element={<AdminPanel />} />
      </Routes>
  );
}

export default App;