/* Importing the Container component from react-bootstrap and the LoginForm component from the
LoginPage folder. */
import { Container } from "react-bootstrap";
import LoginForm from "../components/LoginPage/LoginForm";

/**
 * It returns a Container component that contains a LoginForm component
 * @returns A Container component with a LoginForm component inside of it.
 */
export default function Login() {
    return (
        <Container className="w-100 d-flex align-items-center justify-content-center" style={{height: "100vh"}}>
            <LoginForm/>
        </Container>
    );
}