package dev.pichborithk.sala.jas.repository

import dev.pichborithk.sala.jas.model.Track
import org.springframework.data.jpa.repository.JpaRepository

interface TrackRepository : JpaRepository<Track, String> {
  fun findByProductionId(productionId: String): MutableList<Track>
  fun findByAlbumId(albumId: String): MutableList<Track>
}