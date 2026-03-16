package dev.pichborithk.sala.jas.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.hibernate.annotations.UuidGenerator

@Entity(name = "albums")
class Album(

  var title: String,

  ) {

  @Id
  @GeneratedValue
  @UuidGenerator
  var id: String? = null

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
  var tracks: MutableList<Track> = mutableListOf()

  @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
  @JoinTable(
    name = "album_artist",
    joinColumns = [JoinColumn(name = "album_id")],
    inverseJoinColumns = [JoinColumn(name = "artist_id")]
  )
  var artists: MutableList<Artist> = mutableListOf()

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "production_id")
  var production: Production? = null
}