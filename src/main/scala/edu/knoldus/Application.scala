package edu.knoldus

import java.util.Scanner

import org.apache.log4j.Logger

import scala.collection.immutable.ListMap

object Application extends App{

  val log = Logger.getLogger(getClass)
  val input = new Scanner(System.in)
  val db: Map[Int, Product] = Map()
  val cart: Map[Int, Product] = Map()
  val user = new UserOperations
  val admin = new AdminOperations
  var id = 0

  adminMenu(db, cart)

  def adminMenu(db: Map[Int, Product], cart: Map[Int, Product]): Unit = {
    log.info("\n1. Add a Product")
    log.info("\n2. Delete a Product")
    log.info("\n3. Update a Product")
    log.info("\n4. View all Products")
    log.info("\n5. User Mode")
    log.info("\nEnter your choice: ")
    val choice = input.nextInt()
    choice match {
      case 1 =>
        log.info("\nEnter Product Name: ")
        val productName = input.next()
        log.info("\nEnter Product Price: ")
        val productPrice = input.nextInt()
        val newItem = Product(productName, productPrice)
        id = id + 1
        val newDb = admin.addOrUpdateProduct(db, newItem, id)
        adminMenu(newDb, cart)
      case 2 =>
        admin.viewProducts(db)
        log.info("\nEnter id: ")
        val id = input.nextInt()
        val newDb = admin.deleteProduct(db, id)
        adminMenu(newDb, cart)
      case 3 =>
        log.info("\nEnter id for which you want to update: ")
        val id = input.nextInt()
        log.info("\nEnter Product New Name: ")
        val productName = input.next()
        log.info("\nEnter Product New Price: ")
        val productPrice = input.nextInt()
        val newItem = Product(productName, productPrice)
        val newDb = admin.addOrUpdateProduct(db, newItem, id)
        adminMenu(newDb, cart)
      case 4 =>
        admin.viewProducts(db)
        adminMenu(db, cart)
      case 5 =>
        userMenu(db, cart)
      case _ =>
        log.info("Wrong choice")
        adminMenu(db, cart)
    }
  }

  def userMenu(db: Map[Int, Product], cart: Map[Int, Product]): Unit = {
    log.info("\n1. View all Products")
    log.info("\n2. Add to Cart")
    log.info("\n3. Delete from Cart")
    log.info("\n4. View Cart")
    log.info("\n5. Checkout")
    log.info("\n6. Admin Mode")
    val choice = input.nextInt()
    choice match {
      case 1 =>
        admin.viewProducts(db)
        userMenu(db, cart)
      case 2 =>
        admin.viewProducts(db)
<<<<<<< HEAD
        log.info("\nEnter id of product")
        val id = input.nextInt()
        val item = db.getOrElse(id, null)
        if(item != null)
        user.addToCart(cart, item, id)
        userMenu(db, cart)
      case 3 =>
        user.viewCart(cart)
        log.info("\nEnter id of product to be removed")
=======
        log.info("\nSelect id of Product to be added")
        val selectedId = input.nextInt()
        val item = db.getOrElse(selectedId, null)
        val newCart = user.addToCart(cart, item, selectedId)
        userMenu(db, newCart)
      case 3 =>
        admin.viewProducts(db)
        log.info("\nEnter id: ")
>>>>>>> 3fb6a8986006ef071b991beb2008174de6fc7f16
        val id = input.nextInt()
        val newCart = user.removeFromCart(cart, id)
        userMenu(db, newCart)
      case 4 =>
        user.viewCart(cart)
        userMenu(db, cart)
      case 5 =>
<<<<<<< HEAD
        user.viewCart(cart)
        val list = cart.values.toList
        val total = user.checkout(list)
        log.info(s"\nTotal net bill: $total")
        userMenu(db, cart)
      case _ =>
=======
        user.checkout()
      case 6 =>
        adminMenu(db, cart)
      case _ =>
        log.info("Wrong choice")
        userMenu(db, cart)
>>>>>>> 3fb6a8986006ef071b991beb2008174de6fc7f16
    }
  }

//  val list = map3.values.toList
//  log.info(ListMap(map3.toSeq.sortWith(_._2.price < _._2.price): _*))
//  obj.viewProducts(map3)

}
