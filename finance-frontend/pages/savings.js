/* Importing the components from the components folder. */
import AppNavBar from "../components/Navbar/NavBar";
import SavingsChartReports from "../components/SavingsPage/SavingsChartReport";
import SavingsSummary from "../components/SavingsPage/SavingsSummary";

/**
 * The Savings function returns the AppNavBar, SavingsChartReports, and SavingsSummary components
 * @returns The AppNavBar, SavingsChartReports, and SavingsSummary components are being returned.
 */
export default function Savings() {
    return (
        <><AppNavBar />
        <SavingsChartReports/>
        <SavingsSummary/>
        </>
    );
}