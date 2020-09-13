# Game of Thrones

## Context

We are working on the design of a mobile game based on the world of Game Of Thrones, which requires a statistics module on the geographical regions of this saga, the places, and the houses (families) that live there.

Said module will use a relational database embedded in the device, which will be exclusively accessed from the application.

Currently we have an object model already designed, of which we have the following class diagram and some clarifications:

![img uml](http://www.plantuml.com/plantuml/img/TLDBRjim4Dtp58Eid0Bo0OoYW1iZG84uBMht06Dgh1AWIM58PT7FaRhejbjVhCEHPLbsiX78-RptvWrbFQO4NwbnCS1F4-9XnxI0JMON6cCnPUTzJBDxYL4srdKrrbJkvTh6dKShhTkOqPUYJo6RtyPOXNt0X08AS0KBqAAS3Z6usBS0uF5lVEn2hN13iEzxwXhap-mQ2eMtnpYJQBQmZ2IE2ybhY6V1jqfrK5LhCMGdOsuZCwL1on1TTunUcguHr9b9_ueUue5Ow6v0LhIHKuTyaSlYrehMaSNAKhE0LUnsdWg72vbuZvRWiIF-WMldNUx71ineaPSpDU9-LBIb8ZypJKHjefTlJ6FTCxwWdzHyHBQN5KjYmkbeZ4qCf3MdnrDL7tJX2obA-4MMP5sBtkWZ69ClyXNxLZGcxjxTJSSofb_g-rzLDMpcCgHM6sEcNaXAtiZtNCqh5NoJdbSwwYlnirNcfAfhHPSoBg8-lFEKFKKlMWkC_3IPGECGzwVtQA0BuFNOTbIJ0S6N2mLnW1qcCPCLKao4cTXySKtKDmL8qMChMvqR2ZKKeckwVZS6lWM4lGu6XvEBq19d2YIl1aKEml5VS1PrFtDu4t4q0vQ-aRwa7Kb-dfgFVp2KNmqAC9yOqq0fuWVK_m00)


* The application does not need to query for all the places in a region. Instead they are normally asked for either all the castles in a region, or for all its cities, and the total population of the region
* The application does not need to query for the place of origin of a house, but only for its name.
* Both houses and regions implement a Foundable interface, which allows treating them polymorphically according to the yearFoundation () message.
* In one place several houses can originate, and these can be the main house of several regions



## A) To ORM

Propose a relational data model that allows the given object model to persist, detail how the mapping would be carried out, and justify the decisions made on the following aspects:

* If changes had to be made to the object model
* If any inheritance mapping strategy was used, or some @MappedSuperclass
* If some entity was embedded (@Embeddeded) or enumerated (@Enumerated)
* If any particular consideration was taken to maintain order or duplicates in collections
* If any database object such as constraints, triggers, views or procedures was used


## B) Denormalization

We detected that the houseImportant method represents a bottleneck in our application:

```java

class RepositorioRegiones 
  //una casa es importante si es la principal de una región
  // muy poblada y además es rica
  metodo casasImportantes
      em.createQuery("from Region")
           .list()
           .filter(region => region.poblacionTotal > 5000)
           .map(region => region.casaPrincipal)
           .filter(casa => casa.esRica)
```

```java
class Casa
 metodo esRica
  patrimonio > 10000
 ```

```java
class Region
  metodo poblacionTotal
    em.createQuery(..obtener las poblaciones de cada lugar...)
      .list()
      .sum()
```



Explain at what points it would make sense to apply denormalization to alleviate the problem and what strategies could be used to maintain data consistency.

Consider that the heritage of the house, the population of the places and the main house of a region can change.


## C) MVVM 

We need a form that allows us to search for regions by name:


To develop it we will use an MVVM framework. Indicate:
* which widgets (visual components) we should use
* the events involved
* the view model interface
* the bindings involved



