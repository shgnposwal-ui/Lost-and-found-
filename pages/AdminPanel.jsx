import { useState } from "react";
function AdminPanel() {
    const [status, setStatus] =
        useState("Pending");
    return (
        <div className="container mt-4">

            <h2>Admin Panel</h2>

            <div className="card shadow p-4 mt-4">

                <h4>Claim Requests</h4>

                <table className="table mt-4">

                    <thead>
                    <tr>
                        <th>Item</th>
                        <th>User</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>
                        <td>Laptop</td>
                        <td>Khushi</td>
                        <td>{status}</td>
                        <td>
                            <button className="btn btn-success me-2"
                            onClick={() => setStatus("Approved")}
                            >
                                Approve
                            </button>

                            <button className="btn btn-danger"
                            onClick={() => setStatus("Rejected")}
                            >
                                Reject
                            </button>
                        </td>
                    </tr>
                    </tbody>

                </table>

            </div>

        </div>
    );
}

export default AdminPanel;