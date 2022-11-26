import axios from "axios"

//TODO armar api para esto
const baseUrl = "http://localhost:8080"

export const postUser = async (data) => {
  const endpoint = `${baseUrl}/auth/register`;
  const post = {
    name: data.name,
    adress: data.adress,
    email: data.email,
    password: data.password,
    
  };
  return await axios
    .post(endpoint, post)
    .then((res) => {
      return res;
    })
    .catch((err) => {
      return err;
    });
};

export const loginUser = async (data) => {
  const endpoint = `${baseUrl}/auth/login`;
  const post = {
    email: data.email,
    password: data.password
  };
  return await axios
    .post(endpoint, post)
    .then((res) => {
      return res;
    })
    .catch((err) => {
      return err;
    });
};

export const getUser = async () => {
  let userId = JSON.parse(sessionStorage.getItem("userId"))
  let config = {
    method: 'get',
    url: `${baseUrl}/user/${userId}`,
    headers: {
      'Authorization': `Bearer ${JSON.parse(sessionStorage.getItem("jwtToken"))}`,
      'Content-Type': 'application/json'
    },
  };
  return await axios(config)
    .then((res) => {
      return res;
    })
    .catch((err) => {
      return err;
    });
    
};

export const putUser = async (dataAdress) => {
  let userId = JSON.parse(sessionStorage.getItem("userId"))
  const dataToPut = {
    id: userId,
    adress: dataAdress
  };
  let config = {
    method: 'put',
    url: `${baseUrl}/user/update`,
    headers: {
      'Authorization': `Bearer ${JSON.parse(sessionStorage.getItem("jwtToken"))}`,
      'Content-Type': 'application/json'
    },
    data:(dataToPut),
  };
  return await axios(config)
    .then((res) => {
      return res;
    })
    .catch((err) => {
      return err;
    });
    
};