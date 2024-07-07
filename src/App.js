import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AuthPage from './login/loginPage';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import 'primeflex/primeflex.css';
// import './config/Dashboard.css';

import './pages/Dashboard';
import Dashboard from './pages/Dashboard';

function App() {
  return (
    <Router >
      <Routes>
        <Route path='/' element={<AuthPage />} />
        <Route path='/dashboard' element={<Dashboard />} />
      </Routes>
    </Router>
  );
}

export default App;
