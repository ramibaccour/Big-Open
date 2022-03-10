using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace GestionComptes.Models
{
    public class Sosiete
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string IdSosiete { get; set; }
        [BsonElement("Name")]
        public string Nom { get; set; }
    }
}
