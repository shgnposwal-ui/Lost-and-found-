import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "./pages/Login/Login";
import Register from "./pages/Register/Register";
import Dashboard from "./pages/Dashboard/Dashboard";
import ReportLost from "./pages/ReportLost/ReportLost";
import FoundItems from "./pages/FoundItems/FoundItems";
import Analytics from "./pages/Analytics/Analytics";
import AIMatchSuggestions from "./pages/AIMatchSuggestions/AIMatchSuggestions";
import ClaimItem from "./pages/ClaimItem/ClaimItem";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        {/* ================= AUTHENTICATION ================= */}

        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />


        {/* ================= MAIN PAGES ================= */}

        <Route path="/dashboard" element={<Dashboard />} />

        <Route
          path="/report-lost"
          element={<ReportLost />}
        />

        <Route
          path="/found-items"
          element={<FoundItems />}
        />

        <Route
          path="/analytics"
          element={<Analytics />}
        />


        {/* ================= AI MATCH ================= */}

        <Route
          path="/ai-match"
          element={<AIMatchSuggestions />}
        />


        {/* ================= CLAIM ITEM ================= */}

        <Route
          path="/claim-item"
          element={<ClaimItem />}
        />


        {/* ================= 404 PAGE ================= */}

        <Route
          path="*"
          element={
            <div
              style={{
                minHeight: "100vh",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                flexDirection: "column",
                background: "#f4f7fb",
                fontFamily: "Segoe UI, Arial, sans-serif",
              }}
            >
              <h1
                style={{
                  fontSize: "80px",
                  color: "#2563eb",
                  margin: "0 0 10px",
                }}
              >
                404
              </h1>

              <h2
                style={{
                  color: "#1f2937",
                  margin: "0 0 10px",
                }}
              >
                Page Not Found
              </h2>

              <p
                style={{
                  color: "#6b7280",
                  margin: 0,
                }}
              >
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