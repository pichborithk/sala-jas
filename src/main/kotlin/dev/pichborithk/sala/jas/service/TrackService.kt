package dev.pichborithk.sala.jas.service

import dev.pichborithk.sala.jas.model.Track
import dev.pichborithk.sala.jas.repository.AlbumRepository
import dev.pichborithk.sala.jas.repository.ArtistRepository
import dev.pichborithk.sala.jas.repository.ProductionRepository
import dev.pichborithk.sala.jas.repository.TrackRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TrackService(
  private final val productionRepository: ProductionRepository,
  private final val trackRepository: TrackRepository,
  private final val albumRepository: AlbumRepository,
  private final val artistRepository: ArtistRepository,
) {

  fun getTrackById(id: String): Track? {
    return trackRepository.findByIdOrNull(id)
  }

  fun updateTrackArtist(trackId: String, artistId: String): Track? {
    val track = trackRepository.findByIdOrNull(trackId)
    val artist = artistRepository.findByIdOrNull(artistId)
    if (track == null || artist == null) {
      return null
    }

    track.artists.takeIf {
      artist !in it
    }?.add(artist)

    track.album?.artists.takeIf {
      it?.contains(artist) != true
    }?.add(artist)

    track.production?.artists.takeIf {
      it?.contains(artist) != true
    }?.add(artist)

    return trackRepository.save(track)
  }
}