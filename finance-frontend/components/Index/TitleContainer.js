import { Card, Form, ModalBody, ModalTitle, NavLink, Row } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';


function TitleContainer() {
    return (
        <Container className='w-75'>
            <Card className='p-3 shadow-lg bg-white' style={{borderRadius: "50px"}}>
                <Row className='m-3'>
                    <Container className='d-flex w-100 justify-content-center'>
                        <ModalTitle className='display-1' style={{fontWeight: 'bolder', fontFamily: 'Arial'}}>Finance</ModalTitle>
                    </Container>
                    <Container className='d-flex w-100 p-3 justify-content-center'>
                        <ModalBody className='h4 text-center'>Personal Financial Administrator</ModalBody>
                    </Container>
                    <Container className='d-flex w-100 p-3 justify-content-center'>
                        <Row className='w-50 justify-content-between'>
                            <Button className='fs-5' variant="primary" type="submit" style={{borderRadius: "30px", width: "120px"}} href="/login">
                                Login
                            </Button>
                            <Button className='fs-5' variant="primary" type="submit" style={{borderRadius: "30px", width: "120px"}} href="/register">
                                Register
                            </Button>
                        </Row>
                    </Container>
                </Row>
            </Card>
            <Container className='p-5'>
            </Container>
        </Container>
    );
}
export default TitleContainer;