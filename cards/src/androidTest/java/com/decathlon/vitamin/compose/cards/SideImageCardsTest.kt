package com.decathlon.vitamin.compose.cards

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.junit4.createComposeRule
import com.decathlon.vitamin.compose.cards.FullImageCardsTest.Companion.CustomContentSample
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class SideImageCardsTest : ScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun card_sideImagewith_title_and_Long_text() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.SideImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    imageContentDescription = "Loading image in progress",
                    content = {
                        TitleAndText(
                            title = "Card Side",
                            text = "A container for content representing a single entity. e.g. a contact, article, or task." +
                                "A container for content representing a single entity. e.g. a contact, article, or task." +
                                "A container for content representing a single entity. e.g. a contact, article, or task." +
                                "A container for content representing a single entity. e.g. a contact, article, or task.",
                        )
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_sideImagewith_title_and_normal_text() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.SideImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    imageContentDescription = "Loading image in progress",
                    content = {
                        TitleAndText(
                            title = "Card Side",
                            text = "A container for content representing a single entity. e.g. a contact, article, or task.",
                        )
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_sideImage_with_title_and_text_and_actions() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.SideImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    imageContentDescription = "Loading image in progress",
                    content = {
                        TitleAndText(
                            title = "Card Side",
                            text = "A container for content representing a single entity. e.g. a contact, article, or task.",
                        )
                    },
                    actionContent = {
                        Icons(
                            actions = listOf(
                                CardActionItem(
                                    painter = painterResource(id = R.drawable.ic_vtmn_add_line),
                                    contentDescription = "add"
                                ) {},
                                CardActionItem(
                                    painter = painterResource(id = R.drawable.ic_vtmn_close_line),
                                    contentDescription = "close"
                                ) {}
                            )
                        )
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_sideImage_with_custom_content() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.SideImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    imageContentDescription = "Loading image in progress",
                    content = {
                        CustomContentSample("Side Card - Custom")
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }

    @Test
    fun card_sideImage_with_custom_content_and_actions() {
        composeTestRule.setContent {
            VitaminTheme {
                VitaminCards.SideImage(
                    painter = painterResource(id = R.drawable.card_placeholder),
                    imageContentDescription = "Loading image in progress",
                    content = {
                        CustomContentSample("Side Card - Custom")
                    },
                    actionContent = {
                        Icons(
                            actions = listOf(
                                CardActionItem(
                                    painter = painterResource(id = R.drawable.ic_vtmn_add_line),
                                    contentDescription = "add"
                                ) {},
                                CardActionItem(
                                    painter = painterResource(id = R.drawable.ic_vtmn_close_line),
                                    contentDescription = "close"
                                ) {}
                            )
                        )
                    }
                )
            }
        }
        compareScreenshot(composeTestRule)
    }
}
