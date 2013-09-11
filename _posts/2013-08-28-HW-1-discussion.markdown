---
layout: post
title:  "HW1 discussion"
date:   2013-08-28 13:06:49
categories: hw HW
---

 A great answer will capture:
* the client of a FM wants an instance of a type - it does not specify which implemention it wants
* the cliet of BorderFactory wants ( and reqests) a specifc implementation of type Border.

Q: Since the progarmmer ultimately chooses the CCreator (concrete creator) (and thus implicitly the CProduct), 
is the use of a FM "morally equivalent" to a programmer choosing a Border class with a call to the BorderFactory  

A1: assume BF v. PFM
* BF can return a shared object
* FM intent is that it returns a _new_ object  

A2: assume BF v. FM  
* BF can return a shared object
* FM intent is that it returns a new object
