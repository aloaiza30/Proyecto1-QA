/* This is importing the components from the other files. */
import PieChartReports from "../components/ReportPage/PieChartReports";
import ReportSummary from "../components/ReportPage/ReportSummary";
import AppNavBar from "../components/Navbar/NavBar";


/**
 * The function returns the AppNavBar component, the PieChartReports component, and the ReportSummary
 * component
 * @returns The AppNavBar, PieChartReports, and ReportSummary components are being returned.
 */
export default function Report() {
    return (
        <><AppNavBar/>
        <PieChartReports/>
        <ReportSummary/>
        </>
    );
}