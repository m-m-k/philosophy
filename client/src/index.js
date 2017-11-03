import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import './mycss.css';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
