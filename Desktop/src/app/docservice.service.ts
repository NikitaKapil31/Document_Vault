import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DocserviceService {
  updateDocs: Docs;
  constructor(private httpService: HttpClient) { }

  public getDoc(id : number) {
    console.log("ins service get docs" + id);
    // const headers = new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.get<Docs>("http://localhost:8777/doc/getFile/" + id );
  }

  public addDoc(adddoc: Docs) {
    console.log("in service add");
    console.log(adddoc);
    const headers = new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post("http://localhost:8777/doc/uploadFiles", adddoc, { headers, responseType: 'text' })
      
  }


}
export class Docs {
  id: number;
  title: string;
  category: string;
  file: File
}
