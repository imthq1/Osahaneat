import axios from 'axios';
function login(email, password) {
    return axios.post('api/login', {
        email,
        password
    });
}
export {login}