var a = 10;
//a="Raju";
var fname = "Raj";
var result = true;
var msg = 100;
msg = "Raju";
console.log("Value of a " + a);
console.log("Value of fname is " + fname);
console.log("Value of result is " + result);
console.log("Value of msg is " + msg);
var num = [10, 20, 30, 40, 50];
//num.push(60);
//num.push("Ravi");
console.log("retreive elements using in loop"); // index position 
for (var i in num) {
    console.log(i + " " + num[i]);
}
console.log("retreive elements using of loop"); // it give value 
for (var _i = 0, num_1 = num; _i < num_1.length; _i++) {
    var n = num_1[_i];
    console.log(n);
}
console.log("using for each function");
num.forEach(function (v) { return console.log(v); });
num.map(function (n) { return n + 100; }).forEach(function (v) { return console.log(v); });
