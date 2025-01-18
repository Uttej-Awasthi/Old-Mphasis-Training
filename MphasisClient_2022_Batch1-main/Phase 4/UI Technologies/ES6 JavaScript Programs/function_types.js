// normal function 
function display1() {
    document.write("Normal function <br/>");
}
display1();
display1();
//Expression style function with function body with name
let display3 = function display2() {
                document.write("<br/> Expression function style")
            }
display3();
display3();
// Expression style funtion with function body without name
let display4 = function() {
    document.write("<br/> Expression style function ")
}
display4();
//IIFE Function style 
(function(){
    document.write("<br/>IIFE Style function")
})();
// Arrow function : ES6 
let display5 = ()=>document.write("<br/>This simple arrow function");
display5();
// Addition of two number using express style 
let addNumber1 = function(a,b){
    var sum = a+b;
    return sum;
}
document.write("<br/>Addition of two number using expression style "+addNumber1(10,20));
// Additin of two number using arrow style 
let addNumber2 = (a,b)=>a+b;    // it return value by default without return keyword. 
document.write("<br/> Addition of two number using arrow style "+addNumber2(10,20));
// find larges of two number using expression style 
let findLargest1 = function(a,b){
    if(a>b){
        return "a is largest"
    }else {
        return "b is largest"
    }
}
document.write("<br/>"+findLargest1(10,5));
let findLargest2 = (a,b)=> {
        if(a>b){
            return "a is largest";
        }   else {
            return "b is largest";
        }
}
document.write("<br/> "+findLargest2(10,5));

function greeting(fname,callback){
        return "Welcome "+callback(fname);
}
//Normal style 
function maleInfo(fname){
    return "Mr "+fname;
}
// express style 
let femaleInfo = function(fname){
    return "Miss "+fname;
}

document.write("<br/>"+greeting("Raj",maleInfo));
document.write("<br/>"+greeting("Seeta",femaleInfo));
document.write("<br/>"+greeting("Ajay",function(fname){
    return "Mr "+fname;
}))
document.write("<br/>"+greeting("Meeta",(fname)=>"Welcome "+fname))
