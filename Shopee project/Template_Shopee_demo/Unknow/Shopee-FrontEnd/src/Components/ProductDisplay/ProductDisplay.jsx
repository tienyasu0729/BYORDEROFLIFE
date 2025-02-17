import React from "react";
import "./ProductDisplay.css";
import starIcon from "../Assets/star_icon.png";
import starDullIcon from "../Assets/star_dull_icon.png";
import { useContext } from "react";
import { ShopContext } from "../../Context/ShopContext";
const ProductDisplay = (props) => {
  const { product } = props;
  const { addToCart } = useContext(ShopContext);
  return (
    <div className="productDisplay">
      <div className="productDisplayLeft">
        <div className="productDisplayImgList">
          <img src={product.image} alt="" />
          <img src={product.image} alt="" />
          <img src={product.image} alt="" />
          <img src={product.image} alt="" />
        </div>
        <div className="productDisplayImg">
          <img src={product.image} alt="" className="productDisplayImgMain" />
        </div>
      </div>
      <div className="productDisplayRight">
        <h1>{product.name}</h1>
        <div className="productDisplayRightStar">
          <img src={starIcon} alt="" />
          <img src={starIcon} alt="" />
          <img src={starIcon} alt="" />
          <img src={starIcon} alt="" />
          <img src={starDullIcon} alt="" />
          <p>155</p>
        </div>
        <div className="productDisplayRightPrices">
          <div className="productDisplayRightPricesOld">
            ₹{product.old_price}
          </div>
          <div className="productDisplayRightPricesNew">
            ₹{product.new_price}
          </div>
        </div>
        <div className="productDisplayRightDescription">
          Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem IpsumLorem Ipsum Lorem
          IpsumLorem Ipsum Lorem IpsumLorem Ipsum Lorem IpsumLorem Ipsum Lorem
          Ipsum
        </div>
        <div className="productDisplayRightSize">
          <h1>Select Size</h1>
          <div className="productDisplayRightSizes">
            <div>S</div>
            <div>M</div>
            <div>L</div>
            <div>XL</div>
            <div>XXL</div>
          </div>
        </div>
        <button onClick={()=>addToCart(product.id)}>ADD TO CART</button>
        <p className="productDisplayRightCategory">
          <span>Category: </span>Women, T-shirt, Crop Top
        </p>
        <p className="productDisplayRightCategory">
          <span>Tags: </span>Modern,Latest
        </p>
      </div>
    </div>
  );
};

export default ProductDisplay;
