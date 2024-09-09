import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faVideoSlash } from "@fortawesome/free-solid-svg-icons";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { NavLink } from "react-router-dom";
import "./Header.css"; // Import your custom CSS for styling

const Header = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container fluid>
        <Navbar.Brand className="d-flex align-items-center">
          <FontAwesomeIcon icon={faVideoSlash} className="me-2" size="lg" />
          <span className="brand-title">DG</span>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav className="me-auto">
            <NavLink className="nav-link" to="/">
              Home
            </NavLink>
            <NavLink className="nav-link" to="/watchList">
              Watch List
            </NavLink>
            <NavLink className="nav-link" to="/AddMovie">
              Add Movie
            </NavLink>
          </Nav>
          <div className="d-flex">
            <Button variant="outline-info" className="me-2">
              Login
            </Button>
            <Button variant="outline-info">Register</Button>
          </div>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;
