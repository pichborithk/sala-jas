package dev.pichborithk.sala.jas.service

import dev.pichborithk.sala.jas.model.Album
import dev.pichborithk.sala.jas.model.Production
import dev.pichborithk.sala.jas.repository.AlbumRepository
import dev.pichborithk.sala.jas.repository.TrackRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AlbumService(
  private final val trackRepository: TrackRepository,
  private final val albumRepository: AlbumRepository,
) {
  fun getAlbumById(id: String): Album? {
    val album = albumRepository.findByIdOrNull(id)
//    album?.let {
//      album.tracks = trackRepository.findByAlbumId(id)
//        .map {
//          it.id?.let { id ->
//            it.artists = artistRepository.findByTracksId(id)
//          }
//          return@map it
//        }
//        .toMutableList()
//      album.artists = artistRepository.findByAlbumsId(id)
//      album.production = productionRepository.findByAlbumsId(id)
//    }
    return album
  }

  fun addAlbumTracksToProduction(id: String): Album? {
    val album = albumRepository.findByIdOrNull(id)
    album?.tracks?.forEach {
      it.id?.let { trackId ->
        trackRepository.findByIdOrNull(trackId)?.let { track ->
          track.production = album.production
          trackRepository.save(track)
        }
      }
    }
    return album
  }
}