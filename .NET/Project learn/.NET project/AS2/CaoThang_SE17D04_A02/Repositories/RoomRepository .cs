using BusinessObjects;
using DataAcessLayer;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class RoomRepository : IRoomRepository
    {
        public void AddRoom(RoomInfomation room)=> RoomDAO.AddRoom(room);
 
        public void DeleteRoomByRoomId(int roomId)=> RoomDAO.GetRoomById(roomId);


        public List<RoomInfomation> GetAllRooms()=> RoomDAO.GetAllRooms();
 

        public RoomInfomation GetRoomById(int roomId)=> RoomDAO.GetRoomById(roomId);
   

        public void UpdateRoom(RoomInfomation room)=> RoomDAO.UpdateRoom(room);

        public List<RoomType> GetRoomtype()=>  RoomDAO.GetRoomtype();
        
    }
}
