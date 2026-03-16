package dev.pichborithk.sala.jas.resolver

import dev.pichborithk.sala.jas.dto.ProductionResponse
import dev.pichborithk.sala.jas.dto.ProductionsResponse
import dev.pichborithk.sala.jas.service.ProductionService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ProductionResolver(private final val productionService: ProductionService) {

  // Query: all productions
  @QueryMapping
  fun getProductions(): ProductionsResponse {
    val productions = productionService.getProductions()
    return ProductionsResponse(
      "Success",
      200,
      "Found ${productions.size} productions in the database",
      productions
    )
  }

  // Query: production by ID
  @QueryMapping
  fun getProductionById(@Argument id: String): ProductionResponse {
    val production = productionService.getProductionById(id)
    production?.let {
      return ProductionResponse(
        "Success",
        200,
        "Found production with id: $id",
        production
      )
    }
    return ProductionResponse(
      "Fail",
      404,
      "Not Found production with id: $id"
    )
  }

  @MutationMapping
  fun createProduction(@Argument name: String): ProductionResponse {
    val production = productionService.createProduction(name)
    return ProductionResponse(
      "Success",
      200,
      "Successful create new production with id: ${production.id}",
      production
    )
  }

  @MutationMapping
  fun deleteProductionById(@Argument id: String): ProductionResponse {
    val production = productionService.deleteProductionById(id)
    production?.let {
      return ProductionResponse(
        "Success",
        200,
        "Successful delete production with id: $id",
        production
      )
    }
    return ProductionResponse(
      "Fail",
      404,
      "Fail to delete production with id: $id"
    )
  }
}