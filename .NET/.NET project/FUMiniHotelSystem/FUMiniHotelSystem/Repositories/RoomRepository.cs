using BusinessObject;
using DataAccessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class RoomRepository
    {
        RoomDAO dao = new RoomDAO();
        public List<RoomInformation> GetRooms() => dao.GetRooms();
        public RoomInformation GetRooomById(int id) => dao.GetRooomById(id);
        public void AddRoom(RoomInformation room) => dao.AddRoom(room);
        public void UpdateRoom(RoomInformation room) => dao.UpdateRoom(room);
        public void DeleteRoom(RoomInformation room) => dao.DeleteRoom(room);
    }
}
