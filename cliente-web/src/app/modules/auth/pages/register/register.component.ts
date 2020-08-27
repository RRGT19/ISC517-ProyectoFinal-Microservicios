import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../auth.service';
import {Router} from '@angular/router';
import {first} from 'rxjs/operators';

@Component({
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    public authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.initForm();
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.form.controls;
  }

  initForm() {
    this.form = this.fb.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
      name: [null, Validators.required],
      email: [null, Validators.required]
    });
  }

  /**
   * Executed When Form Is Submitted
   */
  onSubmit() {
    // Stop here if form is invalid
    if (this.form.invalid) {
      return;
    }

    this.authService.register(this.form.value)
      .pipe(first())
      .subscribe(res => this.router.navigate(['/auth/login']));
  }

}
