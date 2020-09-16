import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-hash-display',
  templateUrl: './hash-display.component.html',
  styleUrls: ['./hash-display.component.css']
})
export class HashDisplayComponent implements OnInit {

  @Input("hash")
  hash: String;

  constructor() { }

  ngOnInit(): void {

  }

}
