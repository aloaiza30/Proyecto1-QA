import { Card, ModalBody, ModalTitle, Row } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend,
  } from 'chart.js';
import { useContext, useEffect } from 'react';
import UserContext from '../UserContext';

ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend
  );

function SavingsSummary() {
    const { savings } = useContext(UserContext);
    let id = 0;
    
    return (
        <Container>
            <Card className='p-3 shadow-lg bg-white' style={{borderRadius: "50px"}}>
                <Card.Header className='p-2 mb-2 bg-body'>
                    <ModalTitle className='text-dark'>Monthly Savings Report</ModalTitle>
                </Card.Header>
                <Card.Body className='m-3'>
                        <Row className='flex-row p-3'>
                            <Card style={{border: 'none'}}>
                                <Container style={{padding: "0px 50px 0px 50px"}}>
                                    <Row style={{height: "30px"}}>
                                        <ModalBody className='d-flex w-25 justify-content-center'>
                                            ID
                                        </ModalBody>
                                        <ModalBody className='d-flex w-25 justify-content-center'>
                                            Month
                                        </ModalBody>
                                        <ModalBody className='d-flex w-25 justify-content-center'>
                                            Total
                                        </ModalBody>
                                    </Row>
                                </Container>
                            </Card>
                        </Row>
                        {
                            savings.monthlySavingsList?.map(monthlySaving => {
                                id = id + 1
                                return (
                                    <Row className='flex-row p-3'>
                                        <Card className='p-3 shadow-lg bg-white' style={{borderRadius: "50px"}}>
                                            <Container style={{padding: "0px 50px 0px 50px"}}>
                                                <Row className='fs-5' style={{height: "30px"}}>
                                                    <ModalBody className='d-flex w-25 justify-content-center align-items-center'>
                                                    {id}
                                                    </ModalBody>
                                                    <ModalBody className='d-flex w-25 justify-content-center align-items-center'>
                                                    {monthlySaving.month[0].toUpperCase() + monthlySaving.month.slice(1).toLowerCase()}
                                                    </ModalBody>
                                                    <ModalBody className='d-flex w-25'>
                                                        <Container className='d-flex w-25 justify-content-center align-items-center h-100' style={{borderRadius: "50px", backgroundColor: "#85cf75", color: "white"}}>
                                                            ${monthlySaving.monthlySavings}
                                                        </Container>
                                                    </ModalBody>
                                                </Row>
                                            </Container>
                                        </Card>
                                    </Row>
                                );
                            })
                        }
                </Card.Body>
            </Card>
            <Container className='p-5'>
            </Container>
        </Container>
    );
}
export default SavingsSummary;