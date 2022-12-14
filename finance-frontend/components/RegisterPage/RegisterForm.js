/* Importing the necessary components to make the form work. */
import { Card, Form, ModalTitle, Row } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import { useContext, useState } from 'react';
import UserContext from '../UserContext';

import axios from 'axios';


/**
 * It's a function that renders a form to register a new user
 * @returns A form to register a new user
 */
 export default function RegisterForm() {
    /* It's declaring the variables that will be used in the form. */
    const { signIn } = useContext(UserContext);
    const [userName, setUserName] = useState('');
    const [lastName, setLastName] = useState('');
    const [userEmail, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [monthlyEarnings, setMonthlyEarnings] = useState(0);
    const [message, setMessage] = useState('');

    /**
     * It takes the user data from the form and sends it to the backend API
     * @param e - the event that is triggered when the user clicks the submit button
     */
    async function autenticate(e) {
        e.preventDefault();
        if (!(userName == '' || lastName == '' || userEmail == '' || password == '' || monthlyEarnings == 0)) {
            let data = {'userName': userName, 'lastName': lastName, 'email': userEmail, 'password': password, 'monthlyEarnings': monthlyEarnings, categories: [], payments: [], savings: {}, wishlist: []};

            console.log("🚀 ~ file: RegisterForm.js ~ line 24 ~ autenticate ~ data", data)
            axios.post("http://localhost:8080/user/register", JSON.stringify(data),
                {
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
            setMessage('Please fill all the information')
        }
    }

    /* This is the HTML code that is rendered that contains a form to register a new user. */
    return (
        <Container className='w-75'>
            <Card className='p-3 shadow-lg bg-white' style={{borderRadius: "50px"}}>
                <Card.Header className='p-2 mb-2 bg-body'>
                    <ModalTitle className='text-dark fs-1 fw-bold p-2'>Register</ModalTitle>
                </Card.Header>
                <Card.Body className='m-3'>
                    <Form>
                        <Row>
                            <Form.Group className="mb-3 w-50">
                                <Form.Label>Name</Form.Label>
                                <Form.Control className='p-2' type="text" placeholder="Enter your name" onChange={e => setUserName(e.target.value)} />
                            </Form.Group>
                            <Form.Group className="mb-3 w-50">
                                <Form.Label>Lastname</Form.Label>
                                <Form.Control className='p-2' type="text" placeholder="Enter your lastname" onChange={e => setLastName(e.target.value)}/>
                            </Form.Group>
                        </Row>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control className='p-2' type="email" placeholder="Enter email" onChange={e => setEmail(e.target.value)}/>
                            <Form.Text className="text-muted">
                            We'll never share your email with anyone else.
                            </Form.Text>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control className='p-2' type="password" placeholder="Password" onChange={e => setPassword(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3">
                            <Form.Label>Monthly Earnings</Form.Label>
                            <Form.Control className='p-2' type="number" min="0" placeholder='$$$' onChange={e => setMonthlyEarnings(e.target.value)}/>
                        </Form.Group>
                        <Row className='w-100 align-items-center justify-content-center'>
                            <Form.Label className="w-100 text-center text-danger" style={{height: '24px'}}>{message || ''}</Form.Label>
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