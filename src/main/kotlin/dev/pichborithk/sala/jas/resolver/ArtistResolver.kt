package dev.pichborithk.sala.jas.resolver

import dev.pichborithk.sala.jas.model.Artist
import dev.pichborithk.sala.jas.service.ArtistService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ArtistResolver(
  private val artistService: ArtistService,
) {

  @QueryMapping
  fun getArtists(): MutableList<Artist> {
    return artistService.getArtists()
  }

  @QueryMapping
  fun getArtistById(@Argument id: String): Artist? {
    return artistService.getArtistById(id)
  }

  @MutationMapping
  fun createArtist(@Argument name: String): Artist? {
    return artistService.createArtist(name)
  }
}