import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Docs, DocserviceService } from '../docservice.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-add-document',
  templateUrl: './add-document.component.html',
  styleUrls: ['./add-document.component.css']
})
export class AddDocumentComponent implements OnInit {
  reactiveForm: FormGroup;
  id: number;
  title: string;
  category: string;
  public file: any = File;
  message: string;
  filestatus: Response;
  
  

  constructor(private docservice: DocserviceService, private router: Router) { }

  ngOnInit() {
    this.reactiveForm = new FormGroup({
      id: new FormControl(),
      title: new FormControl(),
      category: new FormControl()
    });
  }

  public onFileChanged(event) {
    this.file = event.target.files[0];
  }

  
  saveDoc(submitForm: FormGroup): any {
    const user = submitForm.value;
    console.log(user);
    const formData = new FormData();
    formData.append('user', JSON.stringify(user));
    formData.append('file', this.file);
    this.docservice.addDoc(formData).subscribe((data) => {
      this.filestatus=data;
      if (this.filestatus.status === 200) {
          this.message = 'Document uploaded successfully';
        } else {
          this.message = 'Document not uploaded successfully';

        this.router.navigate(['app-dashboard'])
      }

    },
      error => {
        this.message = "*all fields are required";
      }
    );

  }
}

     

