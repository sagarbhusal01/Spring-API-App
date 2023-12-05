import React from "react";
import "./Login.Style.css"
import LoginSide from "./parts/LoginSide/LoginSide";
import RegisterSide from "./parts/RegisterSide/RegisterSide";
export default function Login() {
  return (
    <>
      <div id="loginWrapper">
        <div id="LoginSideContainer">
            <LoginSide/>
        </div>
        <div id="RegisterSideContainer">
            <RegisterSide/>
        </div>
      </div>
    </>
  );
}
