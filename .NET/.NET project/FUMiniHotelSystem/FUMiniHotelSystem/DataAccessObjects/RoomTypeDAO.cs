using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessObjects
{
    public class RoomTypeDAO
    {
        private static List<RoomType> listRoomType;
        public RoomTypeDAO()
        {
            RoomType singleRoom = new RoomType(1, "Single", "Single room", "Single occupancy");
            RoomType doubleRoom = new RoomType(2, "Double", "Double room", "Double occupancy");
            RoomType tripleRoom = new RoomType(3, "Triple", "Triple room", "Triple occupancy");
            listRoomType = new List<RoomType> { singleRoom, doubleRoom, tripleRoom };
        }
        public List<RoomType> GetRoomTypes()
        {
            return listRoomType;
        }
        //CRUD RoomType
        public RoomType GetRoomTypeById(int id)
        {
            foreach (RoomType r in listRoomType.ToList())
            {
                if (r.RoomTypeID == id)
                {
                    return r;
                }
            }
            return null;
        }
        public void AddRoomType(RoomType roomType)
        {
            listRoomType.Add(roomType);
        }
        public void DeleteRoomType(RoomType roomType)
        {
            foreach (RoomType r in listRoomType.ToList())
            {
                if (r.RoomTypeID == roomType.RoomTypeID)
                {
                    listRoomType.Remove(r);
                }
            }
        }
        public void UpdateRoomType(RoomType roomType)
        {
            foreach (RoomType r in listRoomType.ToList())
            {
                if (r.RoomTypeID == roomType.RoomTypeID)
                {
                    r.RoomTypeName = roomType.RoomTypeName;
                    r.TypeDescription = roomType.TypeDescription;
                    r.TypeNode = roomType.TypeNode;
                }
            }
        }
    }
}
