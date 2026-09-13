import "./Analytics.css";
import {
  FaChartLine,
  FaBoxOpen,
  FaSearch,
  FaCheckCircle,
  FaClock
} from "react-icons/fa";

function Analytics() {
  return (
    <div className="analytics-page">

      <div className="analytics-header">
        <div>
          <h1>Analytics Dashboard</h1>
          <p>Track lost & found activities across campus.</p>
        </div>
      </div>

      {/* Top Cards */}

      <div className="stats-grid">

        <div className="stat-card blue">
          <FaBoxOpen className="stat-icon"/>
          <h2>248</h2>
          <p>Total Reports</p>
        </div>

        <div className="stat-card green">
          <FaCheckCircle className="stat-icon"/>
          <h2>189</h2>
          <p>Items Returned</p>
        </div>

        <div className="stat-card orange">
          <FaSearch className="stat-icon"/>
          <h2>42</h2>
          <p>Matching in Progress</p>
        </div>

        <div className="stat-card purple">
          <FaClock className="stat-icon"/>
          <h2>17</h2>
          <p>Pending Claims</p>
        </div>

      </div>

      {/* Analytics */}

      <div className="analytics-grid">

        <div className="chart-card">

          <h2>Monthly Performance</h2>

          <div className="progress">

            <span>January</span>
            <div className="bar">
              <div className="fill fill1"></div>
            </div>

          </div>

          <div className="progress">

            <span>February</span>
            <div className="bar">
              <div className="fill fill2"></div>
            </div>

          </div>

          <div className="progress">

            <span>March</span>
            <div className="bar">
              <div className="fill fill3"></div>
            </div>

          </div>

          <div className="progress">

            <span>April</span>
            <div className="bar">
              <div className="fill fill4"></div>
            </div>

          </div>

        </div>

        <div className="summary-card">

          <h2>AI Matching Accuracy</h2>

          <div className="circle">

            <FaChartLine />

            <h1>94%</h1>

          </div>

          <p>
            AI successfully matches most lost and found items with high accuracy.
          </p>

        </div>

      </div>

      {/* Recent Activity */}

      <div className="recent-card">

        <h2>Recent Activity</h2>

        <table>

          <thead>

            <tr>
              <th>Item</th>
              <th>Status</th>
              <th>Date</th>
            </tr>

          </thead>

          <tbody>

            <tr>
              <td>Black Backpack</td>
              <td className="success">Matched</td>
              <td>25 Jul 2026</td>
            </tr>

            <tr>
              <td>Wallet</td>
              <td className="pending">Pending</td>
              <td>24 Jul 2026</td>
            </tr>

            <tr>
              <td>HP Laptop</td>
              <td className="success">Returned</td>
              <td>22 Jul 2026</td>
            </tr>

            <tr>
              <td>ID Card</td>
              <td className="pending">Processing</td>
              <td>20 Jul 2026</td>
            </tr>

          </tbody>

        </table>

      </div>

    </div>
  );
}

export default Analytics;