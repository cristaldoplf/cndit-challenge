import axios from "axios"

//TODO armar api para esto
const baseUrl = "http://localhost:8080/city/viewAll"

export const getCities = async (data) => {
  let config = {
    method: 'get',
    url: `${baseUrl}`,
    headers: {
      'Authorization': `Bearer ${data}`,
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