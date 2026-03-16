package dev.pichborithk.sala.jas.resolver

import dev.pichborithk.sala.jas.model.Track
import dev.pichborithk.sala.jas.service.TrackService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class TrackResolver(
  private val trackService: TrackService
) {

  @QueryMapping
  fun getTrackById(@Argument id: String): Track? {
    return trackService.getTrackById(id)
  }

  @MutationMapping
  fun updateTrackArtist(@Argument trackId: String, @Argument artistId: String): Track? {
    return trackService.updateTrackArtist(trackId, artistId)
  }
}