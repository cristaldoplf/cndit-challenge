export const initialForm = {
  email: "",
  password: "",
};

export let styles = {
  fontWeight: "bold",
  color: "#FF0000",
  fontSize: "14px",
  textAlign: "end",
  position: "absolute",
  bottom: "-20px",
  right: "0px"
};

export const validationsForm = (form) => {
  let errors = {};
  let regexEmail = /^(\w+[/./-]?){1,}@[a-zA-Z]+[/.]\w{2,}$/;
  let regexPassword = /^.{6,}$/;

  if (!form.email.trim()) {
    errors.email = "Campo requerido";
  } else if (!regexEmail.test(form.email.trim())) {
    errors.email = "El formato es incorrecto";
  }

  if (!form.password.trim()) {
    errors.password = "Campo requerido";
  } else if (!regexPassword.test(form.password.trim())) {
    errors.password = "Se necesitan mínimo 6 caracteres";
  }


  return errors;
};