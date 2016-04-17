# Backlog of ideas

A list of themes we could cover in upcoming meetups.


## Use of type system

- self types
- implicit type constraints (`ClassTag`, `TypeTag`) vs. type constraints in the type parameter
- benefits of typing e.g. via case class over generic types such as `String`

One of Scala's strengths is its type system. This meetup would focus on how to harness that strength to be on the programmer's side.

Suggested by: AKa 070416

## sbt (two meetups or groups)

Recent changes in `sbt` have made it be more simple than it used to be. Eg. the split to separate `.scala` and `.sbt` files is largely gone. 

This can make learning `sbt` rather bizarre, since much of information online might refer to outdated practises. Let's check out the current state, and current use patterns of `sbt`.

- doing subproject builds
- description of the three "scope axis" of sbt and how they matter in practise: projects, configurations and tasks
- sample of creating a generic build step in `sbt` (one does not need Gradle of Make for that)
- `sbt` with Spark
- `sbt` dependency and "shading"

We might split this in two parts: `sbt` basics, and then `sbt` advanced, on different evening, or alternatively in the same evening, in two parallel groups.

Suggested: multiple, 070416

## scala.js

Scala is available not only on the JVM platform, but on JavaScript as well. One can create browser front-end (and node.js?) modules with Scala. Also debugging works all the way to Scala sources, seamlessly.

Does someone really use this for practical work? If so, it would be interesting to hear a presentation on how it's been. What have been the practical pros/cons, and have the restrictions (no JVM means some libraries won't work) been noticed?

Pros:

- it's interesting

Cons:

- it just works, so a bare basic presentation might be a bit dull?


Suggested: Dylan Drummond et.al. 070416

## Dependency injection

This is kind of a "necessary evil" in many projects.

How to run a system (web service) against some live external server in production, but against a narrowly implemented mock-up in testing.

There's web pages that say Scala doesn't need a DI framework - that things can be done using language features alone. There's the "cake pattern" (too much cream for many). There are various DI frameworks, and support for them e.g. in the Play framework itself.

It's a jungle when one just needs A Simple Way to get the thing done.

Pros and cons for covering this in the meetup:

Pros:

- a real-world issue

Cons:

- relevant only when building a bit larger setups (eg. not necessary for Scala beginners)

More:
Within the 070416 meetup, two links were mentioned that pretty much sum this up, by themselves (they are gorgeous - thanks to whoever brought them up!!)

- [Dependency Injection in Play Framework using Scala](http://www.schibsted.pl/2016/04/dependency-injection-play-framework-scala/) (blog, Apr 2016)
- [Scrap Your Cake Pattern Boilerplate: Dependency Injection Using the Reader Monad](http://blog.originate.com/blog/2013/10/21/reader-monad-for-dependency-injection/) (blog, Oct 2013)

The problem really boils down to two cases: Play and the rest of Scala. I feel after reading the above blogs, there's nothing really to add and this would not make a great event topic, though it is practical.

The best technique seems to be very dependent on the particular end project. That probably also explains, why there are so many different candidate technologies.

Suggested by: AKa 100416 (hesitating 170416)

