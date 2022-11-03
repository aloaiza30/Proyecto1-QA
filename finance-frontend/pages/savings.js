import { Container } from "react-bootstrap";
import AppNavBar from "../components/Navbar/NavBar";
import RegisterForm from "../components/RegisterPage/RegisterForm";
import SavingsChartReports from "../components/SavingsPage/SavingsChartReport";
import SavingsSummary from "../components/SavingsPage/SavingsSummary";
//import LoginForm from "../components/LoginPage/LoginForm";

function Savings() {
    return (
        <><AppNavBar />
        <SavingsChartReports/>
        <SavingsSummary/>
        </>
    );
}
export default Savings;