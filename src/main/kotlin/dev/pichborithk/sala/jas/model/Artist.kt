package dev.pichborithk.sala.jas.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.PreUpdate
import org.hibernate.annotations.UuidGenerator
import java.time.Instant

@Entity(name = "artists")
class Artist(

  var name: String,
  @Column(name = "created_at")
  var createdAt: String = Instant.now().toString(),
  @Column(name = "updated_at")
  var updatedAt: String? = null

) {

  @Id
  @GeneratedValue
  @UuidGenerator
  var id: String? = null

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artists")
  var tracks: MutableList<Track> = mutableListOf()

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artists")
  var albums: MutableList<Album> = mutableListOf()

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artists")
  var productions: MutableList<Production> = mutableListOf()

  @PreUpdate
  fun onUpdate() {
    updatedAt = Instant.now().toString()
  }
}