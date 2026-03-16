package dev.pichborithk.sala.jas.service

import dev.pichborithk.sala.jas.model.Artist
import dev.pichborithk.sala.jas.repository.ArtistRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ArtistService(
  private val artistRepository: ArtistRepository,
) {

  fun getArtists(): MutableList<Artist> {
    return artistRepository.findAll()
  }

  fun getArtistById(id: String): Artist? {
    return artistRepository.findByIdOrNull(id)
  }

  fun createArtist(name: String): Artist? {
    artistRepository.findByName(name)?.let {
      return null
    }
    val artist = Artist(name)
    return artistRepository.save(artist)
  }
}