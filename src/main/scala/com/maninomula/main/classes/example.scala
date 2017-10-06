package com.maninomula.main.classes

class example {

  class Product(val id: Int, var name: String) {}

  var p = new Product(1, "pencil")
  println(p.id)
  println(p.name)
  p.name = "Pen"
  println(p.name)
  val emp1: Employee = new Employee(1001, "Chris Ford")
  val emp2: Employee = new Employee(1001, "Amy Smith", 6000.0, true)
  emp2.contractor = true
  emp2.updatePay(1000.0, 250.0)

  val empList: List[Employee] = List(emp1, emp2)

  for (emp <- empList) {
    println(emp.name + " = " + emp.totalPay)
  }

}
class Employee(val empId: Int, var name: String) {

  val gender = "M"
  var contractor = false

  var salary = 0.0
  var bonus = 0.0

  def this(id: Int, name: String, salary: Double, contractor: Boolean) = {
    this(id, name)
    this.contractor = contractor
    this.salary = salary
  }

  def totalPay: Double = {

    this.salary + this.bonus
  }
  def updatePay(salary: Double, bonus: Double): Unit = {

    this.salary = salary
    this.bonus = bonus
  }
  override def toString: String = {
    return "ID = " + empId + ", Name = " + name +
      ", gender = " + gender + ", Contractor = " + contractor +
      ", salary = " + salary + ", Bonus = " + bonus
  }

}

class Cat{
  val dangerous = false
}
class Tiger(override val dangerous:Boolean, private var age: Int) extends Cat
 