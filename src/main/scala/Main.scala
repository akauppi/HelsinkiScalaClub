/*
* Main
*
* Usage:
*   sbt run
*/
object Main extends App {
  import EnumeratumMeetup._

  val functions = Seq(
    builtIn _,
    caseObjects _,
    withEnumeratum _,
    withJavaEnums _
  )

  functions.foreach { f => f(); println() }

  println("That's it, folks!")
}
