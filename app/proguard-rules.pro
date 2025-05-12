# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Keep all Apache POI classes (e.g., for handling Excel, Word)

#-keep class org.apache.poi.** { *; }
#
## Keep java.awt classes if required by your dependencies
#-keep class java.awt.Dimension { *; }
#-keep class java.awt.Rectangle { *; }
#
## Keep androidX classes
#-keep class androidx.** { *; }
#
## Keep Kotlin reflection classes if you're using Kotlin
#-keep class kotlin.reflect.** { *; }
#
## Keep custom classes if needed
#-keep class uz.alisoft.** { *; }