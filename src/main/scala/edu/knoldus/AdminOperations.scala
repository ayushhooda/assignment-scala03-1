package edu.knoldus

class AdminOperations {

  // Adding/Updating a Product
  def addOrUpdateProduct(db: Map[Int, Product], itemToAdd: Product, id: Int): Map[Int, Product] = {
    db + (id -> itemToAdd)
  }

  // Deleting a Product
  def deleteProduct(db: Map[Int, Product], id: Int): Map[Int, Product] = {
    db - id
  }

  // View Products
  def viewProducts(db: Map[Int, Product]): Unit = {
    db.foreach {
      case (id, item) => print(s"\n$id     ${item.name}     ${item.price}")
    }
  }

}
