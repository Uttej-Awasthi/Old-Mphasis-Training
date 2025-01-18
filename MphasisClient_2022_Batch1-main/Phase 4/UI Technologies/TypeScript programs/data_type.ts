let a :number =10;
//a="Raju";
let fname:string ="Raj";
let result : boolean = true;
let msg:any = 100;
msg="Raju";

console.log("Value of a "+a);
console.log("Value of fname is "+fname);
console.log("Value of result is "+result);
console.log("Value of msg is "+msg);

let num:Array<number>=[10,20,30,40,50];
//num.push(60);
//num.push("Ravi");
console.log("retreive elements using in loop")      // index position 
for(let i in num){
    console.log(i+" "+num[i])
}
console.log("retreive elements using of loop")      // it give value 
for(let n of num){
    console.log(n);
}
console.log("using for each function");
num.forEach(v=>console.log(v));

num.map(n=>n+100).forEach(v=>console.log(v));