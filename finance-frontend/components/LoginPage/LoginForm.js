import { Card, Form, ModalTitle, NavLink, Row } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';


function LoginForm() {
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
                            <Form.Control className='p-2' type="email" placeholder="Enter email" />
                            <Form.Text className="text-muted">
                            We'll never share your email with anyone else.
                            </Form.Text>
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control className='p-2' type="password" placeholder="Password" />
                        </Form.Group>
                            <Row className='w-100 align-items-center justify-content-center'>
                                <NavLink href='/register' className='p-3 text-center text-decoration-underline'>Don't have an account? Register Here</NavLink>
                                <Button className='fs-5' variant="primary" type="submit" style={{borderRadius: "30px", width: "120px"}}>
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