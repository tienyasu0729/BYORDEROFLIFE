import React from "react";
import "./CSS/LoginSignUp.css";
import { useState} from "react";
export const LoginSignUp = () => {
  const [state, setState] = useState("Login");
  const [formData, setFormData] = useState({
    name: "",
    password: "",
    email: "",
  });
  const changeHandler = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };
  const login = async () => {
    console.log("Login Function Executed", formData);
    let responseData;
    await fetch("http://localhost:4000/login", {
      method: "POST",
      headers: {
        Accept: "application/form-data",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((res) => res.json)
      .then((data) => (responseData = data));

    if (responseData.success) {
      // localStorage.setItem("auth-token", responseData.token);
      window.location.replace("/");
    }
    else{
      alert(responseData.errors)
    }
  };
  const signup = async () => {
    console.log("SignUp Function Executed", formData);
    let responseData;
    await fetch("http://localhost:4000/signup", {
      method: "POST",
      headers: {
        Accept: "application/form-data",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((res) => res.json)
      .then((data) => (responseData = data));

    if (responseData.success) {
      // localStorage.setItem("auth-token", responseData.token);
      window.location.replace("/");
    }
    else{
      alert(responseData.errors)
    }
  };

  return (
    <div className="loginSignUp">
      <div className="loginSignUpContainer">
        <h1>{state}</h1>
        <div className="loginSignUpFields">
          {state === "Sign Up" ? (
            <input
              name="username"
              value={formData.username}
              onChange={changeHandler}
              type="text"
              placeholder="Your Name"
            />
          ) : (
            <></>
          )}
          <input
            name="email"
            value={formData.email}
            onChange={changeHandler}
            type="email"
            placeholder="Email Address"
          />
          <input
            name="password"
            value={formData.password}
            onChange={changeHandler}
            type="password"
            placeholder="Password"
          />
        </div>
        <button
          onClick={() => {
            state === "Login" ? login() : signup();
          }}
        >
          Continue
        </button>
        {state === "Sign Up" ? (
          <p className="loginSignUp_login">
            Already Have an Account!
            <span onClick={() => setState("Login")}> Login Here</span>
          </p>
        ) : (
          <p className="loginSignUp_login">
            Create an Account
            <span onClick={() => setState("Sign Up")}> Click Here</span>
          </p>
        )}

        <div className="loginSignUp_agree">
          <input type="checkbox" />
          <p>By Continuing, I agree to the terms of use & Privacy Policies</p>
        </div>
      </div>
    </div>
  );
};
