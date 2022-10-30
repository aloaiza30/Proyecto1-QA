import { Row } from 'react-bootstrap';
import { ArrowRight, Person, PersonCircle } from 'react-bootstrap-icons';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function AppNavBar() {
    return (
    <Navbar collapseOnSelect expand="lg" variant="dark" style={{backgroundColor: "#206ccb"}}>
        <Container>
        <Navbar.Brand className="fs-2 fw-bold" style={{fontFamily: "Montserrat"}} href="#home">Finance</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav"/>
        <Navbar.Collapse className= "d-flex" id="responsive-navbar-nav" style={{fontSize: "18px"}}>
            <Nav className='d-flex flex-fill nav-center justify-content-around'>
            <Nav.Link href="#invoices">Invoices</Nav.Link>
            <Nav.Link href="#savings">Savings</Nav.Link>
            <Nav.Link href="#wishlist">Wishlist</Nav.Link>
            <Nav.Link href="#settings">Settings</Nav.Link>
            <Nav.Link href="#profile" className='ml-auto'>
                <PersonCircle size={30} style={{padding: "0px 10px 0px 0px"}}/>
                John Doe
            </Nav.Link>
            </Nav>
        </Navbar.Collapse>
        </Container>
    </Navbar>
    );
}
export default AppNavBar;