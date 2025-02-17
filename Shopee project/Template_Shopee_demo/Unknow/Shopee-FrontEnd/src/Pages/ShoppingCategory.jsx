import React, { useContext } from 'react'
import './CSS/ShoppingCategory.css'
import {ShopContext} from '../Context/ShopContext'
import dropDownIcon from '../Components/Assets/dropdown_icon.png'
import { Item  } from '../Components/Item/Item1'
const ShoppingCategory = (props) => {
  const {all_product}= useContext(ShopContext);
  return (
    <div className='shop_category'>
      <img className='shopCategoryBanner' src={props.banner} alt="" />
      <div className="shopCategory_indexSort">
        <p>
          <span>Showing 1-12</span> out of 36 products
        </p>
        <div className="shopCategory_sort">
          Sort by <img src={dropDownIcon} alt="" />
        </div>
      </div>
      <div className="shopCategoryProducts">
        {all_product.map((item,i)=>{
          if(props.category===item.category){
            return <Item key={i} id={item.id} name={item.name} image={item.image} new_price={item.new_price} old_price={item.old_price}/>
          }
          else{
            return null;
          }
        })}
      </div>
      <div className="shopCategoryLoadMore">
          Explore More
      </div>
    </div>
  )
}
export default ShoppingCategory;
