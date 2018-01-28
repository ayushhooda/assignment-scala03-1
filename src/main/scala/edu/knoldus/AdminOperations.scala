package edu.knoldus

class AdminOperations {

  // Adding/Updating a Product
  def addOrUpdateProduct(map: Map[Int, Product], itemToAdd: Product, id: Int): Map[Int, Product] = {
    map + (id -> itemToAdd)
  }

  // Deleting a Product
  def deleteProduct(map: Map[Int, Product], id: Int): Map[Int, Product] = {
    map - id
  }

  // View Products
  def viewProducts(map: Map[Int, Product]): Unit = {
    map.foreach {
      case (id, item) => print(s"\n$id     ${item.name}     ${item.price}")
    }
  }

}
