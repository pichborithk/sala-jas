package dev.pichborithk.sala.jas.repository

import dev.pichborithk.sala.jas.model.Artist
import org.springframework.data.jpa.repository.JpaRepository

interface ArtistRepository : JpaRepository<Artist, String> {
  fun findByProductionsId(productionId: String): List<Artist>
}