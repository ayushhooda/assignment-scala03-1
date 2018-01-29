package edu.knoldus

class UserOperations {

  // User Login
  def isValidUser(username: String, password: String): Boolean = {
    (username, password) match {
      case ("Knoldus", "12345") => true
      case _ => false
    }
  }

  // Add to Cart
  def addToCart(cart: Map[Int, Product], item: Product, id: Int): Map[Int, Product] = {
    cart + (id -> item)
  }

  // Remove from Cart
  def removeFromCart(cart: Map[Int, Product], id: Int): Map[Int, Product] = {
    cart - id
  }

  // Checkout
  def checkout(list: List[Product]): Int = {
    def innerCalculate(list: List[Product], sum: Int): Int = {
      list match {
        case head :: tail => innerCalculate(tail, sum + head.price)
        case Nil => sum
      }
    }

    innerCalculate(list, 0)
  }

  def viewCart(cart: Map[Int, Product]): Unit = {
    cart.foreach {
      case (id, item) => print(s"\n$id     ${item.name}     ${item.price}")
    }
  }

}
