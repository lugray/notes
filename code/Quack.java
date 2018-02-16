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
