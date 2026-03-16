package dev.pichborithk.sala.jas.model

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.UuidGenerator


@Entity(name = "tracks")
class Track(

  var title: String,
  var audio_url: String,
  var download_url: String,
  var cover_url: String,
  var artist: String,

  ) {

  @Id
  @GeneratedValue
  @UuidGenerator
  var id: String? = null

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "track_artist",
    joinColumns = [JoinColumn(name = "track_id")],
    inverseJoinColumns = [JoinColumn(name = "artist_id")]
  )
  var artists: MutableSet<Artist> = mutableSetOf()

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "album_id")
  var album: Album? = null

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "production_id")
  var production: Production? = null
}