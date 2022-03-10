using Microsoft.AspNetCore.Mvc;
using GestionComptes.Services;
using GestionComptes.Models;
namespace GestionComptes.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class SosietesController : ControllerBase
    {
        private readonly ISosietesServices _sosietesService;
        public SosietesController(ISosietesServices booksService) =>
            _sosietesService = booksService;

        [HttpGet]
        public async Task<List<Sosiete>> Get() =>
        await _sosietesService.GetAsync();
    }
}
