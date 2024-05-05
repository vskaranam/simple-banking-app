import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {CustomerModel} from "../../models/customer.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {CustomerPageModel} from "../../models/customerPage.model";
import {AuthService} from "../auth-service/auth.service";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private host: string = 'http://34.171.17.158:30005/v2/customers';

  constructor(private http: HttpClient, private authService: AuthService) { }

  private getHeader() :HttpHeaders {
    // let jwt: string = this.authService.getToken();
    // jwt = "Bearer "+jwt;
    return new HttpHeaders({"access-control-allow-origin": "*"});
  }

  public getById(id: string) :Observable<CustomerModel>{
    return this.http.get<CustomerModel>(this.host + '/get/' + id);
  }

  public save(model: CustomerModel) :Observable<CustomerModel>{
    let httpHeaders: HttpHeaders = this.getHeader();
    return this.http.post<CustomerModel>(this.host + '/save', model, {headers:httpHeaders});
  }

  public update(id: string, model: CustomerModel) :Observable<CustomerModel>{
    let httpHeaders: HttpHeaders = this.getHeader();
    return this.http.put<CustomerModel>(this.host + '/update/' + id, model, {headers:httpHeaders});
  }

  public searchAll(keyword: string, page: number, size: number) :Observable<CustomerPageModel>{
    let httpHeaders: HttpHeaders = this.getHeader();
    return this.http.get<CustomerPageModel>(this.host + '/' + page +'/' + size + '/search?keyword=' + keyword, {headers:httpHeaders});
  }

}
