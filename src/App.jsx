import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "./pages/Login/Login";
import Register from "./pages/Register/Register";
import Dashboard from "./pages/Dashboard/Dashboard";
import ReportLost from "./pages/ReportLost/ReportLost";
import FoundItems from "./pages/FoundItems/FoundItems";
import Analytics from "./pages/Analytics/Analytics";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        {/* Authentication */}
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />

        {/* Main Pages */}
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/report-lost" element={<ReportLost />} />
        <Route path="/found-items" element={<FoundItems />} />
        <Route path="/analytics" element={<Analytics />} />

        {/* 404 Page */}
        <Route
          path="*"
          element={
            <div
              style={{
                height: "100vh",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                flexDirection: "column",
                background: "#f4f7fb",
                fontFamily: "Segoe UI",
              }}
            >
              <h1
                style={{
                  fontSize: "80px",
                  color: "#2563eb",
                  marginBottom: "10px",
                }}
              >
                404
              </h1>

              <h2
                style={{
                  color: "#1f2937",
                  marginBottom: "10px",
                }}
              >
                Page Not Found
              </h2>

              <p style={{ color: "#6b7280" }}>
                Sorry! The page you are looking for doesn't exist.
              </p>
            </div>
          }
        />

      </Routes>
    </BrowserRouter>
  );
}

export default App;