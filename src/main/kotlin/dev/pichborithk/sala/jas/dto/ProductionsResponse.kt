package dev.pichborithk.sala.jas.dto

import dev.pichborithk.sala.jas.model.Production

data class ProductionsResponse(
  val status: String,
  val code: Int,
  val message: String,
  val productions: List<Production>
)