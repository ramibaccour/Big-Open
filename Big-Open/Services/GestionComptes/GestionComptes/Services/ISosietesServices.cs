using GestionComptes.Models;

namespace GestionComptes.Services
{
    public interface ISosietesServices
    {
        Task<List<Sosiete>> GetAsync();

    }
}
