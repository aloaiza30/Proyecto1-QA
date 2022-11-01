import { Card, Form, Modal, ModalBody, ModalDialog, ModalFooter, ModalHeader, ModalTitle, NavLink, Row } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import { useContext, useState } from 'react';
import UserContext from '../UserContext';

import axios from 'axios';


function LoginForm() {
    const { signIn } = useContext(UserContext);
    const [userEmail, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    async function autenticate(e) {
        e.preventDefault();
        if (userEmail != '' || password != '') {
            let data = {'email': userEmail, 'password': password};
            console.log(JSON.stringify(data));

            axios.post("http://localhost:8080/user/login", 
                JSON.stringify(data), {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            ).then(() => {
                signIn(userEmail);
            }).catch(error => {
                if (error.response) {
                    setMessage(error.response.data?.message)
                } else {
                    setMessage(error.message)
                }
            });
        } else {
            setMessage('Please enter email and password')
        }
    }

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
export default LoginForm;