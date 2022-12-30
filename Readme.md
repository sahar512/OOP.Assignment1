

##  OOP -Assignment 1


- Observer Design Pattern :
  
  - Observer design pattern is useful when we are interested in the state of an object and want to get notified whenever there is any change. In observer pattern, the object that watch on the state of another object are called Observer and the object that is being watched is called Subject



- Concrete Member: 

  - The ConcreteMember class implement the Member interface , which describes the recipient of the updates (observer), the class contains the sallow copy of the UndoableStringBuilder. 


- Group Admin : The GroupAdmin class implement the Sender interface , which describe the sender of the updates (observerable) , each GroupAdmin has a UndoableStringBuilder object and an Arraylist object of all registed members.    