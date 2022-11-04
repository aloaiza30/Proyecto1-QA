/* Importing the Container component from react-bootstrap and the TitleContainer component from the
Index folder. */
import { Container } from 'react-bootstrap'
import TitleContainer from '../components/Index/TitleContainer'

/**
 * It returns a Container component that contains a TitleContainer component
 * @returns A container with a title container inside of it.
 */
export default function Home() {
  return (
    <Container className="w-100 d-flex align-items-center justify-content-center" style={{height: "100vh"}}>
            <TitleContainer/>
    </Container>
  )
}
