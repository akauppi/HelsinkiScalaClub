/*
* TestRun
*
* Usage:
*   sbt run
*/

object Main extends App {

  case class Point(x: Double, y: Double)

  val p = new Point(10,30)

  System.out.println( s"Your point is: $p" )
}

