/* Importing the necessary components for the page. */
import { Container, ModalTitle, Row } from "react-bootstrap";
import {
    Chart as ChartJS,
    ArcElement,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend,
  } from 'chart.js';
import { Doughnut, Line } from 'react-chartjs-2';
import { useContext } from "react";
import UserContext from "../UserContext";

/* Registering the components that are being used in the chart. */
ChartJS.register(
    ArcElement, 
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
);

/**
 * This function is a React functional component that returns a doughnut chart, and a line chart
 * @returns A container with a doughnut chart, and a line chart.
 */
export default function SavingsChartReports() {
    /* This is destructuring the savings object from the UserContext. */
    const { savings } = useContext(UserContext);
    let months = savings.monthlySavingsList ? savings.monthlySavingsList : [];
    
    /** This is returning a container with a doughnut chart, and a line chart displaying
     * the savings summary.
     */
    return (
        <Container className="w-75">
            <Row>
                <ModalTitle className="p-3 fw-bold">Monthly Expenses</ModalTitle>
                <Container className="w-25" style={{padding: "0px 0px 50px 50px"}}>
                    <Doughnut className="ml-auto" data={{
                        labels: ["Savings", "Remaining"],
                        datasets: [{
                            label: "Total $ Saved",
                            data: [savings.totalSavings, savings.goal - savings.totalSavings],
                            backgroundColor: [
                                'rgba(54, 162, 235, 0.5)',
                                'rgba(255, 99, 132, 0.5)',
                            ],
                            borderColor: [
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 99, 132, 1)',
                            ],
                            borderWidth: 1
                        }],
                    }}
                    options={{
                        plugins: {
                            title: {
                                display: true,
                                align: 'center',
                                text: 'Total Savings',
                                font: {size: "15px"}
                            }
                        }
                    }}/>
                </Container>
                <Container className="w-50" style={{padding: "0px 0px 50px 50px"}}>
                    <Line options={
                        {
                            responsive: true,
                            interaction: {
                              mode: 'index',
                              intersect: false,
                            },
                            stacked: false,
                            plugins: {
                                title: {
                                    display: true,
                                    align: 'center',
                                    text: 'Linear Chart of Monthly Savings',
                                    font: {size: "15px"}
                                }
                            },
                            scales: {
                              y: {
                                type: 'linear',
                                display: true,
                                position: 'left',
                              }, 
                            }
                    }
                } 
                data={
                    {
                        labels: months.map(month => month.month),
                        datasets: [
                          {
                            label: 'Monthly Savings',
                            data: months.map(month => month.monthlySavings),
                            borderColor: 'rgb(255, 99, 132)',
                            backgroundColor: 'rgba(255, 99, 132, 0.5)',
                            yAxisID: 'y',
                          },
                        ],
                    }
                } />
                </Container>
            </Row>
        </Container>
    );
}