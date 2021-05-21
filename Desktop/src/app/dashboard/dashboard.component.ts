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

  //Gets called when the user selects an image
  // public onFileChanged(event) {
  //   //Select File
  //   this.selectedFile = event.target.files[0];
  // }


  // //Gets called when the user clicks on submit to upload the image
  // onUpload() {
  //   console.log(this.selectedFile);

  //   //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
  //   const uploadData = new FormData();
  //   uploadData.append('File', this.selectedFile, this.selectedFile.name);

  //   //Make a call to the Spring Boot Application to save the image
  //   this.httpClient.post('http://localhost:8777/doc/uploadFiles', uploadData, { observe: 'response' })
  //     .subscribe((response) => {
  //       if (response.status === 200) {
  //         this.message = 'Document uploaded successfully';
  //       } else {
  //         this.message = 'Document not uploaded successfully';
  //       }
  //     }
  //     );


  // }

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
