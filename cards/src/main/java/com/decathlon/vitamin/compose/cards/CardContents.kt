package com.decathlon.vitamin.compose.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnLightColorPalette

object FullImageContent {
    @Composable
    fun TitleTextAndButton(
        title: String,
        text: String,
        buttonText: String,
        onButtonClick: (() -> Unit)
    ) {
        CardDescription(
            color = vtmnLightColorPalette.vtmnContentPrimaryReversed, // color always light
            title = title,
            text = text,
            buttonText = buttonText,
            onButtonClick = onButtonClick
        )
    }
}

object SideImageContent {
    @Composable
    fun TitleAndText(
        title: String,
        text: String
    ) {
        CardDescription(
            color = VitaminTheme.colors.vtmnContentPrimary,
            title = title,
            text = text
        )
    }
}

object SideImageActionContent {
    @Composable
    fun Icons(actions: List<CardActionItem>) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            actions.forEach {
                IconButton(onClick = it.onClick) {
                    Icon(
                        painter = it.painter,
                        contentDescription = it.contentDescription
                    )
                }
            }
        }
    }
}

object WithoutImageContent {
    @Composable
    fun TitleAndText(
        title: String,
        text: String
    ) {
        CardDescription(
            color = VitaminTheme.colors.vtmnContentPrimary,
            title = title,
            text = text
        )
    }
}

open class CardActionItem(
    val painter: Painter,
    val contentDescription: String?,
    val onClick: () -> Unit,
)

object TopImageContent {
    @Composable
    fun TitleAndText(
        title: String,
        text: String
    ) {
        CardDescription(
            color = VitaminTheme.colors.vtmnContentPrimary,
            title = title,
            text = text
        )
    }
}
