lazy val shoppingCart = (project in file(".")).settings(
  Seq(
    name := "ShoppingCart",
    version := "1.0",
    scalaVersion := "2.12.3",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test",
    libraryDependencies += "org.mockito" % "mockito-core" % "1.10.19" % "test"

  )
)
