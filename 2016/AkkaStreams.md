
# AkkaStreams 

4.2.2016, William K, Annankatu

We took a dive to Streams Programming and went through some Akka Streams samples. Here's a brief memo of sorts.

## What are streams?

- Streams are kind of the inverse of collections - push vs. pull.

- They allow construction of data flows, without needing to worry about buffering, out of memory errors, etc.

- They make code easier to comprehend and maintain, e.g. no callbacks, unified error handling for the whole stream.

## Akka Streams

Has `Source`, `Flow`, `Graph` and `Sink`.

The idea is that these can be constructed by separate people/teams, and integrated together like plumbing.

It's type safe (unlike plain Actors).

## Samples

We went through the [BasicTransformation](https://github.com/typesafehub/activator-akka-stream-scala/blob/master/src/main/scala/sample/stream/BasicTransformation.scala) and [WritePrimes](https://github.com/typesafehub/activator-akka-stream-scala/blob/master/src/main/scala/sample/stream/WritePrimes.scala) code samples, and played with them, a bit.

Learned that splitting a stream needs an explicit `Broadcast` element, and that that element runs by the slowest of its downstream consumers (due to backpressure).

We tried the `onFailure` passing, by making a stage in the stream crash and saw how the `onFailure` at the end caught that error.

We learned to use the IntelliJ IDEA presentation mode!

## Akka Streams vs. Reactive Extensions

| | Akka Streams | Reactive Extensions (e.g. RxScala) |
|
| splitting | explicit, using `Broadcast` | implicit, 0..n observers for any stream |
| backpressure | built in, non-optional | none, yet? (RxJS) |
| materializing | explicit, via `toMat`, `run` etc. | using Schedulers (but normally default is just fine) |

## Loose ends

We did not go to:

- how is actor *supervision* handled, i.e. what if we want a Flow to be retried if it fails - can we do that (like in Actor systems)?
- how is parallelism controlled (Akka Streams async boundaries)

Thanks, everyone!

![](images/IMG_0700.JPG)

## Links

- [Akka Streams Samples](https://github.com/typesafehub/activator-akka-stream-scala#master) (GitHub)
- [Reactive Extensions](http://reactivex.io)
- [Monify, RxScala and Akka Streams comparison](https://bionicspirit.com/blog/2015/09/06/monifu-vs-akka-streams.html)

