using MongoDB.Driver;
using GestionComptes.Models;
using Microsoft.Extensions.Options;

namespace GestionComptes.Services;

public class SosietesServices : ISosietesServices
{
    private readonly IMongoCollection<Sosiete> _sosiete;
    public SosietesServices(IOptions<DataBaseSettings> dataBaseSettings)
    {
        var mongoClient = new MongoClient(dataBaseSettings.Value.ConnectionString);
        var mongoDatabase = mongoClient.GetDatabase(dataBaseSettings.Value.DatabaseName);
        _sosiete = mongoDatabase.GetCollection<Sosiete>(dataBaseSettings.Value.SosietesCollectionName);
    }
    public async Task<List<Sosiete>> GetAsync()
    {
       return await _sosiete.Find(_ => true).ToListAsync();
    }
}
