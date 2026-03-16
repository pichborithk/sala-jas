package dev.pichborithk.sala.jas.resolver

import dev.pichborithk.sala.jas.model.Production
import dev.pichborithk.sala.jas.service.ProductionService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ProductionResolver(
  private final val productionService: ProductionService
) {

  // Query: all productions
  @QueryMapping
  fun getProductions(): MutableList<Production> {
    return productionService.getProductions()
  }

  // Query: production by ID
  @QueryMapping
  fun getProductionById(@Argument id: String): Production? {
//    val production = productionService.getProductionById(id)
//    production?.let {
//      return ProductionResponse(
//        "Success",
//        200,
//        "Found production with id: $id",
//        production
//      )
//    }
//    return ProductionResponse(
//      "Fail",
//      404,
//      "Not Found production with id: $id"
//    )
    return productionService.getProductionById(id)
  }

  @MutationMapping
  fun createProduction(@Argument name: String): Production {
    return productionService.createProduction(name)
  }

  @MutationMapping
  fun deleteProductionById(@Argument id: String): Production? {
    return productionService.deleteProductionById(id)
  }
}