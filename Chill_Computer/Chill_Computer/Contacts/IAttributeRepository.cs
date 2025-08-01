using BusinessObjects.Models;

namespace Chill_Computer.Contacts
{
    public interface IAttributeRepository
    {
        List<BusinessObjects.Models.Attribute> GetAllAttributes();
        List<BusinessObjects.Models.Attribute> GetAttributeByTypeId(int id);
    }
}
