import { Container } from "react-bootstrap";
import RegisterForm from "../components/RegisterPage/RegisterForm";
//import LoginForm from "../components/LoginPage/LoginForm";

function Register() {
    return (
        <Container className="w-100 d-flex align-items-center justify-content-center" style={{height: "100vh"}}>
            <RegisterForm/>
        </Container>
    );
}
export default Register;