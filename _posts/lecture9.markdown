---
layout: post
title:  "Lecture 9"
date:   2013-09-11 13:06:49
categories: template method
---

# Administrivia  
* Nothing new

# Template Method (325)

## Implementation (cont.)

### Modifiers * methods  
Q: Which access modifiers (in languages which support them) should be used with 
the TM an dthe operations it calls?
  
  
| modifier       |      method    |
| ---------------|---------------:|
| public/protect | concrete (when generaly useful, not TM specific) |
| protected      | hook           |
| abstract protected | primitive  |
| private final  | invariant steps (concrete methods that _are_ TM specifc) |


    
