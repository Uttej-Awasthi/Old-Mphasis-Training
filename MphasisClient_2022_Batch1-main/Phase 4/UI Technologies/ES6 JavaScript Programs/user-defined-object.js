// literal style : if you want only property 
let emp = {id:100,name:"Ravi",age:21};  // it is literal style but not json. 
document.write("Object in Literal style<br/>")
document.write("<br/> Id is "+emp.id);
document.write("<br/> Name is "+emp.name);
document.write("<br/> age is "+emp.age);
// function style with property and behaviour in ES5 
document.write("<br/> Function style object creation <br/>")
document.write("<br/> For every object common property and behaviour ")

// function Employee() {  
//     this.id = 100;              // instance variable. this keyword we have to use while declaring 
//     this.name = "Ravi";         // instane variable 
//     this.age = 21;
//     this.displayInfo = function() {         // behaviour 
//         document.write("<br/> Id is "+this.id);
//         document.write("<br/> Name is "+this.name);
//         document.write("<br/> AGe is "+this.age);
//     }
// }
// var emp1 = new Employee();          // creating the memory 
// emp1.displayInfo();                 // calling the function 
// var emp2 = new Employee();
// emp2.displayInfo();
// document.write("<br/> Object creation using class tyle")
// class Customer {
//         id=100;
//         name="Ramesh";
//         age=21;
//         disCustInfo() {
//             document.write("<br/>Id is "+this.id);
//             document.write("<br/>name is "+this.name);
//             document.write("<br/>age is "+this.age);
//         }   
// }
// let c1 = new Customer();
// c1.disCustInfo();
// let c2 = new Customer();
// c2.disCustInfo();
document.write("<br/> For every object with property ")
function Employee(id,name,age) {      
    this.id = id;              // instance variable. 
    this.name = name;
    this.age =age;
    this.displayInfo = function() {         // behaviour 
        document.write("<br/> Id is "+this.id);
        document.write("<br/> Name is "+this.name);
        document.write("<br/> AGe is "+this.age);
    }
}
var emp1 = new Employee(1,"Ravi",21);          // creating the memory 
emp1.displayInfo();                 // calling the function 
var emp2 = new Employee(2,"Ramesh",22);
emp2.displayInfo();
//creating the object from ES6 onward using class with constructor 
document.write("<br/> Object creation using class tyle")
class Customer {
        // id=0;
        // name=""
        // age=0;
       constructor(id,name,age){
        this.id = id;
        this.name = name;
        this.age=age    
       }
        disCustInfo() {
            document.write("<br/>Id is "+this.id);
            document.write("<br/>name is "+this.name);
            document.write("<br/>age is "+this.age);
        }   
}
let c1 = new Customer(1,"Ravi",21);
c1.disCustInfo();
let c2 = new Customer(2,"Ramesh",22);
c2.disCustInfo();
