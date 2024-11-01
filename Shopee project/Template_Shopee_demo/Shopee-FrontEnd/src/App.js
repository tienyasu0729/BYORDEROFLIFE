import './App.css';
import { Navbar } from './Components/Navbar/Navbar';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
// import ShopCategory from './Pages/ShopCategory';
// import Shop  from './Pages/Shop';
import { Shopping } from './Pages/Shopping';
import ShoppingCategory   from './Pages/ShoppingCategory';
import Product  from './Pages/Product';
import { Cart } from './Pages/Cart';
import { LoginSignUp } from './Pages/LoginSignUp';
import { Footer } from './Components/Footer/Footer';
import men_banner from './Components/Assets/banner_mens.png'
import women_banner from './Components/Assets/banner_women.png'
import kid_banner from './Components/Assets/banner_kids.png'

function App() {
  return (
    <div >
      <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path='/' element={<Shopping/>}/>
        <Route path='/men' element={<ShoppingCategory banner={men_banner} category="men"/>}/>
        <Route path='/women' element={<ShoppingCategory banner={women_banner} category="women"/>}/>
        <Route path='/kid' element={<ShoppingCategory banner={kid_banner} category="kid"/>}/>
        <Route path='/product' element={<Product/>}>
          <Route path=':productId' element={<Product/>}/>
        </Route>
        <Route path='/cart' element={<Cart/>}/>
        <Route path='/login' element={<LoginSignUp/>}/>
      </Routes>
      <Footer/>
      </BrowserRouter>
      
    </div>
  );
}
export default App;

