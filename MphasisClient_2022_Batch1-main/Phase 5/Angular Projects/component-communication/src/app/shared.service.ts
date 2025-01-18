import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'    // by default service class consider as singleton.
})
export class SharedService {

  stdNames:Array<string>=[];
  
  constructor() { }

  setNames(stdNames:Array<string>): void {
    this.stdNames=stdNames
  }

  getNames():Array<string> {
    return this.stdNames;
  }
}
