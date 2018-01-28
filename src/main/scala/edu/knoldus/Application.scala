package edu.knoldus

import java.util.Scanner

import org.apache.log4j.Logger

import scala.collection.immutable.ListMap

object Application extends App{

  val log = Logger.getLogger(getClass)
  val input = new Scanner(System.in)
  val db: Map[Int, Product] = Map()
  val user = new UserOperations
  val admin = new AdminOperations
  val id = 0

  def adminMenu(db: Map[Int, Product]): Unit = {
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
        val newDb = admin.addOrUpdateProduct(db, newItem, id + 1)
        adminMenu(newDb)
      case 2 =>
        admin.viewProducts(db)
        log.info("\nEnter id: ")
        val id = input.nextInt()
        val newDb = admin.deleteProduct(db, id)
        adminMenu(newDb)
      case 3 =>
        log.info("\nEnter id for which you want to update: ")
        val id = input.nextInt()
        log.info("\nEnter Product New Name: ")
        val productName = input.next()
        log.info("\nEnter Product New Price: ")
        val productPrice = input.nextInt()
        val newItem = Product(productName, productPrice)
        val newDb = admin.addOrUpdateProduct(db, newItem, id)
        adminMenu(newDb)
      case 4 =>
        admin.viewProducts(db)
      case 5 =>
        userMenu(db)
      case _ =>
        log.info("Wrong choice")
        adminMenu(db)
    }
  }

  def userMenu(db: Map[Int, Product]): Unit = {
    log.info("\n1. View all Products")
    log.info("\n2. Add to Cart")
    log.info("\n3. Delete from Cart")
    log.info("\n4. View Cart")
    log.info("\n5. Checkout")
    val choice = input.nextInt()
    choice match {
      case 1 =>
        log.info("")
      case 2 =>
      case 3 =>
      case 4 =>
      case 5 =>
      case _ =>
    }
  }

  def mainMenu(): Unit = {
    log.info("\n1. User Mode")
    log.info("\n2. Admin Mode")
    log.info("\nEnter your choice: ")
    val choice = input.nextInt()
    choice match {
      case 1 => userMenu(db)
      case 2 => adminMenu(db)
      case _ => log.info("Wrong choice")
    }
  }

//  val list = map3.values.toList
//  log.info(ListMap(map3.toSeq.sortWith(_._2.price < _._2.price): _*))
//  obj.viewProducts(map3)

}
