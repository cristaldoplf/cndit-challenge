import React, { useState, useEffect } from 'react';
import { getUser,putUser } from '../../services/userService';
import "./updateInfo.css"

const UpdateInfo = () => {
  const [user, setUser] = useState({});

  useEffect(() => {
    getUser().then((res) => {
      console.log(res)
      setUser({
        name: res.data.name,
        email: res.data.email,
        adress: res.data.adress
      })
    }
    )
  }, []);

  const handelSubmit = (e) => {
    const adressValue = document.querySelector("#adress-input").value
    console.log(adressValue)
    e.preventDefault()
    putUser(adressValue).then((res)=>{
      console.log(res)
    })
  }





  return (

    <>
      <div className="registerForm-container">
        <form className='registerForm' action="Submit" onClick={handelSubmit}>
          <h1>Update Adress</h1>
          <input
            className="info-register"
            type="text"
            name="name"
            id="name"
            value={user.name}
            readOnly
          />

          <input
            className="info-register"
            type="email"
            name="email"
            id="email"
            value={user.email}
            readOnly
          />

          <input
            className="info-register"
            type="text"
            name="adress"
            id="adress-input"
            placeholder={user.adress}
            
          />
          <div className="buttonsRegister">
            <input type="submit" value="Update" />
            <a href="index.html">Cancel</a>
          </div>
        </form>
      </div>
    </>

  )
}

export default UpdateInfo;