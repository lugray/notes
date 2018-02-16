---
layout: post
title:  "Duck Typing"
---
My primary development language at the moment is Ruby, but I've been learning Go.  Languages have varying ways of dealing with different types of objects in the same way, and I always find myself thinking about these kinds of variation when learning a new language.  The concept of duck typing (based on the idea that if it quacks like a duck, it's a duck) is used in Ruby:

```ruby
class Mallard
  def quack
    puts 'QUACK!'
  end
end

class Pekin
  def quack
    puts 'quack.'
  end
end

[Mallard.new, Pekin.new].each(&:quack)
```

`Mallard` and `Pekin` both quack, so even though they're different classes, we can use them in the same way.  In Java, this would be accomplished through the use of an interface:

```java
interface Duck {
   public void quack();
}

class Mallard implements Duck {
  public void quack() {
    System.out.println("QUACK!");
  }
}

class Pekin implements Duck {
  public void quack() {
    System.out.println("quack.");
  }
}

public class Quack {
  public static void main(String arg[]) {
    Duck[] ducks = {new Mallard(), new Pekin()};
    for (int i = 0; i < ducks.length; i++) {
      ducks[i].quack();
    }
  }
}
```

Go uses interfaces too, but slightly differently:

```go
package main

import "fmt"

type Duck interface {
  Quack()
}

type Mallard struct{}
type Pekin struct{}

func (m Mallard) Quack() {
  fmt.Println("QUACK!")
}

func (p Pekin) Quack() {
  fmt.Println("quack.")
}

func main() {
  ducks := []Duck{Mallard{}, Pekin{}}
  for _, duck := range ducks {
    duck.Quack()
  }
}
```

And here's the cool part about how Go uses interfaces:  take a look at the definitions for `Mallard` and `Pekin` again.  Neither one calls itself a duck.  That happens automatically, by the fact that they implement `Quack()`, and that's all the `Duck` interface asks for.  They `Quack()` like `Duck`s, and therefore, they're `Duck`s.  This differs from the Java implementation in which each class had to explicitly call out the fact that they can be treated as `Duck`s.  This, to me, seem like what Go has is truer duck-typing than Ruby.  Why?  Take another look at the Ruby implementation.  What's missing from it? _Any mention anywhere of the name `duck`_.  Ruby doesn't give a name to the grouping, only the behaviour.  Go has duck-typing, Ruby has quack-typing.
