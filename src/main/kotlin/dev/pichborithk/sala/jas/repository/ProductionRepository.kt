package dev.pichborithk.sala.jas.repository

import dev.pichborithk.sala.jas.model.Production
import org.springframework.data.jpa.repository.JpaRepository

interface ProductionRepository : JpaRepository<Production, String>