﻿using BusinessObjects.Models;
using Chill_Computer.Models;

namespace Chill_Computer.Contacts
{
    public interface IUserRepository
    {
        public User GetUserByUserName(string username);
        public void AddUser(User user);
    }
}
