import axios from 'axios';
function login(email, password) {
    return axios.post('login/signin', {
        email,
        password
    });
}
export {login}