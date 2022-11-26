import React from 'react';
import { postUser } from "../../services/userService.js"
import { useForm } from '../../hooks/useForm.jsx';
import { validationsForm, initialForm, styles } from './registerUtils'
import { useNavigate } from 'react-router-dom';
import './register.css'


const Register = () => {
  const { form, errors, handleChange, handleBlur, handleSubmit } = useForm(
    initialForm,
    validationsForm
  );

  let navigate = useNavigate();

  const handlePost = () => {
    if (noErrors(errors)) {
      postUser(form).then((res) => {
        console.log(res)
        navigate('/')
      })
    }
  }

  const noErrors = (errors) => {
    let resp = false;
    if (Object.keys(errors).length === 0) {
      resp = true;
    }
    return resp
  }

  return (
    <>
      <div className="registerForm-container">
        <form className='registerForm' action="Submit" onSubmit={handleSubmit}>
          <h1>Create Account</h1>
          <label htmlFor="name">Name</label>
          <input
            className="info-register"
            type="text"
            name="name"
            id="name"
            placeholder=" Name"
            value={form.name}
            onBlur={handleBlur}
            onChange={handleChange}
          />


          <label htmlFor="email">Email</label>
          <input
            className="info-register"
            type="email"
            name="email"
            id="email"
            placeholder=" Email"
            value={form.email}
            onBlur={handleBlur}
            onChange={handleChange}
          />



          <label htmlFor="confirmEmail">Confirm Email</label>
          <input
            className="info-register"
            type="email"
            name="confirmEmail"
            id="confirmEmail"
            placeholder=" Confirm Email"
            value={form.confirmEmail}
            onBlur={handleBlur}
            onChange={handleChange}
          />

          <label htmlFor="adress">Adress</label>
          <input
            className="info-register"
            type="text"
            name="adress"
            id="adress"
            placeholder=" Adress"
            value={form.adress}
            onBlur={handleBlur}
            onChange={handleChange} />

          <label htmlFor="password">Password</label>
          <input
            className="info-register"
            type="password"
            name="password"
            id="password"
            placeholder=" Password"
            value={form.password}
            onBlur={handleBlur}
            onChange={handleChange} />

          <label htmlFor="confirmPassword">Confirm Password</label>
          <input
            className="info-register"
            type="password"
            name="confirmPassword"
            id="confirmPassword"
            placeholder=" Confirm Password"
            value={form.confirmPassword}
            onBlur={handleBlur}
            onChange={handleChange} />
          <div className="buttonsRegister">
            <input type="submit" value="Confirm" onClick={handlePost} />
            <a href="/">Sign In</a>
          </div>
        </form>
      </div>

    </>
  )
}

export default Register