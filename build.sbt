name := """ren-utils"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "be.objectify"              %% "deadbolt-java"       % "2.4.3",
  "org.mindrot"               %  "jbcrypt"             % "0.3m",
  "net.sourceforge.jtds"      %  "jtds"                % "1.3.1",
  "org.mongodb"               %  "mongo-java-driver"   % "3.0.4",
  "org.apache.poi"            %  "poi"                 % "3.12",
  "org.apache.poi"            %  "poi-ooxml"           % "3.12",
  "org.webjars"               %  "bootstrap"           % "3.3.5",
  "org.webjars"               %  "select2"             % "4.0.0-2",
  "org.easytesting"           %  "fest-assert"         % "1.4"              % "test"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.

// routesGenerator := InjectedRoutesGenerator

// add resolver for deadbolt and easymail snapshots
resolvers ++= Seq( 
  Resolver.sonatypeRepo("snapshots")
)

//javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.

lazy val root = (project in file(".")).enablePlugins(PlayJava)

//  Uncomment the next line for local development of the Play Authenticate core:
//lazy val playAuthenticate = project.in(file("modules/play-authenticate")).enablePlugins(PlayJava)

EclipseKeys.preTasks := Seq(compile in Compile)