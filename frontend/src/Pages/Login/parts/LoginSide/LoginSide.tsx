import React, { useEffect, useLayoutEffect, useState } from "react";
import "./Loginside.css";
import { redirect, useNavigate } from "react-router-dom";
import { validateHeaderName } from "http";
export default function LoginSide() {
  // ===========================================
  const [Email, setEmail] = useState<string>("");
  const [Password, setPassword] = useState<string>("");
  // ===========================================
  // ===========================================

  const SignIn = () => {
    fetch("/authenticate", {
      method: "POST",
      body: JSON.stringify({
        email: Email,
        password: Password,
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        localStorage.setItem("$USER", JSON.stringify(data));
        navigate("/Home")
      })
      .catch((e) => {
        console.log("faled to fetch ", e);
      });
  };

  const navigate = useNavigate();
  useEffect(() => {
    const val = localStorage.getItem("$USER");
    if (val != null) {
      navigate("/Home");
    }
  }, []);

  // ===========================================
  // ===========================================

  return (
    <>
      <div className="" id="InputContainer">
        <label>Email</label>
        <input
          type="email"
          onChange={(e: any) => {
            setEmail(e.target.value);
          }}
        />
        <label>Password</label>

        <input
          type="password"
          onChange={(e: any) => {
            setPassword(e.target.value);
          }}
        />
        <button onClick={() => SignIn()}>SignIn</button>
      </div>
    </>
  );
}
