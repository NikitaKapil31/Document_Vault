import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  constructor(private httpClient: HttpClient) { }
  ngOnInit(): void {

  }

  selectedFile: File;
  retrievedFile: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  FileId: any;

 

  getFiles(){
    this.httpClient.get('http://localhost:8777/doc/getFiles')
      .subscribe(
        res => {
          console.log(res);
          // this.retrieveResonse = res;
          // this.base64Data = this.retrieveResonse.picByte;
          // this.retrievedFile = 'data:image/png;base64,' + this.base64Data;
        }
      );
  }
  //Gets called when the user clicks on retieve image button to get the image from back end
  getImage() {
    //Make a call to Spring Boot to get the Image Bytes.
    this.httpClient.get('http://localhost:8777/doc/getFile/' + this.FileId)
      .subscribe(
        res => {
          console.log(res);
          // this.retrieveResonse = res;
          // this.base64Data = this.retrieveResonse.picByte;
          // this.retrievedFile = 'data:image/png;base64,' + this.base64Data;
        }
      );
  }
}
