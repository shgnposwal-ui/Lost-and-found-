import React, { useState } from "react";
import "./ClaimForm.css";
function ClaimForm() {
    const [formData, setFormData] = useState({
        reason: "",
        identificationMarks: "",
        proof: null,
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleFileChange = (e) => {
        setFormData({
            ...formData,
            proof: e.target.files[0],
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        alert("Claim Submitted Successfully!");
        console.log(formData);
    };

    return (
        <form className="claim-form"
              onSubmit={handleSubmit}>
            <div className="mb-3">
                <label className="form-label">Reason for Claim</label>
                <textarea
                    className="form-control"
                    name="reason"
                    rows="3"
                    placeholder="Explain why this item belongs to you..."
                    onChange={handleChange}
                    required
                ></textarea>
            </div>

            <div className="mb-3">
                <label className="form-label">Identification Marks</label>
                <textarea
                    className="form-control"
                    name="identificationMarks"
                    rows="2"
                    placeholder="Example: Red keychain, sticker, scratch..."
                    onChange={handleChange}
                    required
                ></textarea>
            </div>

            <div className="mb-3">
                <label className="form-label">Upload Proof (Optional)</label>
                <input
                    type="file"
                    className="form-control"
                    onChange={handleFileChange}
                />
            </div>

            <button type="submit" className="btn btn-success w-100">
                Submit Claim
            </button>
        </form>
    );
}

export default ClaimForm;