import React, { useState, useEffect } from 'react';
import './citiesList.css'
import { getCities } from "../../services/citiesService.js"


const CitiesList = () => {
  const [cities, setCities] = useState([]);
  const [userRole, setUserRole] = useState();

  useEffect(() => {
    let token = JSON.parse(sessionStorage.getItem("jwtToken"));
    setUserRole(JSON.parse(sessionStorage.getItem("userRol")))
    console.log(token);
    
    getCities(token)
      .then((res) => {
        setCities(res.data);
      })
      .catch((e) => {
        console.log(e.response);
      })
      .finally(() => {
      });


      
  }, []);

  

  return (
    <>
      <div className='citiesListContainer'>
        <h1>Cities</h1>
        {cities.length > 0 && (
          <table>
            <thead>
              <tr>
                <th>
                  City
                </th>
                {userRole == "ROLE_ADMIN" &&
                  <th>
                  Temp
                </th>}
              </tr>
            </thead>
            <tbody>
              {
                cities && cities.map((value, index) => {
                  return (
                    <tr key={index}>
                      <td > {value.name}</td>
                      {userRole == "ROLE_ADMIN" && <td >{value.weather.temp}</td>}
                    </tr>)
                })
              }
            </tbody>
          </table>
        )


        }
      </div>
    </>
  )
}

{/* <tr>
<th>Ciudad</th>
<th>Temperatura</th>
</tr>
<tr>
<td>Buenos Aires</td>
<td>20°</td>
</tr> */}

export default CitiesList