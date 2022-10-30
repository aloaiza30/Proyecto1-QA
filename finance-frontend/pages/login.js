import { Container } from "react-bootstrap";
import LoginForm from "../components/LoginPage/LoginForm";

function Login() {
    return (
        <Container className="w-100 d-flex align-items-center justify-content-center" style={{height: "100vh"}}>
            <LoginForm/>
        </Container>
    );
}
export default Login;