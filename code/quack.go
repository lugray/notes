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
