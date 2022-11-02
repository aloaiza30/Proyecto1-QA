import { Container } from "react-bootstrap";
import PieChartReports from "../components/ReportPage/PieChartReports";
import ReportSummary from "../components/ReportPage/ReportSummary";
import AppNavBar from "../components/Navbar/NavBar";
//import UserContext from '../UserContext';
import { useContext, useState, useEffect } from 'react';

import axios from 'axios';
import UserContext from "../components/UserContext";

function Report() {
    // const [userCategories, setUserCategories] = useState([]);
    // const [userSavings, setUserSavings] = useState([]);
    // const [message, setMessage] = useState('');
    // const { id, userName, lastName } = useContext(UserContext);

    // useEffect(() => {
    //     axios.get(`http://localhost:8080/user/getCategories?id=${id}`, {
    //         headers: {
    //             'Content-Type': 'application/json'
    //         }
    //     }
    //     ).then( res => {
    //         setUserCategories(res.data);
    //     }).catch(error => {
    //         if (error.response) {
    //             setMessage(error.response.data)
    //         } else {
    //             setMessage(error.message)
    //         }
    //     });
    //     axios.get(`http://localhost:8080/user/getSavings?id=${id}`, {
    //         headers: {
    //             'Content-Type': 'application/json'
    //         }
    //     }
    //     ).then( res => {
    //         setUserSavings(res.data);
    //     }).catch(error => {
    //         if (error.response) {
    //             setMessage(error.response.data)
    //         } else {
    //             setMessage(error.message)
    //         }
    //     });
        
    // }, []);

    return (
        <><AppNavBar/>
        <PieChartReports/>
        <ReportSummary/>
        </>
        

    );
}
export default Report;