/*
* Main
*
* Usage:
*   sbt run
*/

object Main extends App {
  import EnumeratumMeetup._

  builtIn()
  caseObjects()
  withEnumeratum()

  println( "That's it, folks!" )
}
