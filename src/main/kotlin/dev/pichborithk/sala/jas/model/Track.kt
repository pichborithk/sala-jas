package dev.pichborithk.sala.jas.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.PreUpdate
import org.hibernate.annotations.UuidGenerator
import java.time.Instant

@Entity(name = "tracks")
class Track(

  var title: String,
  @Column(name = "audio_url")
  var audioUrl: String,
  @Column(name = "download_url")
  var downloadUrl: String,
  @Column(name = "cover_url")
  var coverUrl: String,
  var artist: String,
  @Column(name = "download_status")
  var downloadStatus: String,
  @Column(name = "created_at")
  var createdAt: String = Instant.now().toString(),
  @Column(name = "updated_at")
  var updatedAt: String? = null

) {

  @Id
  @GeneratedValue
  @UuidGenerator
  var id: String? = null

  @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
  @JoinTable(
    name = "track_artist",
    joinColumns = [JoinColumn(name = "track_id")],
    inverseJoinColumns = [JoinColumn(name = "artist_id")]
  )
  var artists: MutableList<Artist> = mutableListOf()

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "album_id")
  var album: Album? = null

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "production_id")
  var production: Production? = null

  @PreUpdate
  fun onUpdate() {
    updatedAt = Instant.now().toString()
  }
}