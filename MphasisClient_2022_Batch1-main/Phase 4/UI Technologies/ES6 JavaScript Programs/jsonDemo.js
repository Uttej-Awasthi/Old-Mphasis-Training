let emp = {id:100,name:"Ravi",age:21};
document.write("<br> Object in Literal style")
document.write("<br/> Id is "+emp.id);
document.write("<br/> name is "+emp.name);
document.write("<br/> age is "+emp.age);


//let empJson = JSON.parse(emp);
let empString = JSON.stringify(emp);        // it convert object into string format. 
document.write("<br/> String Object <br/>")
document.write("<br/> Id is "+empString.id);
document.write("<br/> name is "+empString.name);
document.write("<br/> age is "+empString.age);

let empJson = JSON.parse(empString);        // it convert string to json object format. 
document.write("<br/> JSON Object <br/>")
document.write("<br/> Id is "+empJson.id);
document.write("<br/> name is "+empJson.name);
document.write("<br/> age is "+empJson.age);