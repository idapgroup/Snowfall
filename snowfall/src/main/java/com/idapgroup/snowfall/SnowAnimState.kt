package com.idapgroup.snowfall

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.IntSize
import com.idapgroup.snowfall.Constants.angleRange
import com.idapgroup.snowfall.Constants.angleSeed
import com.idapgroup.snowfall.Constants.incrementRange
import com.idapgroup.snowfall.Constants.sizeRange
import com.idapgroup.snowfall.Constants.snowflakeDensity
import com.idapgroup.snowfall.types.AnimType
import kotlin.math.PI
import kotlin.math.roundToInt

internal data class SnowAnimState(
    var tickNanos: Long,
    val snowflakes: List<Snowflake>,
    val painters: List<Painter>,
    val animType: AnimType,
) {
    constructor(
        tick: Long,
        canvasSize: IntSize,
        painters: List<Painter>,
        animType: AnimType,
    ) : this(tick, createSnowFlakes(painters, canvasSize, animType), painters, animType)

    fun draw(contentDrawScope: ContentDrawScope) {
        snowflakes.forEach {
            it.draw(contentDrawScope)
        }
    }

    fun resize(newSize: IntSize) = copy(snowflakes = createSnowFlakes(painters, newSize, animType))

    companion object {

        fun createSnowFlakes(
            flakesProvider: List<Painter>,
            canvasSize: IntSize,
            animType: AnimType,
        ): List<Snowflake> =
            when (animType) {
                AnimType.Falling -> createFallingSnowflakes(canvasSize, flakesProvider)
                AnimType.Melting -> createMeltingSnowflakes(canvasSize, flakesProvider)
            }

        private fun createMeltingSnowflakes(
            canvasSize: IntSize,
            painters: List<Painter>,
        ): List<MeltingSnowflake> {

            if (canvasSize.height == 0 || canvasSize.width == 0) {
                return emptyList()
            }

            return List(painters.size) {
                MeltingSnowflake(
                    incrementFactor = incrementRange.random(),
                    canvasSize = canvasSize,
                    maxAlpha = (0.1f..0.7f).random(),
                    painter = painters[it],
                    position = canvasSize.randomPosition()
                )
            }
        }

        private fun createFallingSnowflakes(
            canvasSize: IntSize,
            painters: List<Painter>
        ): List<FallingSnowflake> {
            val canvasArea = canvasSize.width * canvasSize.height
            val normalizedDensity = snowflakeDensity.coerceIn(0.0..1.0) / 1000.0
            val snowflakesCount = (canvasArea * normalizedDensity).roundToInt()

            return List(snowflakesCount) {
                FallingSnowflake(
                    incrementFactor = incrementRange.random(),
                    size = sizeRange.random(),
                    canvasSize = canvasSize,
                    position = canvasSize.randomPosition(),
                    angle = angleSeed.random() / angleSeed * angleRange + (PI / 2.0) - (angleRange / 2.0),
                    painter = painters[it % painters.size],
                )
            }
        }
    }
}