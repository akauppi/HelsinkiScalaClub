/*
* From http://eng.localytics.com/akka-streams-akka-without-the-actors/
*   and https://github.com/localytics/akka-streams-blogpost-code
*
*   Updated to Akka Streams 2.0.2: https://github.com/akauppi/akka-streams-blogpost-code/tree/akka-streams-2.0.2
*/
import akka.actor.ActorSystem
import akka.stream.{FlowShape, ActorMaterializer}
import akka.stream.scaladsl._
import scala.concurrent.ExecutionContext.Implicits.global

object StreamProgram1 {

  def run(): Unit = {
    implicit lazy val system = ActorSystem("example")
    implicit val materializer = ActorMaterializer()
    Source(List("Hello World"))
      .map((s: String) => s + "!")
      .runWith(Sink.foreach(println))
      .onComplete {
        case _ => system.shutdown()
      }
  }
}

//---
object StreamProgram2 {

  val sayFlow: Flow[String, String, Unit] =
    Flow[String].map { s =>
      s + "."
    }

  val shoutFlow: Flow[String, String, Unit] =
    Flow[String].map { s =>
      s + "!!!!"
    }

  // Note: This bit needs Akka Streams 1.0 (not 2.0.2). AKa310116
  //
  val sayAndShoutFlow: Flow[String, String, Unit] =
    Flow.fromGraph(
      GraphDSL.create() { implicit b =>
        import GraphDSL.Implicits._

        val broadcast = b.add(Broadcast[String](2))
        val merge = b.add(Merge[String](2))

        broadcast ~> sayFlow ~> merge
        broadcast ~> shoutFlow ~> merge
        FlowShape(broadcast.in, merge.out)
      }
    )

  def run(): Unit = {
    implicit lazy val system = ActorSystem("example")
    implicit val materializer = ActorMaterializer()
    Source(List("Hello World"))
      .via(sayAndShoutFlow)
      .runWith(Sink.foreach(println))
      .onComplete {
        case _ => system.shutdown()
      }
  }
}