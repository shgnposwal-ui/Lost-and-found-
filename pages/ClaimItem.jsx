// import React from "react";
// import ClaimForm from "../components/ClaimForm";
//
// function ClaimItem() {
//     return (
//         <div className="container mt-5">
//             <h2 className="text-center mb-4">Claim Found Item</h2>
//
//             <div
//                 className="card shadow p-4"
//                 style={{ maxWidth: "700px", margin: "auto" }}
//             >
//                 <h4>Item Details</h4>
//
//                 <p><strong>Item Name:</strong> Black Backpack</p>
//                 <p><strong>Category:</strong> Bag</p>
//                 <p><strong>Found Location:</strong> Library</p>
//                 <p><strong>Found Date:</strong> 25 July 2026</p>
//
//                 <hr />
//
//                 <ClaimForm />
//             </div>
//         </div>
//     );
// }
//
// export default ClaimItem;

import { useState } from "react";

function ClaimItem() {

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        phone: "",
        reason: ""
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        alert("Claim submitted successfully!");
    };

    return (
        <div className="container mt-4">

            <h2>Claim Item</h2>

            <div className="card p-4 shadow">

                <h4>Item Details</h4>

                <p><b>Item Name:</b> Laptop</p>
                <p><b>Location:</b> Library</p>
                <p><b>AI Match Score:</b> 92%</p>

                <hr />

                <h4>Claim Form</h4>

                <form onSubmit={handleSubmit}>

                    <input
                        className="form-control mb-3"
                        type="text"
                        name="name"
                        placeholder="Enter Name"
                        onChange={handleChange}
                    />

                    <input
                        className="form-control mb-3"
                        type="email"
                        name="email"
                        placeholder="Enter Email"
                        onChange={handleChange}
                    />

                    <input
                        className="form-control mb-3"
                        type="text"
                        name="phone"
                        placeholder="Enter Phone Number"
                        onChange={handleChange}
                    />

                    <textarea
                        className="form-control mt-4 mb-3"
                        name="reason"
                        placeholder="Provide details about the item"
                        rows="4"
                        onChange={handleChange}
                    ></textarea>

                    <button className="btn btn-primary">
                        Submit Claim
                    </button>

                </form>

            </div>

        </div>
    );
}

export default ClaimItem;

