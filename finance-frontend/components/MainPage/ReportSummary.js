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

function ReportSummary({categories}) {
    
    return (
        <Container>
            <Card className='p-3 shadow-lg bg-white' style={{borderRadius: "50px"}}>
                <Card.Header className='p-2 mb-2 bg-body'>
                    <ModalTitle className='text-dark'>Summary</ModalTitle>
                </Card.Header>
                <Card.Body className='m-3'>
                    <Row className='flex-row'>
                        {
                            categories.map(category => {
                                return <Container className='w-50 p-2'>
                                    <Card.Title>{category.name}</Card.Title>
                                    <Row className='justify-content' style={{height: "30px"}}>
                                        <Bar className='h-100 w-75' data={{
                                            labels:[""],
                                            datasets:[{
                                                data: [category.totalSpent],
                                                backgroundColor: "rgba(54, 162, 235, 0.8)",
                                            }, {
                                                data: [category.monthlyBudget -  category.totalSpent],
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

                                        <ExclamationCircleFill visibility={category.totalSpent >= category.monthlyBudget ? 'visible' : 'hidden'}
                                         className='w-auto h-75 my-auto' color='red' />
                                    </Row>
                                </Container>
                            })
                        }
                    </Row>
                </Card.Body>
            </Card>
            <Container className='p-5'>
            </Container>
        </Container>
    );
}
export default ReportSummary;