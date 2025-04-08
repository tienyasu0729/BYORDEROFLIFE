using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessObjects
{
    public class RoomDAO
    {
        private static List<RoomInformation> listRoom;
        public RoomDAO()
        {
            RoomInformation room1 = new RoomInformation(1, "101", "Single Room", 1, 1, 100, 1);
            RoomInformation room2 = new RoomInformation(2, "102", "Double Room", 2, 1, 150, 2);
            RoomInformation room3 = new RoomInformation(3, "103", "Triple Room", 3, 1, 200, 3);
            listRoom = new List<RoomInformation> { room1, room2, room3 };
        }
        public List<RoomInformation> GetRooms()
        {
            return listRoom;
        }
        //CRUD RoomInfomation
        public RoomInformation GetRooomById(int id)
        {
            foreach (RoomInformation ri in listRoom.ToList())
            {
                if (ri.RoomID == id)
                {
                    return ri;
                }
            }
            return null;
        }
        public void AddRoom(RoomInformation room)
        {
            listRoom.Add(room);
        }
        public void DeleteRoom(RoomInformation room)
        {
            foreach (RoomInformation ri in listRoom.ToList())
            {
                if (ri.RoomID == room.RoomID)
                {
                    listRoom.Remove(ri);
                }
            }
        }
        public void UpdateRoom(RoomInformation room)
        {
            foreach (RoomInformation ri in listRoom.ToList())
            {
                if (ri.RoomID == room.RoomID)
                {
                    ri.RoomNumber =  room.RoomNumber;
                    ri.RoomDescription = room.RoomDescription;
                    ri.RoomMaxCapacity = room.RoomMaxCapacity;
                    ri.RoomStatus = room.RoomStatus;
                    ri.RoomPricePerDate = room.RoomPricePerDate;
                    ri.RoomType = room.RoomType;
                }
            }
        }
    }
}
