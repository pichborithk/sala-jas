package dev.pichborithk.sala.jas.repository

import dev.pichborithk.sala.jas.model.Track
import org.springframework.data.jpa.repository.JpaRepository

interface TrackRepository : JpaRepository<Track, String> {
  fun findByProductionId(projectId: String): List<Track>
}