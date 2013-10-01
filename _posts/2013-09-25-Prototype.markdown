---
layout: post
title:  "Prototype"
date:   2013-09-25 13:06:49
categories: prototype
---

# Administrivia
* Exam 1 next Tuesday night

# Prototype (117)

## Intent
Specifies the kinds of objects to create using a protoypical instance, and creates new
objects by copything the prototype.

## Aside: "first class object"
simple difnition: something that can be passes as an argument to a function

## Initial comments
In a language which treates __clases__ as _first class objects_ - e.g. Smalltalk & java - the
__Prototype__ pattern is competing with object construction via a __class__ object.

* Protoype: You're the kind of think I want! Clone yourself!
* Reflection: You rerpesent the class of the thin I want! Make me an instance of that class!

In the case wher all you want is a n instance of a class, it doesn't make much difference
- from the programmer's perspective - wherther we clone a protoype or instruct a
class object to instantiate the approptiate object.

So.. when would one have cause to choose ___Prototype?___
When...   

1. the deisred object's initial state is known to differ from the existing object [see _boilerplate_ ]  
2. The initial state is determined at runtime [thus not known at compile time] _or_  
3. the initialization process is expensive: copying an existing [and thus "paid for"] object is cheaper  


   

# Implementation
## How to handle cloning an object that has references/pointers?
### Deep copies v shallow copies
* A _shallow_ copy has the same attribute _values_   
* thus can share data with the original
* A _deep_ copy has the same attribute _values_ 
* thus has it's own copy of the original data

When an _attribute object_ [i.e. an object that serves as the value of another object's attrivute] 
is immutable then sharing is desriable. Mutable attributes should be shared only with caution.

{% highlight java %}
class Foo implements Cloneble {
    public Foo clone() {
        try {
            Foo fooClone = (Foo) super.clone(); //shallow
            //where appropriate replicate selected attrivutes with clones
        } catch ( CloneNotSupportedException e) {
            //this cannot happen! we support cloneable 
            throw new InternalError(e.toString())
        }

    }
}
{% endhighlight %}


_don't do this_
{% highlight java %}
class Foo implements Cloneble {
    public Foo clone() {
        Foo f = new Foo();
        f.attribute1 = this.attribute1;
        f.attribute2 = this.attribute2.clone();

        return f;

    }
}
{% endhighlight %}

Why is this bad?

A1: Prone to object slicing
if we had some object that became subclassed by tiger, then 


A2: 
Can't access superclass's private attrivutes.
Even if the class has now subclasses but is a subclass of something with private 
attributes, we can neither read nor write those attributes from the scope of this class.

A3: A connanscene issue
Even if the class has no subclasses, it's still a connascenec issue: If the classes defn' ever changes,
we have to change to method 


----- Stuff ----

------

