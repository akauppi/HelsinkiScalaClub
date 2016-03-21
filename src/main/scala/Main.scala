/*
* Main
*
* Usage:
*   sbt run
*/
object Main extends App {
  import EnumeratumMeetup._

  val functions = Seq(
    () => builtIn(),
    () => caseObjects(),
    () => withEnumeratum(),
    () => withJavaEnums()
  )

  functions.foreach { f => f(); println() }

  println("That's it, folks!")
}
