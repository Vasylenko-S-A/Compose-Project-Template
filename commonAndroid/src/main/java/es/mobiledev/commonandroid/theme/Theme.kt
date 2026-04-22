package es.mobiledev.commonandroid.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import es.mobiledev.commonandroid.R
import es.mobiledev.commonandroid.util.fontDimensionResource

@Composable
fun CPTTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> darkColorScheme()
            else -> lightColorScheme()
        }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}

// region Base text style by size
@Composable
private fun displayLargeRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_56),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun displayMediumRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_45),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun displaySmallRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_36),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun headlineLargeRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_32),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun headlineMediumRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_28),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun headlineSmallRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_24),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun titleLargeRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_22),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun titleMediumRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_16),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun titleSmallRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_14),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun bodyLargeRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_16),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun bodyMediumRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_14),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun bodySmallRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_12),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun labelLargeRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_14),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun labelMediumRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_12),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

@Composable
private fun labelSmallRoboto(
    fontWeight: FontWeight,
    lineHeight: TextUnit = fontDimensionResource(R.dimen.line_height_font_sp_1_2),
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = fontDimensionResource(R.dimen.font_sp_11),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = cptThemeTextRoboto(
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    fontStyle = fontStyle,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

// endregion

// region Base text style
@Composable
private fun cptThemeTextRoboto(
    fontSize: TextUnit,
    fontWeight: FontWeight? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    fontFamily: FontFamily = robotoFontFamily(),
    fontStyle: FontStyle = FontStyle.Normal,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
) = TextStyle(
    fontSize = fontSize,
    fontFamily = fontFamily,
    fontWeight = fontWeight,
    fontStyle = fontStyle,
    lineHeight = lineHeight,
    color = color,
    textAlign = textAlign,
    letterSpacing = letterSpacing,
    textDecoration = textDecoration,
)

// endregion

@Composable
private fun robotoFontFamily() =
    FontFamily(
        Font(R.font.roboto_regular, weight = FontWeight.W400),
        Font(R.font.roboto_semibold, weight = FontWeight.W600),
        Font(R.font.roboto_bold, weight = FontWeight.W700),
        Font(R.font.roboto_extrabold, weight = FontWeight.W800),
    )
