import "./Dashboard.css";

function Dashboard() {
  return (
    <div className="dashboard">

      {/* Sidebar */}

      <aside className="sidebar">

        <div className="logo">
          <h2>Campus Lost & Found</h2>
        </div>

        <ul className="menu">

          <li className="active">
            🏠 Dashboard
          </li>

          <li>
            📢 Report Lost
          </li>

          <li>
            📦 Found Items
          </li>

          <li>
            🤖 AI Match
          </li>

          <li>
            📄 Claim Item
          </li>

          <li>
            📊 Analytics
          </li>

          <li>
            👨‍💼 Admin
          </li>

        </ul>

      </aside>

      {/* Main Content */}

      <main className="content">

        {/* Top Bar */}

        <div className="topbar">

          <div>
            <h1>Dashboard</h1>

            <p>
              Welcome back 👋
            </p>
          </div>

          <div className="profile">

            <img
              src="https://i.pravatar.cc/100"
              alt="profile"
            />

            <div>

              <h4>Admin User</h4>

              <span>Administrator</span>

            </div>

          </div>

        </div>

        {/* Cards */}

        <div className="cards">

          <div className="card blue">

            <h3>Total Reports</h3>

            <h1>124</h1>

            <p>+12 this week</p>

          </div>

          <div className="card green">

            <h3>Matched Items</h3>

            <h1>85</h1>

            <p>68% Success</p>

          </div>

          <div className="card orange">

            <h3>Pending Claims</h3>

            <h1>17</h1>

            <p>Need Verification</p>

          </div>

          <div className="card purple">

            <h3>Resolved</h3>

            <h1>91</h1>

            <p>Excellent</p>

          </div>

        </div>

        {/* Bottom Section */}

        <div className="bottom-section">

          {/* Recent Matches */}

          <div className="recent">

            <h2>Recent Matches</h2>

            <div className="match-card">

              <img
                src="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=200"
                alt=""
              />

              <div>

                <h3>Black Backpack</h3>

                <p>
                  Matched with Found Item
                </p>

              </div>

            </div>

            <div className="match-card">

              <img
                src="https://images.unsplash.com/photo-1511499767150-a48a237f0083?w=200"
                alt=""
              />

              <div>

                <h3>Wallet</h3>

                <p>
                  Claim Pending
                </p>

              </div>

            </div>

          </div>

          {/* Notifications */}

          <div className="notifications">

            <h2>Notifications</h2>

            <ul>

              <li>
                ✅ New Lost Item Reported
              </li>

              <li>
                📦 Item Successfully Matched
              </li>

              <li>
                👤 New Claim Request
              </li>

              <li>
                🔔 Admin Approval Pending
              </li>

            </ul>

          </div>

        </div>

      </main>

    </div>
  );
}

export default Dashboard;