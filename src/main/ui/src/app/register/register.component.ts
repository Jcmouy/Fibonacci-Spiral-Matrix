import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import Validation from '../utils/validation';
import { AuthService } from '../_services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  form: FormGroup;
  submitted = false;

  constructor(
      private formBuilder: FormBuilder,
      private authService: AuthService,
      private router: Router) {}

  ngOnInit(): void {
    this.form = this.formBuilder.group(
        {
          username: [
            '',
            [
              Validators.required,
              Validators.minLength(6),
              Validators.maxLength(20)
            ]
          ],
          email: ['', [Validators.required, Validators.email]],
          password: [
            '',
            [
              Validators.required,
              Validators.minLength(6),
              Validators.maxLength(40)
            ]
          ],
          confirmPassword: ['', Validators.required]
        },
        {
          validators: [Validation.match('password', 'confirmPassword')]
        }
    );
  }

  get f(): { [key: string]: AbstractControl } {
      return this.form.controls;
  }

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  onSubmit(): void {
    this.submitted = true;
    this.authService.register(this.form.value.username, this.form.value.email, this.form.value.password).subscribe(
        data => {
          console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
            setTimeout(() => {
                this.router.navigate(['/login']);
                }, 4000);
        },
        err => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
        }
    );
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }

}
