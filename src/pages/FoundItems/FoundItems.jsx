import "./FoundItems.css";
import {
  FaSearch,
  FaMapMarkerAlt,
  FaCalendarAlt,
  FaTag,
  FaArrowRight,
} from "react-icons/fa";

function FoundItems() {
  const items = [
    {
      id: 1,
      name: "Black Backpack",
      category: "Bag",
      location: "Central Library",
      date: "25 July 2026",
      status: "Available",
      image:
        "https://images.unsplash.com/photo-1581605405669-fcdf81165afa?w=800",
    },
    {
      id: 2,
      name: "Brown Wallet",
      category: "Wallet",
      location: "Cafeteria",
      date: "24 July 2026",
      status: "Available",
      image:
        "https://images.unsplash.com/photo-1627123424574-724758594e93?w=800",
    },
    {
      id: 3,
      name: "HP Laptop",
      category: "Laptop",
      location: "Computer Lab",
      date: "23 July 2026",
      status: "Claimed",
      image:
        "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=800",
    },
    {
      id: 4,
      name: "College ID Card",
      category: "ID Card",
      location: "Main Gate",
      date: "22 July 2026",
      status: "Available",
      image:
        "https://images.unsplash.com/photo-1516321318423-f06f85e504b3?w=800",
    },
    {
      id: 5,
      name: "Water Bottle",
      category: "Bottle",
      location: "Sports Ground",
      date: "21 July 2026",
      status: "Available",
      image:
        "https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=800",
    },
    {
      id: 6,
      name: "Boat Earbuds",
      category: "Electronics",
      location: "Seminar Hall",
      date: "20 July 2026",
      status: "Claimed",
      image:
        "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=800",
    },
  ];

  return (
    <div className="found-page">

      <div className="page-header">

        <div>
          <h1>Found Items</h1>
          <p>
            Browse recently found items on campus.
          </p>
        </div>

        <div className="header-right">

          <div className="search-box">
            <FaSearch />
            <input
              type="text"
              placeholder="Search item..."
            />
          </div>

          <select className="filter">
            <option>All Categories</option>
            <option>Bag</option>
            <option>Wallet</option>
            <option>Laptop</option>
            <option>ID Card</option>
            <option>Electronics</option>
          </select>

        </div>

      </div>

      <div className="cards-grid">

        {items.map((item) => (

          <div className="item-card" key={item.id}>

            <div className="image-box">

              <img
                src={item.image}
                alt={item.name}
              />

              <span
                className={
                  item.status === "Available"
                    ? "badge available"
                    : "badge claimed"
                }
              >
                {item.status}
              </span>

            </div>

            <div className="card-body">

              <h2>{item.name}</h2>

              <span className="category">
                <FaTag />
                {item.category}
              </span>

              <p>
                <FaMapMarkerAlt />
                {item.location}
              </p>

              <p>
                <FaCalendarAlt />
                {item.date}
              </p>

              <button>
                View Details
                <FaArrowRight />
              </button>

            </div>

          </div>

        ))}

      </div>

    </div>
  );
}

export default FoundItems;