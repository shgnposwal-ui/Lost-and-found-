import "./ReportLost.css";
import {
  FaBoxOpen,
  FaCalendarAlt,
  FaMapMarkerAlt,
  FaCamera,
  FaAlignLeft,
} from "react-icons/fa";

function ReportLost() {
  return (
    <div className="report-page">

      <div className="report-header">

        <div>
          <h1>Report Lost Item</h1>
          <p>
            Fill in the details of your lost item. Our AI will help match it
            with found items.
          </p>
        </div>

      </div>

      <div className="report-card">

        <form>

          <div className="form-grid">

            <div className="form-group">

              <label>
                <FaBoxOpen className="icon" />
                Item Name
              </label>

              <input
                type="text"
                placeholder="Eg. Black Backpack"
              />

            </div>

            <div className="form-group">

              <label>
                <FaBoxOpen className="icon" />
                Category
              </label>

              <select>
                <option>Select Category</option>
                <option>Bag</option>
                <option>Wallet</option>
                <option>Mobile</option>
                <option>Laptop</option>
                <option>ID Card</option>
                <option>Keys</option>
                <option>Watch</option>
                <option>Bottle</option>
                <option>Other</option>
              </select>

            </div>

            <div className="form-group">

              <label>
                <FaCalendarAlt className="icon" />
                Lost Date
              </label>

              <input type="date" />

            </div>

            <div className="form-group">

              <label>
                <FaMapMarkerAlt className="icon" />
                Lost Location
              </label>

              <input
                type="text"
                placeholder="Library, Canteen, Lab..."
              />

            </div>

          </div>

          <div className="form-group">

            <label>
              <FaAlignLeft className="icon" />
              Description
            </label>

            <textarea
              rows="5"
              placeholder="Describe color, brand, unique marks, etc."
            ></textarea>

          </div>

          <div className="upload-box">

            <FaCamera className="camera-icon" />

            <h3>Upload Item Image</h3>

            <p>
              JPG, PNG (Max 5 MB)
            </p>

            <input type="file" />

          </div>

          <div className="buttons">

            <button
              type="reset"
              className="cancel-btn"
            >
              Cancel
            </button>

            <button
              type="submit"
              className="submit-btn"
            >
              Submit Report
            </button>

          </div>

        </form>

      </div>

    </div>
  );
}

export default ReportLost;