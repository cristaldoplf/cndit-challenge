import React, { useState, useEffect } from 'react';
import "./header.css"
const Header = () => {

  let handleClick = () => {
    sessionStorage.removeItem("jwtToken")
    sessionStorage.removeItem("userRol")
  }

  return (

    <header>
      <a href="/">Home</a>
      <a href="/update-user">Control Panel</a>
      {sessionStorage.getItem("jwtToken") && sessionStorage.getItem("userRol") && <a href="/cities">Cities List</a>}
      {sessionStorage.getItem("jwtToken") && sessionStorage.getItem("userRol") && <a href="/" onClick={handleClick}>Log Out</a>}
    </header>

  )
}

export default Header;