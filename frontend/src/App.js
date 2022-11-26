import './index.css';
import { BrowserRouter as Router ,Routes, Route, Link } from 'react-router-dom'
import CitiesListPage from "../src/pages/CitiesListPage"
import UpdateInfoPage from "./pages/UpdateInfoPage"
import CreateAccountPage from "../src/pages/CreateAccountPage"
import HomePage from "../src/pages/HomePage"

function App() {
  return (
    <Router>
      <div className='appContainer'>        
        <Routes>
          <Route path="/" element={<HomePage/>}/>
          <Route path="/update-user" element={<UpdateInfoPage/>}/>
          <Route path="/create-account" element={<CreateAccountPage/>}/>
          <Route path="/cities" element={<CitiesListPage/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
