import "./Login.css";
import { Link } from "react-router-dom";

function Login() {
  return (
    <div className="Login-page">

      <div className="Login-card">

        <h2>Login</h2>

        <p className="subtitle">
          Welcome back! Please login to your account
        </p>

        <form>

          <div className="input-group">
            <label>Email</label>
            <input
              type="email"
              placeholder="Enter your email"
            />
          </div>

          <div className="input-group">
            <label>Password</label>
            <input
              type="password"
              placeholder="Enter your password"
            />
          </div>

          <div className="forgot">
            <a href="#">Forgot Password?</a>
          </div>

          <button type="submit">
            Login
          </button>

        </form>

        <p className="bottom-text">
          Don't have an account?
          <Link to="/register">
            Register here
          </Link>
        </p>

      </div>

    </div>
  );
}

export default Login;