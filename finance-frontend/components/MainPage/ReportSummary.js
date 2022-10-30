import { Card, ModalTitle, Row } from 'react-bootstrap';
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
import { Bar } from 'react-chartjs-2';
import { ExclamationCircleFill } from 'react-bootstrap-icons';

ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend
  );

function ReportSummary({report}) {
    return (
        <Container>
            <Card className='p-3 shadow-lg bg-white' style={{borderRadius: "50px"}}>
                <Card.Header className='p-2 mb-2 bg-body'>
                    <ModalTitle className='text-dark'>Summary</ModalTitle>
                </Card.Header>
                <Card.Body className='m-3'>
                    <Row>
                        <Container className='col-sm w-50 p-1'>
                            <Card.Title>House</Card.Title>
                            <Row className='justify-content' style={{height: "30px"}}>
                                <Bar className='h-100 w-75' data={{
                                    labels:[""],
                                    datasets:[{
                                        data: [450],
                                        backgroundColor: "rgba(54, 162, 235, 0.8)",
                                    }, {
                                        data: [250],
                                        backgroundColor: "lightgrey"
                                    }]
                                }}
                                options={{
                                    responsive: true,
                                    indexAxis: 'y',
                                    scales: {
                                    x: {
                                        stacked: true,
                                        display: false,
                                        grid: {
                                            display:false
                                        }
                                    },
                                    y: {
                                        stacked: true,
                                        display: false,
                                        grid: {
                                            display:false
                                        }
                                    }
                                    },
                                    tooltips: {
                                    enabled: false
                                    },
                                    plugins: {
                                        legend:{
                                            display:false
                                        }
                                    },
                                }}/>
                                <ExclamationCircleFill className='w-auto h-75 my-auto' color='red'/>
                            </Row>
                        </Container>
                        <Container className='col-sm w-50 p-1' style={{height: "30px"}}>
                            <Card.Title>House</Card.Title>
                            <Row className='justify-content' style={{height: "30px"}}>
                                <Bar className='h-100 w-75' data={{
                                    labels:[""],
                                    datasets:[{
                                        data: [450],
                                        backgroundColor: "rgba(54, 162, 235, 0.8)",
                                    }, {
                                        data: [250],
                                        backgroundColor: "lightgrey"
                                    }]
                                }}
                                options={{
                                    responsive: true,
                                    indexAxis: 'y',
                                    scales: {
                                    x: {
                                        stacked: true,
                                        display: false,
                                        grid: {
                                            display:false
                                        }
                                    },
                                    y: {
                                        stacked: true,
                                        display: false,
                                        grid: {
                                            display:false
                                        }
                                    }
                                    },
                                    tooltips: {
                                    enabled: false
                                    },
                                    plugins: {
                                        legend:{
                                            display:false
                                        }
                                    },
                                }}/>
                                <ExclamationCircleFill className='w-auto h-75 my-auto' color='red'/>
                            </Row>
                        </Container>
                    </Row>
                </Card.Body>
            </Card>
            <Container className='p-5'>
            </Container>
        </Container>
    );
}
export default ReportSummary;