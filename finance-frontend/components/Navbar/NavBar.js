/* Importing the components from the react-bootstrap library. */
import { Row } from 'react-bootstrap';
import { BoxArrowRight, PersonCircle } from 'react-bootstrap-icons';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import UserContext from '../UserContext';
import { useContext } from 'react';

/**
 * The AppNavBar function returns a Navbar component that contains the application name,
 * some other buttons which redirects to other pages in the application and a user icon
 * with the name of the user
 * @returns A Navbar component.
 */
 export default function AppNavBar() {
    /* Destructuring the context object. */
    const { userName, lastName, signOut } = useContext(UserContext);

    /* This is the HTML code that is rendered that contains all the NavBar functionalitites. */
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