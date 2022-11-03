import { Container, ModalTitle, Row } from "react-bootstrap";
import { Chart as ChartJS, ArcElement, Tooltip, Legend, Title } from 'chart.js';
import { Pie, Doughnut } from 'react-chartjs-2';
import { useContext } from "react";
import UserContext from "../UserContext";

ChartJS.register(ArcElement, Tooltip, Legend, Title);

function PieChartReports() {
    const {categories, savings} = useContext(UserContext);
    console.log("🚀 ~ file: PieChartReports.js ~ line 11 ~ PieChartReports ~ savings", savings)

    return (
        <Container className="w-75">
            <Row>
                <ModalTitle className="p-3 fw-bold">Monthly Expenses</ModalTitle>
                <Container className="w-50" style={{padding: "0px 50px 50px 0px"}}>
                    <Pie className="ml-auto" data={{
                        labels: categories.map(category => category.name), //["Car", "House", "Food", "Entertainment"],
                        datasets: [{
                            label: "Total $ Spent",
                            data: categories.map(category => category.totalSpent),
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.5)',
                                'rgba(54, 162, 235, 0.5)',
                                'rgba(255, 206, 86, 0.5)',
                                'rgba(75, 192, 192, 0.5)',
                                'rgba(153, 102, 255, 0.5)',
                                'rgba(255, 159, 64, 0.5)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }],
                    }} 
                    options={{
                        plugins: {
                            title: {
                                display: true,
                                align: 'center',
                                text: 'Total $ Spent',
                                font: {size: "15px"}
                            }, 
                        }
                    }}/>
                </Container>
                <Container className="w-50" style={{padding: "0px 0px 50px 50px"}}>
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
            </Row>
        </Container>
    );
}
export default PieChartReports;