import { useForm } from '../../hooks/useForm.jsx';
import { validationsForm, initialForm, styles } from './loginUtils'
import { useNavigate } from 'react-router-dom';
import { loginUser } from "../../services/userService"
import './login.css'


const Register = () => {
  const { form, errors, handleChange, handleBlur, handleSubmit } = useForm(
    initialForm,
    validationsForm
  );

  let navigate = useNavigate();

  const handlePost = () => {
    if (noErrors(errors)) {
      loginUser(form).then((res) => {
        if (res.status == 200) {
          console.log(res)
          sessionStorage.setItem("jwtToken", JSON.stringify(res.data.token))
          sessionStorage.setItem("userRol", JSON.stringify(res.data.rol.rolName))
          sessionStorage.setItem("userId", JSON.stringify(res.data.id))

          navigate('/cities')
        } else {
          console.log("error en la peticion")
        }

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

      <div className="loginForm-container">
        <form className='loginForm' action="Submit" onSubmit={handleSubmit}>
          <h1>Login</h1>
          <label htmlFor="email">Email</label>
          <input
            className="info-login"
            type="email"
            name="email"
            id="loginEmail"
            placeholder=" Email"
            value={form.email}
            onBlur={handleBlur}
            onChange={handleChange} />

          <label htmlFor="password">Password</label>
          <input
            className="info-login"
            type="password"
            name="password"
            id="loginPassword"
            placeholder="Password"
            value={form.password}
            onBlur={handleBlur}
            onChange={handleChange} />
          <div className="buttonsLogin">
            <input type="submit" value="Sign In" onClick={handlePost} />
            <a href="/create-account" >Sign Up</a>
          </div>
        </form>
      </div>

    </>
  )
}

export default Register