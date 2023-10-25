import { Component } from '@angular/core';
import { SignUpRequest } from '../model/SignUpRequest';
import { UserService } from '../service/UserService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  signUpRequest: SignUpRequest = new SignUpRequest();
  //registrationSuccessful = false;


  constructor(private userService: UserService, private route:Router) { }


  registerUser(signUpData: SignUpRequest): void {

    this.userService.registerUser(signUpData).subscribe({

      next: (response) => {

        console.log('Registration successful:', response);
        //this.registrationSuccessful = true;
        //this.route.navigate(['/login']);
      },

      error: (error) => {

        console.error('Registration failed:', error);

      }

    });

  }
  navigateToLogin(): void {
    this.route.navigate(['/login']); // Assuming '/login' is the route for your login page
  }
}
