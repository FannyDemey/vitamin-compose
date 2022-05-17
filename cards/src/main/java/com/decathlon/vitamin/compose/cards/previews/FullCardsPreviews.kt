package com.decathlon.vitamin.compose.cards.previews

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.decathlon.vitamin.compose.cards.R
import com.decathlon.vitamin.compose.cards.VitaminCards
import com.decathlon.vitamin.compose.foundation.VitaminTheme

@Preview
@Composable
fun PreviewFullCardImageClickable() {
    VitaminTheme {
        VitaminCards.FullImage(
            painter = rememberAsyncImagePainter(
                "https://picsum.photos/300/200",
                placeholder =
                painterResource(id = R.drawable.vtmn_payment_mastercard_id_check)
            ),
            contentDescription = "We should set here a description " +
                "of the content if not decorative, otherwise null",
            content = {
                TitleTextAndButton(
                    title = "Card Title - Clickable card",
                    text = "A container for content representing a single entity. " +
                        "e.g. a contact, article, or task.",
                    buttonText = "Button",
                    onButtonClick = {}
                )
            },
            modifier = Modifier.clickable {}
        )
    }
}

@Preview
@Composable
fun PreviewFullCardImageTitleTextAndButton() {
    VitaminTheme {
        VitaminCards.FullImage(
            painter = rememberAsyncImagePainter(
                "https://picsum.photos/300/200",
                placeholder =
                painterResource(id = R.drawable.vtmn_payment_mastercard_id_check)
            ),
            contentDescription = "We should set here a description " +
                "of the content if not decorative, otherwise null",
            content = {
                TitleTextAndButton(
                    title = "Card Title - Clickable card",
                    text = "A container for content representing a single entity. " +
                        "e.g. a contact, article, or task.",
                    buttonText = "Button",
                    onButtonClick = {}
                )
            }
        )
    }
}
