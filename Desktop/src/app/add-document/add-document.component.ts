import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Docs, DocserviceService } from '../docservice.service';

@Component({
  selector: 'app-add-document',
  templateUrl: './add-document.component.html',
  styleUrls: ['./add-document.component.css']
})
export class AddDocumentComponent implements OnInit {

  file: File;
  // retrievedFile: any;
  // base64Data: any;
  // retrieveResonse: any;
  message: string;
  

  constructor(private docservice: DocserviceService, private router: Router) { }

  ngOnInit(): void {
  }
  public onFileChanged(event) {
    this.file = event.target.files[0];
  }

  
  onSubmit(adddoc : Docs): any {
    console.log(adddoc);
    // this.docservice.addDoc(adddoc).subscribe((response) => {
      // if (response.status === 200) {
      //   this.message = 'Document uploaded successfully';
      // } else {
      //   this.message = 'Document not uploaded successfully';
      // }
      this.docservice.addDoc(adddoc).subscribe(data => {
        alert(data.body);
      this.router.navigate(['/about']);
    });
  }

}

