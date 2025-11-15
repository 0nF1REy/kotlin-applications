-keep class dev.alanryan.pokedex.models.** { *; }

-keepclassmembers class * {
    @kotlinx.serialization.Serializable <fields>;
}

-keep class androidx.compose.runtime.** { *; }
-keep class androidx.compose.ui.** { *; }
-keep class androidx.compose.foundation.** { *; }
-keep class androidx.compose.material3.** { *; }

-keepclassmembers class * {
    @androidx.annotation.Keep <fields>;
    @androidx.annotation.Keep <methods>;
}

-keepclassmembers enum * { *; }

-keepclassmembers class dev.alanryan.pokedex.data.** { public static <fields>; }
