import CitiesList from "../components/cities-list/CitiesList.jsx"
import Header from "../components/header/header.jsx";


function CitiesListPage() {
  return (
    <div className='appContainer'>
      <Header/>
      <CitiesList/>
    </div>
  );
}

export default CitiesListPage;