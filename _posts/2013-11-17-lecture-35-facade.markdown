---
layout: post
title:  "Facade"
---

# intent
provide a unified interface to a set of interfaces in a substeme,
Facade defines a higher level that makes the subsystems easier to user


# Initial Comments

* often used to promote layering
* does not precule one from using elemnts of the substem directly,
should one so desire.

------

# Additional Comments

One uses the subsystem's services through either:

* the Facade, or
* via subsystem elements

It is an abomination to mix the two.

The facade's `easyToUseOp()` may instantiate multiple substem objects,
compose them, and invoke a variety of operations on them, before returning
a result.

The operations that the Facade defines should be (relatively) complete; it
may be the case (though unusual) to effect the desired results.

# Analogy: g++
There are multiple phases:

* preprocessor: ` g++ -E in.cpp > preprocessed_in.cpp `

# Facade in Java
Java has _packages_

* classes declared public may be used outside the package
* those that aren't, can't
* thus when we define a Facade for a package, it must be declared `public`
* subsystems may have other public classes.

A package may be use to:

* encapsulate set of classes meant to work together
  * e.g. the parts of a compiler
* ecapsulate a set of (uncoupled) classes with similar functionailty
  * eg Java Collections package defines a bunch of independent contain classes
* facade would be used with the first kind.