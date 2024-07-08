import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { login } from '../api/login';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const AuthPage = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await login(email, password);
            if (response.message === "Login successful") {
                navigate('/dashboard');
            }

        } catch (error) {
            console.error('Login error:', error.message);
        }
    }
    return (
        <div className="card flex justify-content-center" style={{ marginTop: '5vh', marginBottom: '5vh'}}>
            <form onSubmit={handleLogin} className="flex flex-column gap-2">
                <InputText id="email" placeholder="Email" onChange={(e) => setEmail(e.target.value)}/>
                <InputText id="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)}/>
                <Button type="submit" label="Login" />
            </form>
        </div>
    );
} 
export default AuthPage;