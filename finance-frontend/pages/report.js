import { Container } from "react-bootstrap";
import PieChartReports from "../components/MainPage/PieChartReports";
import ReportSummary from "../components/MainPage/ReportSummary";
import AppNavBar from "../components/Navbar/NavBar";
//import UserContext from '../UserContext';
import { useContext, useState, useEffect } from 'react';

import axios from 'axios';

function Report() {
    const [userCategories, setUserCategories] = useState([]);
    const [userSavings, setUserSavings] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
        axios.get(`http://localhost:8080/user/getCategories?id=${localStorage.getItem("id")}`, {
            headers: {
                'Content-Type': 'application/json'
            }
        }
        ).then( res => {
            setUserCategories(res.data);
        }).catch(error => {
            if (error.response) {
                setMessage(error.response.data)
            } else {
                setMessage(error.message)
            }
        });
        axios.get(`http://localhost:8080/user/getSavings?id=${localStorage.getItem("id")}`, {
            headers: {
                'Content-Type': 'application/json'
            }
        }
        ).then( res => {
            setUserSavings(res.data);
        }).catch(error => {
            if (error.response) {
                setMessage(error.response.data)
            } else {
                setMessage(error.message)
            }
        });
    }, []);

    return (
        <><AppNavBar />
        <PieChartReports categories={userCategories} savings={userSavings}/>
        <ReportSummary categories={userCategories}/>
        </>
        

    );
}
export default Report;