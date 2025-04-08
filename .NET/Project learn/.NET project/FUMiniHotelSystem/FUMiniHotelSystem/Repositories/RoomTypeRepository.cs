using BusinessObject;
using DataAccessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class RoomTypeRepository
    {
        RoomTypeDAO dao = new RoomTypeDAO();
        public List<RoomType> GetRoomTypes() => dao.GetRoomTypes();
    }
}
