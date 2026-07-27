import wallet from "../assets/images/wallet.jpg";
import bag from "../assets/images/bag.jpg";
import phone from "../assets/images/phone.jpg";
import { useState } from "react";
import SearchCard from "../components/SearchCard";

function SearchFilter() {

    const items = [
        {
            id: 1,
            name: "Black Wallet",
            category: "Wallet",
            location: "Library",
            status: "Lost",
            image: wallet
        },
        {
            id: 2,
            name: "Blue Bag",
            category: "Bag",
            location: "Cafeteria",
            status: "Found",
            image: bag
        },
        {
            id: 3,
            name: "Mobile Phone",
            category: "Electronics",
            location: "Parking",
            status: "Lost",
            image: phone
        }
    ];

    const [search, setSearch] = useState("");

    const filteredItems = items.filter((item) =>
        item.name.toLowerCase().includes(search.toLowerCase())
    );

    return (
        <div className="container mt-4">
            <h2 className="text-center mb-4">Search & Filter Items</h2>

            <div className="d-flex justify-content-between align-items-center mb-4">

                <input
                    type="text"
                    className="form-control me-3"
                    placeholder="🔍 Search Items..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                />
            </div>


            <div className="row">
                {filteredItems.map((item) => (
                    <div className="col-md-4" key={item.id}>
                        <SearchCard item={item} />
                    </div>
                ))}
            </div>
        </div>

    );
}

export default SearchFilter;