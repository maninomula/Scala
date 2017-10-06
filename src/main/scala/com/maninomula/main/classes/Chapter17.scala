package com.maninomula.main.classes

object Chapter17 extends App {
  var colors = List("red","blue","green")
  colors.head
  colors.tail
  val fiveInts = new Array[Int](5)
  var fiveToOne = Array(1,2,3,4,5)
  fiveInts(0) = fiveToOne(4)
  println(fiveInts)
  
  import scala.collection.mutable.ListBuffer
  val buf = new ListBuffer[Int]
  buf+=1
  buf+=2
  println(buf)
  3 +=: buf
  buf.toList  
  
  import scala.collection.mutable.ArrayBuffer
  
  val buf1 = new ArrayBuffer[Int]
  buf1+=1
  buf1==2
  println(buf1)
  buf1.length
  buf1(0)
  
  def hasUpperCase(s:String) = s.exists(_.isUpper)
  println(hasUpperCase("Robert Frost"))
  println(hasUpperCase("e e cummings"))
  
  import scala.collection.mutable
  val mutaSet = mutable.Set(1,2,3)
  val text = "See Spot Run. Run, Spot, See!"
  val wordsArrray = text.split("[ !,.]+")
  val words = mutable.Set.empty[String]
  for(word<-wordsArrray){
    words += word.toLowerCase
  }
  println(words)
  
  val map = mutable.Map.empty[String,Int]
  val nums = Set(1,2,3)
  nums+5
  nums-3
  println(nums++List(5,6))
  println(nums--List(1,2))
  println(nums&Set(1,3,5,7))
  println(nums.size)
  println(nums.contains(3))
  
  val words1 = mutable.Set.empty[String]
  words1 += "the"
  println(words1)
  words1 -= "the"
  println(words1)
  words1++=List("do","re","mi")
  println(words1.toString())
  words--=List("do","re")
  println(words1.toString())
  words.clear
  println(words1.toString())
  
  
  map("hello") = 1
  map("there") = 2
  println(map)
  println(map("hello"))
  
  def countWords(text:String)={
    val counts = mutable.Map.empty[String,Int]
    for(rawWord<-text.split("[ .!,]+")){
      val word = rawWord.toLowerCase
      val oldCount = 
        if(counts.contains(word)) counts(word)
        else 0 
        counts+=(word->(oldCount+1))
    }
    counts
  }
  println(countWords("See spot Run! Run, Spot, Run!"))
  
  val nums1 = Map("i"->1,"ii"->2)
  println(nums1.toString)
  println(nums1+ ("vi"-> 6))
  println(nums1-"ii")
  println(nums++List("iii"->3,"v"->5))
  println(nums1.size)
  println(nums1.contains("ii"))
  println(nums1("ii"))
  println(nums1.keys)
  println(nums1.values)
  println(nums1.keySet)
  println(nums.isEmpty)
  
  val words2 = mutable.Map.empty[String,Int]
  println(words2+=("one"->1))
  println(words2-="one")
  println(words2++=List("one"->2,"two"->2,"three"->3))
  println(words2--=List("one","two"))
  
  import scala.collection.immutable.TreeSet
  val ts = TreeSet(9,3,1,8,0,2,7,4,6,5)
  val cs = TreeSet('f','u','n')
  println(ts)
  println(cs)
  
  import scala.collection.immutable.TreeMap
  var tm = TreeMap(3->'x',1->'x',4->'x')
  println(tm += (2->'x'))
  println(tm)
  
  var people = Set("Nancy","Jane")
  people += "Bob"
  println(people)
  people-="Jane"
  people++=List("tom","Harry")
  println(people)
  
  var capital = mutable.Map("US"->"Washington","France"->"Paris")
  capital += ("Japan"->"Tokyo")
  println(capital("France"))
  
  var roughPi = 3.0
  roughPi +=0.1
  roughPi += 0.04
  println(roughPi)
  
  List(1,2,3)
  Set('s','a','c')
  mutable.Map("hi"->2,"there"->2)
  Array(1.0,2.0,3.0)
  
  //val stuff = mutable.Set(42)
  
  val stuff = mutable.Set[Any](42)
  stuff += "Abracadabra"
  
  val colors1 = List("blue","yellow","red","green")
  //val ts2 = TreeSet(colors)
  val ts2 = TreeSet[String]()++colors
  ts2.toList
  ts2.toArray
  val mutaSet1 = mutable.Set.empty ++= ts2
  val immutaSet =Set.empty++mutaSet1
  val muta = mutable.Map('i'->1,'j'->2)
  val immu = Map.empty++muta
  def longestWord(words:Array[String])={
    var word = words(0)
    var idx = 0
    for(i<- 1 until words.length)
      if(words(i).length >word.length){
        word = words(i)
        idx = i
          (word,i)
      }
      
    }
   
  
   val longest = longestWord("The quick brown fox".split(" "))
   println(longest)
  
}