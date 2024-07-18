using Model;
using Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service
{
    public class RoomTypeService
    {
        private readonly Repository<RoomType> _roomTypeRepository;

        public async Task<List<RoomType>> GetAllRoomsTypeAsync()
        {
            return await _roomTypeRepository.GetAllAsync();
        }

        public async Task<RoomType> GetRoomTypeByIdAsync(int roomId)
        {
            return await _roomTypeRepository.GetByIdAsync(roomId);
        }

        public async Task AddRoomTypeAsync(RoomType roomType)
        {
            await _roomTypeRepository.AddAsync(roomType);
        }

        public async Task UpdateRoomTypeAsync(RoomType roomType)
        {
            await _roomTypeRepository.UpdateAsync(roomType);
        }

        public async Task DeleteRoomTypeAsync(int roomTypeID)
        {
            await _roomTypeRepository.DeleteAsync(roomTypeID);
        }
    }
}
