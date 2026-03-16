package dev.pichborithk.sala.jas.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import org.hibernate.annotations.UuidGenerator

@Entity(name = "productions")
class Production(
  var name: String
) {

  @Id
  @GeneratedValue
  @UuidGenerator
  var id: String? = null

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "production")
  var albums: MutableList<Album> = mutableListOf()

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "production")
  var tracks: MutableList<Track> = mutableListOf()

  @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
  @JoinTable(
    name = "production_artist",
    joinColumns = [JoinColumn(name = "production_id")],
    inverseJoinColumns = [JoinColumn(name = "artist_id")]
  )
  var artists: MutableSet<Artist> = mutableSetOf()
}
