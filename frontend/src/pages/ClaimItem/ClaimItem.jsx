import { useState } from "react";
import "./ClaimItem.css";

function ClaimItem() {

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        phone: "",
        reason: "",
        proof: ""
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
        <div className="claim-page">

            <div className="claim-container">

                <h1>Claim Item</h1>

                <p className="claim-subtitle">
                    Fill in the details below to claim this item
                </p>

                <form onSubmit={handleSubmit}>

                    <div className="claim-grid">

                        <div className="claim-field">
                            <label>Item Name</label>
                            <input
                                type="text"
                                name="name"
                                placeholder="Enter item name"
                                value={formData.name}
                                onChange={handleChange}
                            />
                        </div>

                        <div className="claim-field">
                            <label>Found Location</label>
                            <input
                                type="text"
                                placeholder="Enter found location"
                            />
                        </div>

                        <div className="claim-field">
                            <label>Found Date</label>
                            <input
                                type="date"
                            />
                        </div>

                        <div className="claim-field">
                            <label>Why do you think this is yours?</label>
                            <textarea
                                name="reason"
                                placeholder="Describe identifying details..."
                                rows="5"
                                value={formData.reason}
                                onChange={handleChange}
                            ></textarea>
                        </div>

                    </div>

                    <div className="proof-section">

                        <label>Upload Proof</label>

                        <div className="upload-box">
                            <div className="upload-icon">☁️</div>

                            <p>Click to upload proof</p>

                            <span>
                                Upload an image or document as proof of ownership
                            </span>

                            <input
                                type="file"
                                name="proof"
                                onChange={handleChange}
                            />
                        </div>

                    </div>

                    <button type="submit" className="submit-claim">
                        Submit Claim
                    </button>

                </form>

            </div>

        </div>
    );
}

export default ClaimItem;