package dev.pichborithk.sala.jas.resolver

import dev.pichborithk.sala.jas.model.Album
import dev.pichborithk.sala.jas.service.AlbumService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class AlbumResolver(
  private final val albumService: AlbumService
) {

  @QueryMapping
  fun getAlbumById(@Argument id: String): Album? {
    return albumService.getAlbumById(id)
  }

//  @MutationMapping
//  fun addAlbumTracksToProduction(@Argument id: String): Album? {
//    return albumService.addAlbumTracksToProduction(id)
//  }

}