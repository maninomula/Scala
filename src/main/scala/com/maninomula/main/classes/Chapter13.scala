package com.maninomula.main.classes

object Chapter13 {
  
}
package bobsrockets {
  package navigation {

    class Navigator

    package tests {

      class NavigatorSuite
    }
  }

  package bobsrockets {
    package navigation {
      class Navigator {
        val map = new StarMap
      }
      class StarMap
    }
    class Ship {
      val nav = new navigation.Navigator
    }
    package fleets {
      class Fleet {
        def addShip() = { new Ship }
      }

      //  package bobsrockets {
      class Ship
    }

    package bobsrockets.fleets {
      class Fleet {
        // Doesn't compile! Ship is not in scope.
        def addShip() = { new Ship }
      }
    }
  }

  package launch {
    class Booster3

    package bobsrockets {
      package navigation {
        package launch {
          class Booster1
        }
        class MissionControl {
          val booster1 = new launch.Booster1
          val booster2 = new bobsrockets.launch.Booster2
          //    val booster3 = new _root_.launch.Booster3
        }
      }
      package launch {
        class Booster2
      }
    }
  }
}

// package bobsdelights

abstract class Fruit(
  val name: String,
  val color: String)

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple, Orange, Pear)

  def showFruit(fruit: Fruit) = {
    import fruit._
    println(name + "s are " + color)
  }

}

class Outer {
  class Inner {
    private def f() = { println("f") }
    class InnerMost {
      f() // OK
    }
  }
  //   (new Inner).f() // error: f is not accessible
}

package p {
  class Super {
    protected def f() = { println("f") }
  }
  class Sub extends Super {
    f()
  }
  class Other {
    //    (new Super).f()  // error: f is not accessible
  }
}

// package bobsrockets

package navigation {
  private class Navigator {
    protected[navigation] def useStarChart() = {}
    class LegOfJourney {
      private[Navigator] val distance = 100
    }
    private[this] var speed = 200
  }
}
package launch {
  import navigation._
  object Vehicle {
    //   private[launch] val guide = new Navigator
  }
}

// In file bobsdelights/package.scala
package object bobsdelights {
  def showFruit(fruit: Fruit) = {
    import fruit._
    println(name + "s are " + color)
  }

  // In file PrintMenu.scala
  // package printmenu
  //import bobsdelights.Fruits
  //import bobsdelights.showFruit

  object PrintMenu {
    def main(args: Array[String]) = {
      for (fruit <- Fruits.menu) {
        showFruit(fruit)
      }
    }
  }

}