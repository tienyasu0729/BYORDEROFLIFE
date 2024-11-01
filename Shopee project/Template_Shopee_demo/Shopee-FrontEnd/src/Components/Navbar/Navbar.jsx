import React, { useContext, useRef, useState } from "react";
import "./Navbar.css";
import logo from "../Assets/logo.png";
import cart_icon from "../Assets/cart_icon.png";
import { Link } from "react-router-dom";
import { ShopContext } from "../../Context/ShopContext";
import navDropdown from "../Assets/navDropDown.png";
export const Navbar = () => {
  const [menu, setmenu] = useState("shop");
  const { getTotalCartItems } = useContext(ShopContext);
  const menuRef = useRef();
  const dropDownToggle = (e) => {
    menuRef.current.classList.toggle("navMenuVisible");
    e.target.classList.toggle("open");
  };
  return (
    <div className="navbar">
      <div className="nav_logo">
        <img src={logo} alt="" />
        <p>Shooper</p>
      </div>
      <img
        className="navDropDown"
        onClick={dropDownToggle}
        src={navDropdown}
        alt=""
      />
      <ul ref={menuRef} className="nav_menu">
        <li
          onClick={() => {
            setmenu("shop");
          }}
        >
          <Link style={{ textDecoration: "none" }} to="/">
            Shop
          </Link>
          {menu === "shop" ? <hr /> : <></>}
        </li>
        <li
          onClick={() => {
            setmenu("men");
          }}
        >
          <Link style={{ textDecoration: "none" }} to="/men">
            Men
          </Link>
          {menu === "men" ? <hr /> : <></>}
        </li>
        <li
          onClick={() => {
            setmenu("women");
          }}
        >
          <Link style={{ textDecoration: "none" }} to="women">
            Women
          </Link>
          {menu === "women" ? <hr /> : <></>}
        </li>
        <li
          onClick={() => {
            setmenu("kids");
          }}
        >
          <Link style={{ textDecoration: "none" }} to="kid">
            Kids
          </Link>
          {menu === "kids" ? <hr /> : <></>}
        </li>
      </ul>
      <div className="nav_login_cart">
        {localStorage.getItem('auth-token')?<button onClick={()=>{localStorage.removeItem('auth-token');window.location.replace('/')}}>Logout</button>:<Link to="login">
          <button>Login</button>
        </Link>}
        
        <Link to="cart">
          <img src={cart_icon} alt="" />
        </Link>
        <div className="nav_cart_count">{getTotalCartItems()}</div>
      </div>
    </div>
  );
};
