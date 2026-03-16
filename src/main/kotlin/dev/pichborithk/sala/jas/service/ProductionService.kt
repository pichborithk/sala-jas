package dev.pichborithk.sala.jas.service

import dev.pichborithk.sala.jas.model.Production
import dev.pichborithk.sala.jas.repository.AlbumRepository
import dev.pichborithk.sala.jas.repository.ArtistRepository
import dev.pichborithk.sala.jas.repository.ProductionRepository
import dev.pichborithk.sala.jas.repository.TrackRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductionService(
  private final val productionRepository: ProductionRepository,
  private final val trackRepository: TrackRepository,
  private final val albumRepository: AlbumRepository,
  private final val artistRepository: ArtistRepository,
) {

  fun getProductions(): MutableList<Production> {
    return productionRepository.findAll()
  }

  fun getProductionById(id: String): Production? {
    val production = productionRepository.findByIdOrNull(id)
//    production?.let {
//      production.albums = albumRepository.findByProductionId(id)
//    }
    return production
  }

  fun createProduction(name: String): Production {
    val production = Production(name)
    return productionRepository.save(production)
  }

  fun deleteProductionById(id: String): Production? {
    val production = productionRepository.findByIdOrNull(id)
    return production.takeIf {
      trackRepository.findByProductionId(id).isEmpty() &&
        albumRepository.findByProductionId(id).isEmpty() &&
        artistRepository.findByProductionsId(id).isEmpty()
    }?.also {
      productionRepository.delete(it)
    }
  }
}