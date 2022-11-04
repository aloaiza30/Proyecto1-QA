/* Importing the Container component from the react-bootstrap library and the RegisterForm component
from the RegisterPage folder. */
import { Container } from "react-bootstrap";
import RegisterForm from "../components/RegisterPage/RegisterForm";

/**
 * It returns a Container component that contains a RegisterForm component
 * @returns A Container component with a RegisterForm component inside of it.
 */
export default function Register() {
    return (
        <Container className="w-100 d-flex align-items-center justify-content-center" style={{height: "100vh"}}>
            <RegisterForm/>
        </Container>
    );
}