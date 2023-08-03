package com.idapgroup.snowfall.types

import androidx.compose.ui.graphics.painter.Painter

/**
 * Type of flake used for animation.
 */
public sealed interface FlakeType {
    public data object Snowflakes: FlakeType
    public class Custom(public val data: List<Painter>): FlakeType
}