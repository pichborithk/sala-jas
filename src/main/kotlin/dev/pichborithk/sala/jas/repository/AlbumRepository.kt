package dev.pichborithk.sala.jas.repository

import dev.pichborithk.sala.jas.model.Album
import org.springframework.data.jpa.repository.JpaRepository

interface AlbumRepository : JpaRepository<Album, String> {
  fun findByProductionId(productionId: String): List<Album>
}