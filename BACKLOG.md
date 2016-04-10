# Backlog of ideas

A list of themes we could cover in upcoming meetups.

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

Suggested by: AKa 100416

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
