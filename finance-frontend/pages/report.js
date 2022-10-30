import { Container } from "react-bootstrap";
import PieChartReports from "../components/MainPage/PieChartReports";
import ReportSummary from "../components/MainPage/ReportSummary";
import AppNavBar from "../components/Navbar/NavBar";

function Report( {reports} ) {
    return (
        <><AppNavBar />
        <PieChartReports />
        <ReportSummary />
        </>
        

    );
}
export default Report;

// export async function getServerSideProps() {
//     // Call an external API endpoint to get posts
//     const res = await fetch('https://.../posts')
//     const reports = await res.json()
  
//     // By returning { props: { posts } }, the Blog component
//     // will receive `posts` as a prop at build time
//     return {
//       props: {
//         reports,
//       },
//     }
//   }