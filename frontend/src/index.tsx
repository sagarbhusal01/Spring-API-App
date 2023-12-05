import React from 'react';
import ReactDOM from 'react-dom/client';
import Navigations from './Components/Navigations';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <Navigations/>
  </React.StrictMode>
);
