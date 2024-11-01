import React, { useContext } from "react";
import "./CartItems.css";
import { ShopContext } from "../../Context/ShopContext";
import removeIcon from "../Assets/cart_cross_icon.png";
const CartItem = () => {
  const {getTotalCartAmount,all_product, cartItems, removeFromCart } = useContext(ShopContext);
  return (
    <div className="cartItems">
      <div className="cartItemsFormatMain">
        <p>Products</p>
        <p>Title</p>
        <p>Price</p>
        <p>Quantity</p>
        <p>Total</p>
        <p>Remove</p>
      </div>
      <hr />
      {all_product.map((e) => {
        if (cartItems[e.id] > 0) {
          return (
            <div>
              <div className="cartItemsFormat cartItemsFormatMain">
                <img src={e.image} alt="" className="cartIconProductIcon" />
                <p>{e.name}</p>
                <p>${e.new_price}</p>
                <button className="cartItemsQuantity">{cartItems[e.id]}</button>
                <p>${e.new_price * cartItems[e.id]}</p>
                <img
                  className="cartItemsRemoveIcon"
                  src={removeIcon}
                  onClick={() => {
                    removeFromCart(e.id);
                  }}
                  alt=""
                />
              </div>
              <hr />
            </div>
          );
        }
        return null;
      })}
      <div className="cartItemsDown">
        <div className="cartItemsTotal">
          <h1>cart Total</h1>
          <div>
            <div className="cartItemsTotalItem">
              <p>Sub-Total</p>
              <p>${getTotalCartAmount()}</p>
            </div>
            <hr />
            <div className="cartItemsTotalItem">
              <p>Shipping fee</p>
              <p>Free</p>
            </div>
            <div className="cartItemsTotalItem">
              <h3>Total</h3>
              <h3>${getTotalCartAmount()}</h3>
            </div>
          </div>
          <button>PROCEED TO CHECKOUT</button>
        </div>
        <div className="cartItemPromoCode">
          <p>If you have Promo code, Enter it here</p>
          <div className="cartItemPromoBox">
            <input type="text" placeholder="Promo Code" />
            <button>Submit</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CartItem;
