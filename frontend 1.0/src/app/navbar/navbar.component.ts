import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(private router:Router) {}

  callFunction() {
    this.router.navigate(['/login']);
    }

    GoToRegister(){
      this.router.navigate(['/register']);
    }
}
