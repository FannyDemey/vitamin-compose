package com.decathlon.vitamin.compose.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.cards.FullImageCardsTest.Companion.CustomContentSample
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.tags.VitaminTag
import com.decathlon.vitamin.compose.tags.VitaminTagColors
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class TopImageCardsTest : ScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun card_topImage_Full_with_title_and_text() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.TopImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    contentDescription = "We should set here a description " +
                        "of the content if not decorative, otherwise null",
                    imageScale = VitaminCardImageScale.Full,
                    content = {
                        TitleAndText(
                            title = "Card Top full",
                            text = "A container for content representing a single entity. " +
                                "e.g. a contact, article, or task."
                        )
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_topImage_Fit_with_title_and_text() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.TopImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    contentDescription = "We should set here a description " +
                        "of the content if not decorative, otherwise null",
                    content = {
                        TitleAndText(
                            title = "Card Top full",
                            text = "A container for content representing a single entity. " +
                                "e.g. a contact, article, or task."
                        )
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_topImage_Full_with_custom_constent() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.TopImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    contentDescription = "We should set here a description " +
                        "of the content if not decorative, otherwise null",
                    imageScale = VitaminCardImageScale.Full,
                    content = {
                        CustomContentSample("Full Image - Custom content")
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_topImage_Fit_with_custom_content() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.TopImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    contentDescription = "We should set here a description " +
                        "of the content if not decorative, otherwise null",
                    imageScale = VitaminCardImageScale.Fit,
                    content = {
                        CustomContentSample("Fit image - Custom content")
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_topImage_Fit_with_tags_top_overlay_and_title_and_text() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.TopImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    contentDescription = "We should set here a description " +
                        "of the content if not decorative, otherwise null",
                    imageScale = VitaminCardImageScale.Fit,
                    content = {
                        TitleAndText(
                            title = "Card Top full",
                            text = "A container for content representing a single entity. " +
                                "e.g. a contact, article, or task."
                        )
                    },
                    imageOverlay = {
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            VitaminTag(
                                label = "Tag",
                                color = VitaminTagColors.decorativeBrick
                            )
                            VitaminTag(label = "Tag 2", color = VitaminTagColors.alert)
                            VitaminTag(
                                label = "Tag 3",
                                color = VitaminTagColors.decorativeGravel
                            )
                        }
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_topImage_Fit_with_tags_bottom_overlay_and_title_and_text() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.TopImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    contentDescription = "We should set here a description " +
                        "of the content if not decorative, otherwise null",
                    imageScale = VitaminCardImageScale.Fit,
                    content = {
                        TitleAndText(
                            title = "Card Top full",
                            text = "A container for content representing a single entity. " +
                                "e.g. a contact, article, or task."
                        )
                    },
                    imageOverlay = {
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            VitaminTag(
                                label = "Tag",
                                color = VitaminTagColors.decorativeBrick
                            )
                            VitaminTag(label = "Tag 2", color = VitaminTagColors.alert)
                            VitaminTag(
                                label = "Tag 3",
                                color = VitaminTagColors.decorativeGravel
                            )
                        }
                    },
                    imageOverlayAlignment = Alignment.BottomEnd
                )
            }
        }
        compareScreenshot(composeTestRule)
    }
}
