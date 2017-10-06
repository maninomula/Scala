package com.maninomula.testing.traits

object practice {
  trait shipping{
      var shipCost = 12.0
      var shipMethod = "Ground"
      var contractype:String = "Gold"
      def computeShipTime():Int = {
        if(shipMethod=="air")
          5
        else
          10
      }
      def computeShipCost
      def computeContractPrice:Double = {
			if ( contractype.equals("Platinum")) {
				100
			}
			else {
				50
			}
      }
    
  }
  trait servicing{
    var contractDuration:Int = 12
		var contractType:String = "Gold"

		def computeContractPrice:Double = {
			if ( contractType.equals("Platinum")) {
				100
			}
			else {
				50
			}
		}
  }
  
  class Laptop extends shipping with servicing{
     
		var brand:String = "HP"
		var price:Double = 1000.0
		
		def computeTax:Double = {
			( price  + this.computeContractPrice ) * 0.08
		}
		def computeShipCost = {
			this.shipCost= 25
		}
  override def computeShipTime():Int = {
        if(shipMethod=="air")
          5
        else
          10
      }
  override def computeContractPrice:Double = {
			if ( contractType.equals("Platinum")) {
				100
			}
			else {
				50
			}
		}
  }
}