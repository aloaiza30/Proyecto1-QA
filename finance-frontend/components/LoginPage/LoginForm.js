/* This is importing all the components that we need to use in this file. */
import { Card, Form, ModalTitle, NavLink, Row } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import { useContext, useState } from 'react';
import UserContext from '../UserContext';

import axios from 'axios';


/**
 * This function renders a form that allows the user to enter their email and password. When the user
 * clicks the submit button, the function sends a POST request to the backend with the user's email and
 * password. If the user's credentials are valid, the backend will return the user model. The function
 * then stores the user in the browser's local storage and redirects the user to the report page
 * @returns A login form
 */
export default function LoginForm() {
    /* This is declaring the variables that we will use in this file. */
    const { signIn } = useContext(UserContext);
    const [userEmail, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    /**
     * It takes the email and password from the form, sends it to the server, and if the server returns
     * the user information and it saves it in the browser's local storage
     * @param e - the event object
     */
    async function autenticate(e) {
        e.preventDefault();
        if (!(userEmail == '' || password == '')) {
            let data = {'email': userEmail, 'password': password};
            axios.post("http://localhost:8080/user/login", 
                JSON.stringify(data), {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            ).then( res => {
                signIn(res.data);
            }).catch(error => {
                if (error.response) {
                    setMessage(error.response.data)
                } else {
                    setMessage(error.message)
                }
            });
        } else {
            setMessage('Please enter email and password')
        }
    }

    /* This is the HTML code that is rendered when the user visits the login page (login form). */
    return (
        <Container className='w-75'>
            <Card className='p-3 shadow-lg bg-white' style={{borderRadius: "50px"}}>
                <Card.Header className='p-2 mb-2 bg-body'>
                    <ModalTitle className='text-dark fs-1 fw-bold p-2'>Login</ModalTitle>
                </Card.Header>
                <Card.Body className='m-3'>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control className='p-2' type="email" placeholder="Enter email" onChange={e => setEmail(e.target.value)} />
                            <Form.Text className="text-muted">
                            We'll never share your email with anyone else.
                            </Form.Text>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control className='p-2' type="password" placeholder="Password" onChange={e => setPassword(e.target.value)}/>
                        </Form.Group>
                            <Row className='w-100 align-items-center justify-content-center'>
                                <Form.Label className="w-100 text-center text-danger" style={{height: '24px'}}>{message || ''}</Form.Label>
                                <NavLink href='/register' className='p-3 text-center text-decoration-underline'>Don't have an account? Register Here</NavLink>
                                <Button className='fs-5' variant="primary" type="submit" style={{borderRadius: "30px", width: "120px"}} onClick={e => autenticate(e)}>
                                    Submit
                                </Button>
                            </Row>
                    </Form>
                </Card.Body>
            </Card>
            <Container className='p-5'>
            </Container>
        </Container>
    );
}