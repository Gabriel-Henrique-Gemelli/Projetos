import { Component } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-musicas',
  templateUrl: './musicas.component.html',
  styleUrls: ['./musicas.component.scss']
})


export class MusicasComponent {
  audioURL!: SafeUrl

  constructor(private sanitizer: DomSanitizer) {}
  ngOnInit(){
    const audioURL = 'src/assets/dendelion.mp3'
    this.audioURL = this.sanitizer.bypassSecurityTrustUrl(audioURL)
  }

}
