import { Row } from 'react-bootstrap';
import { ArrowRight, BoxArrowRight, Person, PersonCircle } from 'react-bootstrap-icons';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import UserContext from '../UserContext';
import { useContext } from 'react';

function AppNavBar() {
    const { id, userName, lastName, signOut } = useContext(UserContext);

    return (
    <Navbar collapseOnSelect expand="lg" variant="dark" style={{backgroundColor: "#206ccb"}}>
        <Container>
        <Navbar.Brand className="fs-2 fw-bold" style={{fontFamily: 'Arial'}} href="/report">Finance</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav"/>
        <Navbar.Collapse className= "d-flex" id="responsive-navbar-nav" style={{fontSize: "18px"}}>
            <Nav className='d-flex flex-fill nav-center justify-content-around'>
            <Nav.Link href="#invoices">Invoices</Nav.Link>
            <Nav.Link href="/savings">Savings</Nav.Link>
            <Nav.Link href="#wishlist">Wishlist</Nav.Link>
            <Nav.Link href="#settings">Settings</Nav.Link>
            <Nav.Item>
                <Row className='flex-nowrap'>
                    <Nav.Link href="#profile" className='ml-auto'>
                        <PersonCircle size={32} style={{padding: "0px 10px 0px 0px"}}/>
                        { userName + " " + lastName }
                        {/* {localStorage.getItem("name") + " " + localStorage.getItem("lastname")} */}
                    </Nav.Link>
                    <Nav.Link onClick={signOut}>
                        <BoxArrowRight size={30}/>
                    </Nav.Link>
                </Row>
            </Nav.Item>
            </Nav>
        </Navbar.Collapse>
        </Container>
    </Navbar>
    );
}
export default AppNavBar;