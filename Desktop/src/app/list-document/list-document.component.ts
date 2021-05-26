import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Docs, DocserviceService } from '../docservice.service';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-list-document',
  templateUrl: './list-document.component.html',
  styleUrls: ['./list-document.component.css']
})
export class ListDocumentComponent implements OnInit {
  message: string;
  docs : Docs[];
  doclist: any;
  searchValue: string;
  constructor(private docservice: DocserviceService, private router: Router) {
  }

  ngOnInit(): any {
    this.docservice.getAllDocs().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  getDocs(docs : Docs){
    this.docservice.getDoc(docs.id).subscribe(
      (blob => saveAs(blob, docs.docName))
    );
  }

  handleSuccessfulResponse(response) {
    this.docs = response;
  }
  delete(deleteDoc: Docs): any {
    var selction = confirm("Are you sure !!")
    if (selction == true) {
      this.docs.splice(this.docs.indexOf(deleteDoc), 1);
      this.docservice.delete(deleteDoc.id).subscribe(data => {
        alert(data);
      });
    }
    this.router.navigate(['/dashboard']);
  }

  // updateDoc(updateDoc: Docs): any {
  //   this.router.navigate(['/update-component'], { state: { updateDoc } });
  // }
  
  updateDoc(id: number) {
    this.docservice.getDoc(id)
      .subscribe(
        data => {
          this.doclist = data
        },
        error => console.log(error));
  }
 
}

