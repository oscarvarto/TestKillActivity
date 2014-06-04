import android.Keys._

name := "TestingWithScaloid"

organization := "com.optrak"

version := "0.2"

scalaVersion := "2.11.1"

scalacOptions ++= Seq(
 "-unchecked",
 "-deprecation",
 "-Xlint",
 "-language:_",
 "-encoding", "UTF-8"
 //, "-Xprint:typer"
)

incOptions := incOptions.value.withNameHashing(true)

android.Plugin.androidBuild

platformTarget in Android := "android-19"

targetSdkVersion in Android := 19

minSdkVersion in Android := 14

run <<= run in Android

install <<= install in Android

// debugIncludesTestsInAndroid := true

apkbuildExcludes in Android ++= Seq(
  "reference.conf",
  "META-INF/LICENSE.txt",
  "META-INF/mime.types",
  "LICENSE.txt"
)

dexMaxHeap in Android := "8192m"

useProguard in Android := true

proguardOptions in Android ++= Seq(
  "-dontobfuscate",
  "-dontoptimize",
  "-ignorewarnings",
  "-keep public class * extends junit.framework.TestCase",
  "-keepclassmembers class * extends junit.framework.TestCase { *; }"
)

proguardCache in Android ++= Seq(
  ProguardCache("scalaz") % "org.scalaz" % "scalaz-core_2.11",
  ProguardCache("org.scaloid") % "org.scaloid" % "scaloid_2.11",
  ProguardCache("org.specs2") % "org.specs2" % "specs2_2.11",
  ProguardCache("com.robotium.solo") % "com.jayway.android.robotium" % "robotium-solo"
)

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.6",
  "org.scaloid" %% "scaloid" % "3.4-10",
  //"com.android.support" % "support-v4" % "19.0.1",
  //aar("com.android.support" % "appcompat-v7" % "19.0.1"),
  //"org.scalatest" % "scalatest_2.10" % "2.1.0",
  "org.specs2" %% "specs2" % "2.3.12",
  "com.jayway.android.robotium" % "robotium-solo" % "5.1"
)

externalDependencyClasspath in Test ~= {
  cp => cp filterNot (_.data.getName contains "mockito-core-1.9.5.jar")
}
