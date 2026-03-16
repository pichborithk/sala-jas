package dev.pichborithk.sala.jas.model

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import org.hibernate.annotations.UuidGenerator

@Entity(name = "artists")
class Artist(

  var name: String

) {

  @Id
  @GeneratedValue
  @UuidGenerator
  var id: String? = null

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artists")
  var tracks: MutableSet<Track> = mutableSetOf()

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artists")
  var albums: MutableSet<Album> = mutableSetOf()

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artists")
  var productions: MutableSet<Production> = mutableSetOf()
}