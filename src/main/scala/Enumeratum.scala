/*
* 12.11.2015
*
* Do you know Enumeratum?
*
* Continuation on the '15 season's starting on "Scala annoyances". How the Enumeratum
* library makes enums actually useful in Scala.
*/

object EnumeratumMeetup {

  // What *is* an Enumeration?
  //
  //  - something enumerable (1,2,...n); not infinite; ordered
  //  - but not a number
  //  - one would like to be able to:
  //    - use it in a type safe manner (i.e. C++ leaks enums with ints)
  //    - list all the elements of the type (well, that's "enumerating" so...)
  //    - use enum names for e.g. logging
  //  - stable at compile time (i.e. not a dynamic collection)
  //  - make the set 'final', i.e. warn if a pattern match forgot some cases
  //
  // Samples:
  //
  //  - countries
  //  - time zones
  //  - colors (to a degree)
  //  - week days
  //  - months
  //  - ...
  //

  //---
  // Scala offers:
  //
  def builtIn() {
    object Colour extends Enumeration {
      val Red, Green, Amber= Value
    }

    println( Colour.Amber )      // Amber

    println( Colour.ValueSet.toString )   // ...

    println( Colour.Green match {
      case Colour.Red => "hot"
      case Colour.Amber => "hottish"
      // do we get a 'missing case' warning?   NO!!!! (runtime time error only)
      case Colour.Green => "??"
    })
  }


  //---
  // Case objects:
  //
  def caseObjects() {
    sealed trait Colour   // note: abstract class is lighter for compiler than traits
    case object Red extends Colour
    case object Amber extends Colour
    case object Green extends Colour

    println( Amber )      // Amber

    val colours = Seq(Red,Amber,Green)   // need to maintain this manually
    println( colours )

    //val col = Colour(2)    // no mapping from int <-> Colour; not even iterable
    val col: Colour = Green
    println( col match {
      case Red => "hot"
      case Amber => "hottish"
      // do we get a 'missing case' warning?    // Yes: we got a warning. (but use -...flagtobeplacedhere... maybe -Xlint)
      case Green => "??"
    })
  }

  // Problems:
  //  - not iterable; not actually enumerable
  //  - set of valid values not easily available (leads to manual updating)
  //
  // Benefits:
  //  - typesafe
  //  - reports missing cases in pattern matching
  //  - values *can* be anything, i.e. planets (with mass, rotational time, ...)
  //
  // Note:
  //  - problem of creating objects can be bypassed by deriving from 'AnyVal'
  //  - there is something like:
  //      import EnumerationMacros._
  //      val cols: Set[Colour] = sealedInstancesOf[Colour]


  //---
  // Enumeratum:
  //
  // https://github.com/lloydmeta/enumeratum
  //
  def withEnumeratum() {
    import enumeratum._

    sealed trait Colour extends EnumEntry

    object Colour extends Enum[Colour] {
      val values = findValues

      case object Red extends Colour
      case object Amber extends Colour
      case object Green extends Colour
    }

    println( Colour.Amber )       // Amber

    println( Colour.values )      // Vector(Red, Amber, Green)

    val col = Colour.values(2)
    println( col match {
      case Colour.Red => "hot"
      case Colour.Amber => "hottish"
      // do we get a 'missing case' warning?    Yes, warning (see above)
      case Colour.Green => "??"
    })
  }

  // Problems:
  //  - allocated as objects (not AnyVal)
  //  - separate library
  //
  // Benefits:
  //  - overall good
  //
  // Note:
  //  - implemented using macros -> https://github.com/lloydmeta/enumeratum/blob/master/macros/src/main/scala/enumeratum/EnumMacros.scala

  // Blog used in preparing the meetup:
  //  http://underscore.io/blog/posts/2014/09/03/enumerations.html


  /**
   * Java Enums.
   *
   * There is a mere one-liner in `/src/main/java/Colour.java`:
   * {{{
   *   enum Colour { Red, Amber, Green }
   * }}}
   *
   * Problems:
   *   - Java code in a separate file
   *
   * Benefits:
   *   - Fast, look-ups from string are O(m) where m in the length of the string
   *   - Elegant
   *   - Fully supported in match-case
   *   - No need to manually maintain values()
   *   - Supports "ordinal()", even though using that is generally discouraged
   *
   * Note:
   *   - Java enum is the best implementation of enumeration that I've encountered in any language (-HSa)
   */
  def withJavaEnums(): Unit = {

    println (Colour.Amber)         // Amber
    println (Colour.values.toSeq)  // .values returns Array(Red, Amber, Green), using .toSeq for printing purposes

    val col = Colour.values()(2)
    println (col match {
      case Colour.Red   => "hot"
      case Colour.Amber => "hottish"
      // Do we get a 'match may not be exhaustive' warning if the following line is removed?  Yes!
      case Colour.Green => "??"
    })
  }
}
