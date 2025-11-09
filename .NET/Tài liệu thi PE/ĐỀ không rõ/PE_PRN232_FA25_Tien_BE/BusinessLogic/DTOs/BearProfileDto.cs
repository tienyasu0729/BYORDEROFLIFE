using System;

namespace BusinessLogic.DTOs
{
    public class BearProfileDto
    {
        public int BearProfileId { get; set; }
        public int BearTypeId { get; set; }
        public string BearTypeName { get; set; } // Hiển thị tên loại gấu
        public string BearName { get; set; }
        public double BearWeight { get; set; }
        public string Characteristics { get; set; }
        public string CareNeeds { get; set; }
        public DateTime ModifiedDate { get; set; }
    }
}