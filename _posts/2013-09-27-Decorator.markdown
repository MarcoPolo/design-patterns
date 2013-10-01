---
layout: post
title:  "Decorator"
date:   2013-09-25 13:06:49
categories: prototype
---

#Decorator (175)

## Participants (alternative to what appears in the GoF)
_CoreCompononet_    
_Decorator_  
_ConcreteDecorator_
  

Overrides _specific_ __Component__ operation(s)


  
#Observations
## Decorators can be chained   

Client -> CDecoratorA => CDecoratorB => CComponent

Examples of this, in Java, include
* Using a JScrollPane to decorate another JComponent
* Borders
* IOStreams

# Where the pattern has been applied
Most uses of the __Decorator__ pattern have been in "system software" as opposed to
being used to model domains. [ in a moment, we'll se an example of using them to 
model a domain. ]


# Boilerplate reduce
Sometimes we just want to say, "This is how X differs from Y."

As with the boilerplate example covered in our __Prototype__ discussion, our insurance 
company will have three standard policies (Basic, Deluxe, & Premium). Clients can 

t customized version, varying the coverage, add/removing events, modyfing

## Process for customizing a policy
Step 1 
instantiate a concrete SLIP - e.g., a BasicSLIP
* Set the attribute values (policyNumber, &c. and info about the __InsuredPart__)
* as part of the contruction process, the Map will be populated with default values

  
Step 2: Wrap in a Decorator 
customize the SLIP for the desired coverate by wrapping it with a __SLIPDecorator__
on which the desired policy endorsements have been set

On the `Decorator` 
    SetCoverate( tattoEvent, new Policy(100%, $100000) );
    setCoverate( infectedPiercingEvent, newPolicy( 0%, $0) );

Note: the first shows how to add/change an endorsement, the second shows how to remove one.


Step 3: give teh decorated SLIP to the client

The client will know only the _decorated_ SLIP, which implements `getCoverate()` as 
    Police getCoverate( Event e ) {
        Policy p = map.get (e);
        if ( p = null ) 
            p = slip.getCoverage(e);

        return p;
    }

# Comments
A SLIPDecorator stores the _differences_ between the original and modified components
* pro: no copying needed - reduces storage cost ( the  `CSIP` might even be sharable!)   
* pro: easy to identify what has changed relative to the boilerplate object, because
  all the differences a(and only the diffs) are encapsulated in the __Decorator__(s)
* pro: decorators can be chained
