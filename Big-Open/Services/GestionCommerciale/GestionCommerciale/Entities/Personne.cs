using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace GestionComptes.Models
{
    public class Personne
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string IdPersonne { get; set; }
        [BsonElement("Name")]
        public string Nom { get; set; }
        public string Prenom { get; set; }
        public string Civilite { get; set; }
        public string Login { get; set; }
        public string MotPasse { get; set; }
        public string IdSosiete { get; set; }

    }
}
