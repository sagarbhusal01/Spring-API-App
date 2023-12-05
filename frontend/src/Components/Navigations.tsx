import React from "react";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import Login from "../Pages/Login/Login.main";
import Home from "../Pages/Home/Home.Main";

export default function Navigations() {
  return (
    <Router>
      <Routes>
        <Route path="/Login" element={<Login/>}/>
        <Route path="/Home" element={<Home/>}/>
        {/* fallback route */}
        <Route path="*" element={<Login/>} />
      </Routes>
    </Router>
  );
}
