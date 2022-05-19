package com.decathlon.vitamin.compose.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.buttons.VitaminButtons
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnLightColorPalette

object VitaminCards {
    @Composable
    fun TopImage(
        painter: Painter,
        contentDescription: String?,
        content: @Composable (TopImageContent.() -> Unit),
        modifier: Modifier = Modifier,
        shape: Shape = RoundedCornerShape(4.dp),
        imageScale: VitaminCardImageScale = VitaminCardImageScale.Fit,
        imageOverlayAlignment: Alignment = Alignment.TopStart,
        imageOverlay: (@Composable () -> Unit)? = null,
    ) = Card(modifier = modifier, shape = shape) {
        Column {
            CardImage(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.padding(if (imageScale == VitaminCardImageScale.Fit) 16.dp else 0.dp),
                overlay = imageOverlay,
                imageOverlayAlignment = imageOverlayAlignment
            )
            Box(
                modifier = Modifier.padding(16.dp),
            ) {
                TopImageContent.content()
            }
        }
    }

    @Composable
    fun FullImage(
        painter: Painter,
        contentDescription: String?,
        content: @Composable (FullImageContent.() -> Unit),
        modifier: Modifier = Modifier,
        shape: Shape = RoundedCornerShape(4.dp),
        imageWithGradient: Boolean = false,
    ) = Card(modifier = modifier, shape = shape) {
        Box {
            CardImage(
                painter = painter,
                contentDescription = contentDescription,
                withGradient = imageWithGradient
            )
            Box(modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)) {
                FullImageContent.content()
            }
        }
    }

    @Composable
    fun SideImage(
        painter: Painter,
        imageContentDescription: String?,
        content: (@Composable SideImageContent.() -> Unit),
        modifier: Modifier = Modifier,
        actionContent: @Composable (SideImageActionContent.() -> Unit)? = null,
        shape: Shape = RoundedCornerShape(4.dp),
    ) = Card(modifier = modifier, shape = shape) {
        Column {
            if (actionContent != null) {
                SideImageActionContent.actionContent()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(
                        top = if (actionContent != null) {
                            0.dp
                        } else {
                            16.dp
                        },
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                CardImage(
                    painter = painter,
                    contentDescription = imageContentDescription,
                    isSideImage = true,
                    modifier = Modifier.weight(weight = 1f).aspectRatio(ratio = 1f)
                )
                Box(Modifier.weight(weight = 3f)) {
                    SideImageContent.content()
                }
            }
        }
    }

    @Composable
    fun WithoutImage(
        content: (@Composable WithoutImageContent.() -> Unit),
        modifier: Modifier = Modifier,
        shape: Shape = RoundedCornerShape(4.dp),
    ) = Card(modifier = modifier, shape = shape) {
        Box(modifier = Modifier.padding(16.dp)) {
            WithoutImageContent.content()
        }
    }
}

@Composable
internal fun CardImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    overlay: @Composable (() -> Unit)? = null,
    imageOverlayAlignment: Alignment = Alignment.TopStart,
    withGradient: Boolean = false,
    isSideImage: Boolean = false,
) {
    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.FillWidth,
            modifier = when {
                withGradient -> {
                    Modifier
                        .fillMaxWidth().withGradient(vtmnLightColorPalette.vtmnBackgroundPrimaryReversed)
                }
                isSideImage -> {
                    Modifier.fillMaxSize()
                }
                else -> {
                    Modifier.fillMaxWidth()
                }
            }
        )
        overlay?.let {
            Box(
                Modifier
                    .padding(8.dp)
                    .align(imageOverlayAlignment)
            ) {
                overlay()
            }
        }
    }
}

@Composable
internal fun CardDescription(
    color: Color,
    title: String,
    text: String,
    modifier: Modifier = Modifier,
    buttonText: String? = null,
    onButtonClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = title,
            style = VitaminTheme.typography.h6,
            color = color
        )
        Text(
            text = text,
            style = VitaminTheme.typography.body3,
            color = color
        )
        if (buttonText != null && onButtonClick != null) {
            VitaminButtons.CardButton(
                text = buttonText,
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                onButtonClick()
            }
        }
    }
}

enum class VitaminCardImageScale {
    Fit, Full
}

@SuppressWarnings("MagicNumber")
@Composable
fun Modifier.withGradient(color: Color) = this.drawWithCache {
    onDrawWithContent {
        drawContent()
        drawRect(
            Brush.verticalGradient(
                0.2f to color.copy(alpha = 0f),
                1f to color
            )
        )
    }
}
