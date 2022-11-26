import Login from "../components/login/Login"
import Header from "../components/header/header"


function HomePage() {
  return (
    <div className='appContainer'>
      <Header/>
      <Login/>
    </div>
  );
}

export default HomePage;