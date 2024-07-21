using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public interface IRoomRepository
    {
        List<RoomInfomation> GetAllRooms();

        RoomInfomation GetRoomById(int roomId);


        void AddRoom(RoomInfomation room);


        void UpdateRoom(RoomInfomation room);


        void DeleteRoomByRoomId(int roomId);

        List<RoomType> GetRoomtype();


    }
}
