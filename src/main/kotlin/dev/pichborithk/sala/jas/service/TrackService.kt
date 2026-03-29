package dev.pichborithk.sala.jas.service

import dev.pichborithk.sala.jas.model.Track
import dev.pichborithk.sala.jas.repository.ArtistRepository
import dev.pichborithk.sala.jas.repository.TrackRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class TrackService(
  private final val trackRepository: TrackRepository,
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

//    track.artists.takeIf {
//      artist !in it
//    }?.add(artist)

    track.artists.takeIf {
      artist !in it
    }?.let {
      it.add(artist)
      track.updatedAt = Instant.now().toString()
    }

//    track.album?.artists.takeIf {
//      it?.contains(artist) != true
//    }?.add(artist)

    track.album?.let { album ->
      album.artists.takeIf {
        artist !in it
      }?.let {
        it.add(artist)
        album.updatedAt = Instant.now().toString()
      }
    }

//    track.production?.artists.takeIf {
//      it?.contains(artist) != true
//    }?.add(artist)

    track.production?.let { production ->
      production.artists.takeIf {
        artist !in it
      }?.let {
        it.add(artist)
        production.updatedAt = Instant.now().toString()
      }
    }

    return trackRepository.save(track)
  }
}