import React from "react";

function MyClaims() {
    return (
        <div className="container mt-5">
            <h2 className="text-center">My Claims</h2>

            <div className="card p-3 mt-4 shadow">
                <h5>Black Backpack</h5>
                <p>Status: <span className="text-warning">Pending</span></p>
            </div>
        </div>
    );
}

export default MyClaims;