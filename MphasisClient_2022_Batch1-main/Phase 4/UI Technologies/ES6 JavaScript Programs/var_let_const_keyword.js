document.write("Welcome to External JS File<br/>")
var a=10;
a=20;       // re-assign 
var a=30;
let b =10;
b=20;
//let b=30;             Error  we can't do re-declaration 
document.write("Value of a "+a);
document.write("<br/>")
for(var i=0;i<100;i++){

}
document.write("i "+i);
for(let j=0;j<100;j++){

}
document.write("<br/>")
//document.write("j "+j)  // we can't use outside a block 
const k=200;
//k=300;                    // we can't change the value. 