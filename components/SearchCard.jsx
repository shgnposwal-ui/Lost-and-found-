import { useNavigate } from "react-router-dom";

function SearchCard({ item }) {
    const navigate = useNavigate();

    return (
        <div className="card shadow-sm h-100">
            <img
                src={item.image}
                alt={item.name}
                className="card-img-top"
                style={{ height: "220px", objectFit: "cover" }}
            />

            <div className="card-body">
                <h5 className="card-title">{item.name}</h5>

                <p>
                    <strong>📍 Location:</strong> {item.location}
                </p>

                <p>
                    <strong>📅 Date:</strong> 20 May 2024
                </p>

                <p>
                    <strong>🤖 Match Score:</strong> 92%
                </p>

                <button
                    className="btn btn-primary w-100"
                    onClick={() => navigate("/claim")}
                >
                    View Details
                </button>
            </div>
        </div>
    );
}

export default SearchCard;