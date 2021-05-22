import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Docs, DocserviceService } from '../docservice.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-update-document',
  templateUrl: './update-document.component.html',
  styleUrls: ['./update-document.component.css']
})
export class UpdateDocumentComponent implements OnInit {
  obj1: any;
  docs: Docs[];
  message: string;

  constructor(private docservice: DocserviceService, private router: Router) { 
    this.obj1 = this.docservice.updateMethod();
  }

  ngOnInit(): void {
  }

}
