import { Container } from 'react-bootstrap'
import TitleContainer from '../components/Index/TitleContainer'

export default function Home() {
  return (
    <Container className="w-100 d-flex align-items-center justify-content-center" style={{height: "100vh"}}>
            <TitleContainer/>
    </Container>
  )
}
