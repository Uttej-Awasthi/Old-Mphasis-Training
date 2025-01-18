// export class Employee {
//     id:number=0;
//     name:string=""
//     age:number=0
//     constructor(id:number,name:string,age:number){
//         this.id = id;
//         this.name = name;
//         this.age = age;
//     }
// }
// This class is use to map to json data when we retrieve from backend technologies rest API
export class Employee {
    // id:number=0;
    // name:string=""
    // age:number=0
    constructor(public id:number,public name:string,public age:number){}
}