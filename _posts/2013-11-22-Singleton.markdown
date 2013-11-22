---
layout: post
title:  Singleton
---

# Intent
Ensure that a class has only one instance and provide a global point of access
to it.

# Motivation
To ensure correctness and/or security.

## Alternative to a class that only has static members  
Class with only static members is inflexible.
Imagine some point in the future, the design requirements change, and multiple
instances _are_ needed. Code written in terms of static operations will need to
be rewritten.

## Canonical implmentation

```
Class Singleton {
    Static private Singleton instance = new Singleton();

    static publicSingleton getInstance () { return Singleton.instance; }

    private Singleton() { 
      ...
    }

    //other operations elided
}
```

## Often you'll see an lazy init

```
class Singleton { 
  ... getInstance(){
    if (Singleton.instance === null) {
      Singleton.instance = new Singleton();
    }
  }

}
```

## Neither for is thread safe (in Java).

# Monostate
An alternative to Singleton

Idea: rahter than having one shared instance of a class, we can have multiple
instances as long as they share the same data.

