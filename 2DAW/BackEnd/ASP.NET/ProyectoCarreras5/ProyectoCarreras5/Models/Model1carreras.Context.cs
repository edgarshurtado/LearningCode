﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ProyectoCarreras5.Models
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class carrerasEntities : DbContext
    {
        public carrerasEntities()
            : base("name=carrerasEntities")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<carrera> carreras { get; set; }
        public virtual DbSet<chip> chips { get; set; }
        public virtual DbSet<Participante> Participantes { get; set; }
        public virtual DbSet<sysdiagrams> sysdiagrams { get; set; }
    }
}
