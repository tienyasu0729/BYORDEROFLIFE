using System.ComponentModel.DataAnnotations;

namespace BusinessObject
{
    public class Order
    {
        public int OrderId { get; set; }
        public string CustomerName { get; set; }
        [DataType(DataType.Date)]
        public DateTime OrderDate { get; set; }
        public virtual ICollection<OrderDetail> OrderDetails { get; set; }
    }

}
