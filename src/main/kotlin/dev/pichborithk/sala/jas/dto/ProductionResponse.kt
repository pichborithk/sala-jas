package dev.pichborithk.sala.jas.dto

import dev.pichborithk.sala.jas.model.Production

data class ProductionResponse(
  val status: String,
  val code: Int,
  val message: String,
  val production: Production? = null
)