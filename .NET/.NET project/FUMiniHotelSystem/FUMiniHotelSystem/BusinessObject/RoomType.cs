using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BusinessObject
{
    public class RoomType
    {
        public RoomType()
        {
            RoomInformations = new HashSet<RoomInformation>();
        }
        public RoomType(int roomTypeId, string roomTypeName, string typeDescription, string typeNode)
        {
            this.RoomTypeID = roomTypeId;
            this.RoomTypeName = roomTypeName;
            this.TypeDescription = typeDescription;
            this.TypeNode = typeNode;
        }
        public int RoomTypeID { get; set; }
        public string RoomTypeName { get; set; }
        public string TypeDescription { get; set;}
        public string TypeNode { get; set; }
        public virtual ICollection<RoomInformation> RoomInformations { get; set; }
    }
}
