import React, { useState } from "react";
import "./AIMatchSuggestions.css";

const sampleMatches = [
  {
    id: 1,
    name: "Black Wallet",
    date: "20 May 2024",
    location: "Library",
    score: 92,
    image:
      "https://images.unsplash.com/photo-1627123424574-724758594e93?w=500&auto=format&fit=crop",
  },
  {
    id: 2,
    name: "Black Wallet (Leather)",
    date: "14 May 2024",
    location: "Canteen",
    score: 75,
    image:
      "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=500&auto=format&fit=crop",
  },
  {
    id: 3,
    name: "Men's Wallet",
    date: "15 May 2024",
    location: "Parking",
    score: 60,
    image:
      "https://images.unsplash.com/photo-1601598851547-4302969d4d86?w=500&auto=format&fit=crop",
  },
];

function AIMatchSuggestions() {
  const [lostItem, setLostItem] = useState({
    name: "Black Wallet",
    date: "20 May 2024",
    location: "Library",
    image:
      "https://images.unsplash.com/photo-1627123424574-724758594e93?w=600&auto=format&fit=crop",
  });

  const [matches, setMatches] = useState(sampleMatches);
  const [selectedMatch, setSelectedMatch] = useState(null);

  const handleImageUpload = (event) => {
    const file = event.target.files?.[0];

    if (!file) return;

    const imageURL = URL.createObjectURL(file);

    setLostItem((prev) => ({
      ...prev,
      image: imageURL,
    }));
  };

  const handleView = (match) => {
    setSelectedMatch(match);
  };

  return (
    <div className="ai-match-page">
      {/* Header */}
      <div className="ai-match-header">
        <h1>Possible Matches for Your Item</h1>
        <p>We found some possible matches using AI</p>
      </div>

      {/* Main Content */}
      <div className="ai-match-container">

        {/* LEFT - YOUR LOST ITEM */}
        <section className="lost-item-section">
          <div className="section-title">
            <h2>Your Lost Item</h2>
          </div>

          <div className="lost-item-card">

            {/* Image */}
            <div className="lost-item-image-wrapper">
              {lostItem.image ? (
                <img
                  src={lostItem.image}
                  alt={lostItem.name}
                  className="lost-item-image"
                />
              ) : (
                <div className="image-placeholder">
                  No Image
                </div>
              )}

              <label className="change-image-btn">
                Change Image
                <input
                  type="file"
                  accept="image/*"
                  onChange={handleImageUpload}
                  hidden
                />
              </label>
            </div>

            {/* Details */}
            <div className="lost-item-details">
              <h3>{lostItem.name}</h3>

              <div className="detail-row">
                <span>Lost on:</span>
                <strong>{lostItem.date}</strong>
              </div>

              <div className="detail-row">
                <span>Location:</span>
                <strong>{lostItem.location}</strong>
              </div>
            </div>
          </div>
        </section>

        {/* RIGHT - TOP MATCHES */}
        <section className="top-matches-section">
          <div className="section-title">
            <h2>Top Matches</h2>
          </div>

          <div className="matches-card">

            {matches.length === 0 ? (
              <div className="no-matches">
                <h3>No matches found</h3>
                <p>Try uploading a clearer image.</p>
              </div>
            ) : (
              matches.map((match) => (
                <div className="match-item" key={match.id}>

                  {/* Match Image */}
                  <img
                    src={match.image}
                    alt={match.name}
                    className="match-image"
                  />

                  {/* Match Information */}
                  <div className="match-info">
                    <h3>{match.name}</h3>

                    <p>
                      <strong>Found on:</strong> {match.date}
                    </p>

                    <p>
                      <strong>Location:</strong> {match.location}
                    </p>

                    <p className="match-score">
                      Match Score:{" "}
                      <span>{match.score}%</span>
                    </p>
                  </div>

                  {/* View Button */}
                  <button
                    className="view-btn"
                    onClick={() => handleView(match)}
                  >
                    View
                  </button>
                </div>
              ))
            )}

          </div>
        </section>
      </div>

      {/* Match Details Modal */}
      {selectedMatch && (
        <div
          className="modal-overlay"
          onClick={() => setSelectedMatch(null)}
        >
          <div
            className="match-modal"
            onClick={(e) => e.stopPropagation()}
          >
            <button
              className="close-modal"
              onClick={() => setSelectedMatch(null)}
            >
              ×
            </button>

            <img
              src={selectedMatch.image}
              alt={selectedMatch.name}
              className="modal-image"
            />

            <h2>{selectedMatch.name}</h2>

            <div className="modal-details">
              <p>
                <strong>Found on:</strong> {selectedMatch.date}
              </p>

              <p>
                <strong>Location:</strong> {selectedMatch.location}
              </p>

              <p>
                <strong>AI Match Score:</strong>{" "}
                <span className="modal-score">
                  {selectedMatch.score}%
                </span>
              </p>
            </div>

            <button
              className="claim-btn"
              onClick={() => alert("Claim request submitted!")}
            >
              Claim This Item
            </button>
          </div>
        </div>
      )}
    </div>
  );
}

export default AIMatchSuggestions;
