﻿using BusinessObjects.Models;
using Chill_Computer.Contacts;
using Chill_Computer.Models;
using Chill_Computer.ViewModels;
using Microsoft.EntityFrameworkCore;

namespace Chill_Computer.Services
{
    public class CartItemRepository : ICartItemRepository
    {
        private readonly ChillComputerContext _context;
        public CartItemRepository(ChillComputerContext context)
        {
            _context = context;
        }
        public void AddCartItem(CartItem cartItem)
        {
            _context.CartItems.Add(cartItem);
            _context.SaveChanges();
        }
        public List<CartItemViewModel> GetCartItemByCartId(int cartId)
        {
            var list = from cartItem in _context.CartItems
                       where cartItem.CartId == cartId
                       join product in _context.Products on cartItem.ProductId equals product.ProductId into productJoin
                       from product in productJoin.DefaultIfEmpty()
                       join pc in _context.Pcs on cartItem.PcId equals pc.PcId into pcJoin
                       from pc in pcJoin.DefaultIfEmpty()
                       select new
                       {
                           cartItem.ProductId,
                           cartItem.PcId,
                           ProductName = product != null ? product.ProductName : "Custom PC Build",
                           cartItem.ItemQuantity,
                           Img1 = product != null ? product.Img1 : null,
                           ProductPrice = product != null ? product.Price : (pc != null ? pc.Price : 0),
                           Version = product != null ? product.Version : null,
                           Color = product != null ? product.Color : null,
                           PcPrice = pc != null ? pc.Price : 0
                       };

            var groupedItems = list
                .GroupBy(i => new { i.ProductId, i.ProductName, i.Img1, i.ProductPrice, i.Version, i.Color, i.PcId })
                .Select(g => new CartItemViewModel
                {
                    ProductId = g.Key.ProductId,
                    ProductName = g.Key.ProductName,
                    Quantity = g.Sum(i => i.ItemQuantity),
                    ImageUrl = g.Key.Img1,
                    Price = g.Key.ProductPrice,
                    Version = g.Key.Version,
                    Color = g.Key.Color,
                    FormattedPrice = g.Key.ProductPrice.ToString("N0"),
                    PcId = g.Key.PcId
                }).ToList();

            return groupedItems;
        }



        public void DeleteItemByProductIdAndCartId(int productId, int pcId, int cartId)
        {
            var item = _context.CartItems.FirstOrDefault(i =>
                (i.ProductId == productId && i.CartId == cartId) ||
                (i.PcId == pcId && i.CartId == cartId));

            if (item != null)
            {
                _context.Remove(item);
                _context.SaveChanges();
            }
        }

        public void DeleteAllByCartId(int cartId)
        {
            var items = _context.CartItems.Where(i => i.CartId == cartId).ToList();
            if(items != null && items.Count > 0)
            {
                _context.CartItems.RemoveRange(items);
                _context.SaveChanges();
            }
        }
    }
}


//public List<CartItemViewModel> GetCartItemByCartId(int cartId)
//{
//    var list = from cartItem in _context.CartItems
//               join product in _context.Products on cartItem.ProductId equals product.ProductId
//               where cartItem.CartId == cartId
//               select new
//               {
//                   product.ProductId,
//                   product.ProductName,
//                   cartItem.ItemQuantity,
//                   product.Img1,
//                   product.Price,
//                   product.Version,
//                   product.Color
//               };

//    var groupedItems = list
//        .GroupBy(i => new { i.ProductId, i.ProductName, i.Img1, i.Price, i.Version, i.Color })
//        .Select(g => new CartItemViewModel
//        {
//            ProductId = g.Key.ProductId,
//            ProductName = g.Key.ProductName,
//            Quantity = g.Sum(i => i.ItemQuantity),
//            ImageUrl = g.Key.Img1,
//            Price = g.Key.Price,
//            Version = g.Key.Version,
//            Color = g.Key.Color,
//            FormattedPrice = g.Key.Price.ToString("N0")
//        }).ToList();

//    return groupedItems;
//}
