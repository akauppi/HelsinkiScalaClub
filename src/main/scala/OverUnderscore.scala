/*
* 10.9.2015
*
* Overuse of underscore in Scala.
*
* There are N uses of the poor '_' in Scala.
*
* Some of these are not really necessary.
*
* Ref. http://www.slideshare.net/normation/scala-dreaded
*/
class Underscores {
  import collection.{ Map =>_, _ }

  var count : Int = _

  def sum = (_:Int) + (_:Int)
  def sum2(a:Int)(b:Int) = a+b

  def offset = sum2(count) _

  def sizeOf(l:Traversable[_]) : Unit = l match {
    case it: Seq[Int @unchecked] => count = (0/:it)(_ + _)
    case s: Iterable[_] => s.foreach( _ => count + count+1 )
    case _ => println(offset(l.size))
  }
}

object OverUnderscore extends App {

  // Shortcut for one parameter functions
  //
  val abc = List("a","b","c")
  println( abc.map(_.toUpperCase) )

  println( abc.map( x => x.toUpperCase) )

  println( abc.map( (x) => x.toUpperCase) )

  println( abc.map( (x:String) => x.toUpperCase) )

  // Accessing tuple internals
  //
  val ts = List( ("a",0), ("b",1), ("c",2) )
  //println( ts.map(_._1 + _._2) )    // does not compile ('_' cannot be referred twice)

  println( ts.map( x => x._1 + x._2) )    // compiles

  println( ts.map{ case (c,n) => c+n } )

  println( ts.map( Function.tupled( (c,n) => c+n ) ))

  //...
}
