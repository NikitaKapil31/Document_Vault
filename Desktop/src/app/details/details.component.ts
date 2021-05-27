import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Docs, DocserviceService } from '../docservice.service';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
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
   
  }
  
  
