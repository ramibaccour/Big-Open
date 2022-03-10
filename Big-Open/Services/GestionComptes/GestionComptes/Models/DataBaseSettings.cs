namespace GestionComptes.Models
{
    public class DataBaseSettings
    {
        public string ConnectionString { get; set; } = null!;

        public string DatabaseName { get; set; } = null!;

        public string SosietesCollectionName { get; set; } = null!;
        public string PersonnesCollectionName { get; set; } = null!;
    }
}
