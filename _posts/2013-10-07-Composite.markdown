---
layout: post
title:  "Composite"
---

# Composite (163)

# Variant: restricted composite In it's pure form, the *Composite* pattern does _not_
restrict the nesting level nor the types of COmponents that caan be chilldren of a
particular Composite; however, it may be useful to allow such restrictions

# Example

- Uml -

In this system, we are restricted:
* In terms of depth
* the type of children that a `ComputerComponent` can have.

once assembled, the way a client will act with a `ComputerComponent` is uniform. however
by necessity, the construction process will not be transparent.

# Implementing operations
A `Composite` can:
* forward a request to _all_ its childreln and aggregate (or filter) the results
* forward a request to _selected_ children and ...
* pass data to the children and ...
* override:  ignore the children and handle the request alone

# Safety v. Transparency
This will be in large part dependent upon the implementation language.

Transperancy: requires everything [`Composites` & `Leafs`] support the same interface.
   
Safety: Classes shouldn't support operations hwere, to them, are mealningless


Consider the operations:   
```java 
add( Component)
getChildren():Collection
makeIterator():Iterator
remove ( Component )
```

All of these operations are reasonable for `Composites` to support
    
which makes sense for `Leafs`?

# General OO Principle
Pushing functionality _up_ [twoards the base class] in a hiearachy is generally regarded
as a ___Very Bad Thing___

To be clear, what we are talking about here is are functionoalities that are not common to
all subtypes

The GoF book's presentation has a bias towards languages that support static type
checking. therefore favors transparency over safty becase otherwise it would be extremly
difficult (if not impossible) to implement some of the patterns (e.g., `Composite`) using
a statically typed langauge. 
  
When one is using a dynaming language you can favor _safety_.
   
Assuming a statically typed langauge:    

* how should a `Leaf` implement child management operations?  
    * Flag an error  
        * Return an error code  
        * Throw exception  
    * Ignore it
* Where should `Leaf`  management operations be implemented?
    * in each `Cleaf` <- worst choice
    * in `Component`: implement default (Leaf) behavior, which would then be overridden by
      components
    * In an _abstract_ `Leaf` Class

# Whien is transparency truly imporant?

* The _creator_ of a `Composite` will very likely have knowledge about what kinds of
  things it will be working with. If I am goin to add something to a `Componenet` chances
  are good that I created that component, chances are good that I created it (that
  `Component`), and thus know its type [hence whether or not it is a `Composite`  

* something manipulating a `Composite`'s structure ( i.e., at some future time, things
  will be added or removed) Will likely, but not certainly, know what kind of thing it is
  dealing with.

* Therefore we can conclude that transperancy is most important for things that will
  interact with the `Component`

# Implementation
  
* We've already diescussed how to mainatin the invarieant, "if you think I am your parent,
  I think you are my child."

* whem implmenting sublcasses of `Leaf` or `Composite`, we cshould avoid extending their
  interface because it can't be used polymorphically (favor transparency). 
  
* Only the `Composite` [ that is the class  that defines and maintains the strucute which
  ihodls the children ] should forward messages to the children; while it may be tempting
  to make a `CComposte` talk directly to its children, it will lead to less reusable and
  maintainble code.

* use a TM instead, similar to maintaining the invariant above


