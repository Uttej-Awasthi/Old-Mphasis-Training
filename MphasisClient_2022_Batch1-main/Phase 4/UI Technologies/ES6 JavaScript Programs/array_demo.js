let arr1 = [];                  //literal style 
let arr2 = new Array();         //memory creation style 
document.write("<br/> Size of the array "+arr1.length);
document.write("<br/> Size of the array "+arr2.length);
arr1.push(10);
arr1.push(20);      // it add the element add the last 
arr1.push(30);
arr1.push(40);
arr1.unshift(100);
arr1.unshift(200);     // it add the element at the begining
arr1.unshift(300);
arr1.unshift(400);
document.write("<br/> "+arr1.length)
document.write("<br/>"+arr1)        // it display all element as a string 
arr1.pop();     // remove from last 
arr1.shift();   // remove from the begining 
// splice : This method is use  to add, replace and remove element from middle from a array 
document.write("<br/> "+arr1);
//arr1.splice(2,1);           // 1st parameter index position from that position 2nd number of element to delete
//arr1.splice(2,2);           // from 2nd index position remove 2 elements
//arr1.splice(2,0,1111);  // 1st parameter index position , 2nd parameter number of elements and 3rd parameter add elements. 
arr1.splice(2,1,1111);      // replace 2nd position number by 1111.
document.write("<br/> "+arr1);
// document.write("<br/>"+arr1)    // it display all element as a string 
// document.write("<br/> Display element one by one using loop")
// for(let i=0;i<arr1.length;i++){
//     document.write("<br/>"+arr1[i])
// }
// // passing function name to display the value one by one 1st approach 
// arr1.forEach(display)
// function display(n){
//     document.write("<br/> Value of array "+n);
// }
// // passing the function body using expression style 2nd approach ES5 style 
// arr1.forEach(function(n){
//     document.write("<br/> Value of array using expression style "+n)
// })
// // passing the function body using expression style 3rd apporach ES6 style 
// arr1.forEach((n)=>document.write("<br/> VAlue of array usign arrow style "+n));
