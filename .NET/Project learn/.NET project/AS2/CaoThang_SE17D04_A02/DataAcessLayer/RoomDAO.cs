using BusinessObjects;
using Microsoft.EntityFrameworkCore;

namespace DataAcessLayer
{
    public class RoomDAO
    {
        public static List<RoomInfomation> GetAllRooms()
        {
            using (var context = new FuminiHotelSystemContext())
            {
                return context.RoomInfomations
           .Include(x => x.RoomType).ToList();
          
                
            }
        }

        public static List<RoomType> GetRoomtype()
        {
            using (var context = new FuminiHotelSystemContext())
            {
                return context.RoomTypes.ToList();

            }
        }

        public static RoomInfomation GetRoomById(int roomNumber)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                var rooms = context.RoomInfomations.Include(x => x.RoomType).Where(x=>x.RoomNumber==roomNumber)
           
           .Select(room => new RoomInfomation
           {
               RoomId = room.RoomId,
               RoomNumber = room.RoomNumber,
               RoomMaxCapacity = room.RoomMaxCapacity,
               RoomStatus = room.RoomStatus,
   
               RoomPricePerDay = room.RoomPricePerDay,
               RoomDetailDescription = room.RoomDetailDescription
           }).FirstOrDefault();
                return rooms;
            }
        }

        public static void AddRoom(RoomInfomation room)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                context.RoomInfomations.Add(room);
                context.SaveChanges();
            }
        }

        public static void UpdateRoom(RoomInfomation room)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                var existingRoom = context.RoomInfomations.Find(room.RoomId);
               if(existingRoom != null)
                {
                    existingRoom.RoomId = room.RoomId;
                    existingRoom.RoomNumber = room.RoomNumber;
                    existingRoom.RoomMaxCapacity = room.RoomMaxCapacity;
                    existingRoom.RoomPricePerDay = room.RoomPricePerDay;
                    existingRoom.RoomDetailDescription = room.RoomDetailDescription;
                    existingRoom.RoomStatus = room.RoomStatus;
                }
                    context.SaveChanges();
                }
            }
        

        public static void DeleteRoom(int roomId)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                var room = context.RoomInfomations.Find(roomId);
                if (room != null)
                {
                    if (!room.BookingDetails.Any())
                    {
                        context.RoomInfomations.Remove(room);
                    }
                    else
                    {
                        room.RoomStatus = true;
                    }
                    context.SaveChanges();
                }
            }
        }
    }
}
