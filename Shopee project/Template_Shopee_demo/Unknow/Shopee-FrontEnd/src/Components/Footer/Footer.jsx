import React from 'react'
import './Footer.css'
import footer_logo from '../Assets/logo_big.png'
import instagram_icon from '../Assets/instagram_icon.png'
import pinterest_icon from '../Assets/pintester_icon.png'
import whatsapp_icon from '../Assets/whatsapp_icon.png'
export const Footer = () => {
  return (
    <div className='footer'>
        <div className="footer_logo">
            <img src={footer_logo} alt="" />
            <p>SHOPPER</p>
        </div>
        <ul className="footer_links">
            <li>Company</li>
            <li>Products</li>
            <li>Offices</li>
            <li>About</li>
            <li>Contact</li>
        </ul>
        <div className="footer_social_icons">
            <div className="footer_icons_container">
                <img src={instagram_icon} alt="" />
            </div>
            <div className="footer_icons_container">
                <img src={pinterest_icon} alt="" />
            </div>
            <div className="footer_icons_container">
                <img src={whatsapp_icon} alt="" />
            </div>
        </div>
            <div className="footer_copyright">
                <hr />
                <p>Copyright @2023</p>
            </div>
    </div>
  )
}
