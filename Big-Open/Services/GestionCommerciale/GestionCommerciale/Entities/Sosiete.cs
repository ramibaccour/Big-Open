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
        public string MatriculeFiscale { get; set; }
        public string CapitalSociete { get; set; }
        public string Adresse { get; set; }
        public string CodePostal { get; set; }
        public string VilleS { get; set; }
        public string Region { get; set; }
        public string Pays { get; set; }
        public string Telephone { get; set; }
        public string Faxe { get; set; }
        public string Mobile { get; set; }
        public string SiteWeb { get; set; }
    }
}
